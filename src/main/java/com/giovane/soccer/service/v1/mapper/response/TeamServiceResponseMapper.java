package com.giovane.soccer.service.v1.mapper.response;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.v1.model.response.TeamServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamServiceResponseMapper {

    static TeamServiceResponse toTeamServiceResponse(Team team){
        return Mappers.getMapper(TeamServiceResponseMapper.class)
                .mapper(team);
    }

    TeamServiceResponse mapper(Team team);

}