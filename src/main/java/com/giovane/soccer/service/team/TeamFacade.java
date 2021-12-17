package com.giovane.soccer.service.team;

import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService service;

    public Mono<TeamServiceResponse> save(TeamServiceRequest teamServiceRequest) {
        return service.save(teamServiceRequest);
    }

    public Mono<TeamServiceResponse> updateById(TeamServiceRequest teamServiceRequest, String id) {
        return service.findById(id)
                .flatMap(val -> service.updateById(teamServiceRequest, val.getId()));
    }

    public Mono<Void> deleteById(String id) {
        return service.findById(id)
                .flatMap(val -> service.deleteById(val.getId()));
    }

    public Mono<TeamServiceResponse> findById(String id) {
        return service.findById(id);
    }

    public Flux<TeamServiceResponse> findAll() {
        return service.findAll();
    }

}
