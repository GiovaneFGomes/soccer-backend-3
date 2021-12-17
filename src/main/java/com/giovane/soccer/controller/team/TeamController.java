package com.giovane.soccer.controller.team;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer/team")
public class TeamController {

    private final TeamControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<TeamControllerResponse> save(@RequestBody @Valid TeamControllerRequest teamRequest) {
        return facade.save(teamRequest);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/{id}")
    public Mono<TeamControllerResponse> updateById(@RequestBody @Valid TeamControllerRequest teamControllerRequest, @PathVariable("id") String id) {
        return facade.updateById(teamControllerRequest, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
       return facade.deleteById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<TeamControllerResponse> findById(@PathVariable("id") String id) {
        return facade.findById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/findAll") // TODO colocar outro nome -> findAll
    public Flux<TeamControllerResponse> findAll() {
        return facade.findAll();
    }

}
