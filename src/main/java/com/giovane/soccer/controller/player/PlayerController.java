package com.giovane.soccer.controller.player;

import lombok.*;
import javax.validation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/soccer/player")
public class PlayerController {

    private final PlayerControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<PlayerControllerResponse> save(@RequestBody @Valid PlayerControllerRequest playerControllerRequest) {
        return facade.save(playerControllerRequest);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/{id}")
    public Mono<PlayerControllerResponse> update(@RequestBody @Valid PlayerControllerRequest playerControllerRequest
                                                ,@PathVariable String id) {
        return facade.update(playerControllerRequest, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return facade.deleteById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<PlayerControllerResponse> findById(@PathVariable String id) {
        return facade.findById(id);
    }

    @ResponseStatus(OK)
    @GetMapping
    public Flux<PlayerControllerResponse> findAll() {
        return facade.findAll();
    }

}
