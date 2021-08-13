package com.example.gamecricket.services;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.entities.Player;
import com.example.gamecricket.repository.PlayerRepo;
import com.example.gamecricket.request_dto.PlayerRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.BatsmanResponse;
import com.example.gamecricket.response_dto.BowlerResponse;
import com.example.gamecricket.response_dto.PlayerSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private BallServiceImpl ballService;

    @Override
    public List<Player> getAllPlayers() {
        List<Player>players=new ArrayList<>();
        playerRepo.findAll().forEach(players::add);
        return players;
    }

    @Override
    public BaseResponse createPlayer(PlayerRequest playerRequest) {
        playerRepo.save(playerRequest.getPlayerFromDto());
        return new BaseResponse(true,"player added successfully",playerRequest.getPlayerFromDto());
    }

    @Override
    public BaseResponse updatePlayer(int id, Player player) {
        playerRepo.save(player);
        return new BaseResponse(true,"player updated successfully",player);
    }

    @Override
    public Player getPlayer(int id) {
        Optional<Player> player = playerRepo.findById(id);
        return player.orElseGet(Player::new);
    }

    @Override
    public BaseResponse createListPlayers(List<Player>players)
    {
        for(Player player:players)
        {
            playerRepo.save(player);
        }
        return new BaseResponse(true,"players added successfully",null);
    }
    @Override
    public BaseResponse deletePlayer(int id) {
        playerRepo.deleteById(id);
        return new BaseResponse(true,"player deleted  successfully",null);
    }

    public List<BatsmanResponse> getPlayersSummaryForBatsman(int matchNumber, int inningsNumber) {
        List<Ball> ballList = ballService.getBallsByMatchNumberAndInningsNumber(matchNumber, inningsNumber);
        Map<Integer, BatsmanResponse> hashMap = new HashMap<Integer, BatsmanResponse>();
        for (Ball ball : ballList) {
            if(hashMap.containsKey(ball.getStrikerId()))
            {
                hashMap.get(ball.getStrikerId()).setRunsScored(hashMap.get(ball.getStrikerId()).getRunsScored()+ ball.getRunsScored());
                hashMap.get(ball.getStrikerId()).setBallsPlayed(hashMap.get(ball.getStrikerId()).getBallsPlayed()+1);
            }
            else
            {
                BatsmanResponse playerResponse=new BatsmanResponse();
                playerResponse.setRunsScored(ball.getRunsScored());
                playerResponse.setPlayerNumber(ball.getStrikerId());
                playerResponse.setMatchNumber(matchNumber);
                playerResponse.setBallsPlayed(1);
                hashMap.put(ball.getStrikerId(),playerResponse);
            }
        }
        List<BatsmanResponse> playerResponses = new ArrayList<>();
        for(HashMap.Entry map: hashMap.entrySet()) {
            playerResponses.add((BatsmanResponse) map.getValue());
        }
        return playerResponses;
    }
    public List<BowlerResponse> getPlayersSummaryForBowler(int matchNumber, int inningsNumber)
    {
        List<Ball> ballList = ballService.getBallsByMatchNumberAndInningsNumber(matchNumber, inningsNumber);
        Map<Integer, BowlerResponse> hashMap = new HashMap<Integer, BowlerResponse>();
        int ballNo = 0;
        for (Ball ball : ballList) {
            if(hashMap.containsKey(ball.getBowlerId()))
            {
                hashMap.get(ball.getBowlerId()).setRunsGiven(hashMap.get(ball.getBowlerId()).getRunsGiven()+ ball.getRunsScored());
                if(ball.isWicketFall())
                    hashMap.get(ball.getBowlerId()).setWicketsTaken(hashMap.get(ball.getBowlerId()).getWicketsTaken()+1);
                if (ballNo==6)
                {
                    hashMap.get(ball.getBowlerId()).setOversBalled(hashMap.get(ball.getBowlerId()).getOversBalled()+1);
                    ballNo=1;
                }
            }
            else
            {
                BowlerResponse playerResponse1=new BowlerResponse();
                ballNo=1;
                playerResponse1.setRunsGiven(ball.getRunsScored());
                playerResponse1.setPlayerNumber(ball.getBowlerId());
                playerResponse1.setMatchNumber(matchNumber);
                 playerResponse1.setOversBalled(0);
                if(ball.isWicketFall())
                    playerResponse1.setWicketsTaken(1);
                hashMap.put(ball.getBowlerId(),playerResponse1);
            }
            ballNo++;
        }

        List<BowlerResponse> playerResponses = new ArrayList<>();
        for(HashMap.Entry map: hashMap.entrySet()) {
            playerResponses.add((BowlerResponse) map.getValue());
        }
        return playerResponses;
    }
    public PlayerSummary setPlayerSummaryForMatch(int matchNo, int inningsNo)
    {
        List<BatsmanResponse> batsmanResponses=getPlayersSummaryForBatsman(matchNo,inningsNo);
        List<BowlerResponse> bowlerResponses=getPlayersSummaryForBowler(matchNo,inningsNo);
        return new PlayerSummary(batsmanResponses,bowlerResponses);
    }
}
