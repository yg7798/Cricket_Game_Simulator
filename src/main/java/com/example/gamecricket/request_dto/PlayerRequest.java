package com.example.gamecricket.request_dto;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {
    @NotNull(message = "player No is mandatory")
    private Integer playerNo;  // jersey no.
    @NotBlank(message = "Player Role is mandatory")
    private Role role;

    public Player getPlayerFromDto()
    {
         Player   player=new Player();
            player.setPlayerNo(playerNo);
            player.setRole(role);
        return player;
    }
}
