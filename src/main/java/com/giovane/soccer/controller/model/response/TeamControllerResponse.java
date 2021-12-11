package com.giovane.soccer.controller.model.response;

import com.giovane.soccer.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerResponse {
    private String id;
    private String name;
    private String stadium;
    private String country;
    private List<Player> player;
    private LocalDate date;
}
