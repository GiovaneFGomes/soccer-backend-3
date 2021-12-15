package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.repository.team.TeamRepository;
import com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<TeamServiceResponse> saveTeam(TeamServiceRequest teamRequest) {
        Team teamEntity = TeamServiceRequestMapper.toTeamEntity(teamRequest);
        Mono<Team> teamEntityMono = repository.save(teamEntity);
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<TeamServiceResponse> updateTeamById(TeamServiceRequest teamRequest, String id) {
        teamRequest.setId(id);
        Team teamEntity = TeamServiceRequestMapper.toTeamEntity(teamRequest);
        Mono<Team> teamEntityMono = repository.save(teamEntity);
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<Void> deleteTeamById(String id) {
       return repository.deleteById(id);
    }

    public Mono<TeamServiceResponse> findTeamById(String id) {
        Mono<Team> teamEntityMono = repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Flux<TeamServiceResponse> findAllTeams() {
        return repository.findAll()
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

}