package com.giovane.soccer.entity.player;

import lombok.*;
import com.giovane.soccer.utils.Position;
import com.giovane.soccer.entity.team.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "players")
public class Player {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String nationality;
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
