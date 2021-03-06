package com.example.gamecricket.services;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.entities.Player;
import com.example.gamecricket.entities.Role;
import com.example.gamecricket.interfaces.DecideNextPlayer;
import com.example.gamecricket.interfaces.PlayerAverageComparator;
import com.example.gamecricket.interfaces.PlayerEconomyComparator;
import com.example.gamecricket.repository.InningsRepo;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.utility.RandomGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

@Component
@Transactional
public class InningsServiceImpl implements InningsService{
    @Autowired
    private InningsRepo inningsRepo;

    @Autowired
    private  TeamServiceImpl teamService;

    @Autowired
    private BallServiceImpl ballService;

    @Autowired
    private  PlayerServiceImpl playerService;


    @Override
    public List<Innings> getAllInnings() {
        List<Innings>inningsList=new ArrayList<>();
        inningsRepo.findAll().forEach(inningsList::add);
        return inningsList;
    }

    @Override
    public BaseResponse createInnings(Innings innings) {
        inningsRepo.save(innings);
        return new BaseResponse(true,"innings added successfully",innings);
    }

    @Override
    public BaseResponse updateInnings(int id, Innings innings) {
        inningsRepo.save(innings);
        return new BaseResponse(true,"innings updated successfully",innings);
    }

    @Override
    public Innings getInnings(int id) {
        Optional<Innings> innings=inningsRepo.findById(id);
        return innings.orElseGet(Innings::new);
    }

    @Override
    public BaseResponse deleteInnings(int id) {
        inningsRepo.deleteById(id);
        return new BaseResponse(true,"innings deleted successfully",null);
    }

