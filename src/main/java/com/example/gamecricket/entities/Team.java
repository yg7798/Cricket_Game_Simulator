package com.example.gamecricket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "`team`")
public class Team extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamID;

    private String teamName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "team_player_map",joinColumns = @JoinColumn(name="teamID",referencedColumnName = "teamID"),inverseJoinColumns = @JoinColumn(name = "playerID",referencedColumnName = "playerID"))
    private List<Player> players;
}
