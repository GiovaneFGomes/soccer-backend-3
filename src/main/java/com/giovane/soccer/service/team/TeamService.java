package com.giovane.soccer.service.team;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.entity.team.Team;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.team.TeamRepository;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<Team> save(Team team) {
        return repository.save(team);
    }

    public Mono<Team> addPlayer(String id, String playerId) {
        return null;
    }

    public Mono<Void> deleteById(String id) {
       return repository.deleteById(id);
    }

    public Mono<Team> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
    }

    public Flux<Team> findAll() {
        return repository.findAll();
    }

}
