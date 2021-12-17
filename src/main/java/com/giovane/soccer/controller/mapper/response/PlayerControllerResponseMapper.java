package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

public interface PlayerControllerResponseMapper {

    static PlayerControllerResponse toPlayerControllerResponse(PlayerServiceResponse playerResponse) {
        if (playerResponse == null) {
            return null;
        }

        return PlayerControllerResponse.builder()
                .id(playerResponse.getId())
                .name(playerResponse.getName())
                .age(playerResponse.getAge())
                .nationality(playerResponse.getNationality())
                .actualTeam(playerResponse.getActualTeam())
                .number(playerResponse.getNumber())
                .position(playerResponse.getPosition())
                .height(playerResponse.getHeight())
                .build();
    }

}