    public static void updateInfo(List<Player> battingTeamPlayers,int possibleRun,Innings innings,int strikerID)
    {
        innings.setTotalRuns(innings.getTotalRuns() + possibleRun);
        battingTeamPlayers.get(strikerID).setRunsScored(battingTeamPlayers.get(strikerID).getRunsScored()+possibleRun);
        if (possibleRun==4)
        {
            innings.setFours(innings.getFours() + 1);
            battingTeamPlayers.get(strikerID).setScored4(battingTeamPlayers.get(strikerID).getScored4()+1);
        }
        else if(possibleRun==6)
        {
            innings.setSixes(innings.getSixes() + 1);
            battingTeamPlayers.get(strikerID).setScored6(battingTeamPlayers.get(strikerID).getScored6()+1);
        }
    }
    public void startInnings(Innings innings,int targetRuns,boolean secondTeam,int overs)
    {
        createInnings(innings);
        List<Player>battingTeamPlayers=teamService.getTeamById(innings.getBattingTeamId()).getPlayers();
        List<Player>bowlingTeamPlayers=teamService.getTeamById(innings.getBowlingTeamId()).getPlayers();
        PriorityQueue<Player> pq1 = new PriorityQueue<Player>(11, new PlayerAverageComparator());
        PriorityQueue<Player> pq2 = new PriorityQueue<Player>(11, new PlayerEconomyComparator());
        for (Player player:battingTeamPlayers)
        {
            pq1.add(player);
        }
        System.out.println(pq1);
        innings.setChasing(secondTeam);
        int i,j;
        double strikeRate,average,economy;
        int decideBatsman=0,decideBowler=5;
        int strikerID=0,nonStrikerID=1;
        battingTeamPlayers.get(strikerID).setInningsPlayed(battingTeamPlayers.get(strikerID).getInningsPlayed()+1);
        battingTeamPlayers.get(nonStrikerID).setInningsPlayed(battingTeamPlayers.get(nonStrikerID).getInningsPlayed()+1);
        for( i=1;i<=overs;i++) {
            if(decideBowler>10) decideBowler=5;
            for (j = 1; j <= 6; j++) {
                if (innings.getWicketsDown() >= 10 || (secondTeam && targetRuns < innings.getTotalRuns())) {
                    break;
                }
                int possibleRun;
                 Ball ball =new Ball();
                 ball.setMatchNo(innings.getMatchNo());
                 ball.setBallNo(j);
                 ball.setInningsNo(innings.getInningsNo());
                 ball.setStrikerId(battingTeamPlayers.get(strikerID).getPlayerNo());
                 ball.setNonStrikerId(battingTeamPlayers.get(nonStrikerID).getPlayerNo());
                 ball.setOverNo(i);
                 ball.setBowlerId(bowlingTeamPlayers.get(decideBowler).getPlayerNo());
                if(battingTeamPlayers.get(strikerID).getRole().equals(Role.BATSMAN))
                    possibleRun =  RandomGeneratorUtil.indexUpperBound1();
                else{
                    possibleRun =RandomGeneratorUtil.indexUpperBound2();
                }
                ball.setRunsScored(possibleRun);
                ball.setWicketFall(false);
                battingTeamPlayers.get(strikerID).setBallsFaced(battingTeamPlayers.get(strikerID).getBallsFaced()+1);
                strikeRate=   ((double) (battingTeamPlayers.get(strikerID).getRunsScored())/(battingTeamPlayers.get(strikerID).getBallsFaced())*100);
                battingTeamPlayers.get(strikerID).setStrikeRate(strikeRate);
                average=(double) battingTeamPlayers.get(strikerID).getRunsScored()/battingTeamPlayers.get(strikerID).getInningsPlayed();
                battingTeamPlayers.get(strikerID).setAverage(average);
                if (possibleRun == -1) {
                    bowlingTeamPlayers.get(decideBowler).setWicketsTaken(bowlingTeamPlayers.get(decideBowler).getWicketsTaken()+1);
                    innings.setWicketsDown(innings.getWicketsDown() + 1);
                    decideBatsman=decideBatsman+1;
                    strikerID=(battingTeamPlayers.get(decideBatsman).getPlayerNo())%11;
                    ball.setRunsScored(0);
                    ball.setWicketFall(true);
                    battingTeamPlayers.get(strikerID).setInningsPlayed(battingTeamPlayers.get(strikerID).getInningsPlayed()+1);
                } else if (possibleRun == 0) {
                    innings.setDotBalls(innings.getDotBalls() + 1);
                } else if (possibleRun == 1 || possibleRun==3 || possibleRun==5) {
                    updateInfo(battingTeamPlayers,possibleRun,innings,strikerID);
                    int temp=strikerID;   strikerID=nonStrikerID;  nonStrikerID=temp;
                } else if (possibleRun == 2 || possibleRun==4 || possibleRun==6) {
                    updateInfo(battingTeamPlayers,possibleRun,innings,strikerID);
                }
                if(possibleRun!=-1)
                bowlingTeamPlayers.get(decideBowler).setRunsGiven(bowlingTeamPlayers.get(decideBowler).getRunsGiven()+possibleRun);
                economy=(double) bowlingTeamPlayers.get(decideBowler).getRunsGiven()/bowlingTeamPlayers.get(decideBowler).getOversBalled();
                bowlingTeamPlayers.get(decideBowler).setEconomy(economy);
                ballService.createBall(ball);
                updateInnings(innings.getInningsID(),innings);
                playerService.updatePlayer(battingTeamPlayers.get(strikerID).getPlayerID(),battingTeamPlayers.get(strikerID));
                playerService.updatePlayer(battingTeamPlayers.get(nonStrikerID).getPlayerID(),battingTeamPlayers.get(nonStrikerID));
                playerService.updatePlayer(bowlingTeamPlayers.get(decideBowler).getPlayerID(),bowlingTeamPlayers.get(decideBowler));
            }
            bowlingTeamPlayers.get(decideBowler).setOversBalled(bowlingTeamPlayers.get(decideBowler).getOversBalled()+1);
            int temp=strikerID;   strikerID=nonStrikerID;   nonStrikerID=temp;
            decideBowler=decideBowler+1;
        }
        innings.setBallsPlayed((overs*6)-innings.getDotBalls());
    }
    public Innings getInningsByMatchNoAndInningsNo(int matchNo,int inningsNo)
    {
        return inningsRepo.findByMatchNoAndInningsNo(matchNo,inningsNo);
    }
}