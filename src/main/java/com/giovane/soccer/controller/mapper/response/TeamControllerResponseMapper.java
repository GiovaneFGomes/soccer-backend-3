package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.service.model.response.TeamServiceResponse;

public interface TeamControllerResponseMapper {

    static TeamControllerResponse toTeamControllerResponse(TeamServiceResponse teamResponse) {
        if (teamResponse == null) {
            return null;
        }

        return TeamControllerResponse.builder()
                .id(teamResponse.getId())
                .name(teamResponse.getName())
                .stadium(teamResponse.getStadium())
                .country(teamResponse.getCountry())
                .player(teamResponse.getPlayer())
                .date(teamResponse.getDate())
                .build();
    }

}
