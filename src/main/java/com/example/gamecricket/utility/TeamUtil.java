package com.example.gamecricket.utility;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.entities.Role;
import com.example.gamecricket.entities.Team;

import java.util.Arrays;
import java.util.List;

public class TeamUtil {
    public static Team createTeam1(int firstTeamNo)
    {
        Team team1=new Team();
        team1.setTeamNo(firstTeamNo);
        Player p1=new Player(firstTeamNo,1, Role.BATSMAN,0,0,0,0,0);
        Player p2=new Player(firstTeamNo,2,Role.BATSMAN,0,0,0,0,0);
        Player p3=new Player(firstTeamNo,3,Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p4=new Player(firstTeamNo,4,Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p5=new Player(firstTeamNo,5,Role.WK_KEEPER, 0, 0, 0, 0, 0);
        Player p6=new Player(firstTeamNo,6,Role.ALL_ROUNDER, 0, 0, 0, 0, 0);
        Player p7=new Player(firstTeamNo,7,Role.ALL_ROUNDER, 0, 0, 0, 0, 0);
        Player p8=new Player(firstTeamNo,8,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p9=new Player(firstTeamNo,9,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p10=new Player(firstTeamNo,10,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p11=new Player(firstTeamNo,11,Role.BOWLER, 0, 0, 0, 0, 0);
        List<Player> id= Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11);
        team1.setPlayers(id);
        return team1;
    }
    public static Team createTeam2(int secondTeamNo)
    {
        Team team2=new Team();
        team2.setTeamNo(secondTeamNo);
        Player p1=new Player(secondTeamNo,12, Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p2=new Player(secondTeamNo,13,Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p3=new Player(secondTeamNo,14,Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p4=new Player(secondTeamNo,15,Role.BATSMAN, 0, 0, 0, 0, 0);
        Player p5=new Player(secondTeamNo,16,Role.WK_KEEPER, 0, 0, 0, 0, 0);
        Player p6=new Player(secondTeamNo,17,Role.ALL_ROUNDER, 0, 0, 0, 0, 0);
        Player p7=new Player(secondTeamNo,18,Role.ALL_ROUNDER, 0, 0, 0, 0, 0);
        Player p8=new Player(secondTeamNo,19,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p9=new Player(secondTeamNo,20,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p10=new Player(secondTeamNo,21,Role.BOWLER, 0, 0, 0, 0, 0);
        Player p11=new Player(secondTeamNo,22,Role.BOWLER, 0, 0, 0, 0, 0);
        List<Player> id= Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11);
        team2.setPlayers(id);
        return team2;
    }
}
