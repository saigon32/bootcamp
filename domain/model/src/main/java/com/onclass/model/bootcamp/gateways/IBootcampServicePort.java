package com.onclass.model.bootcamp.gateways;

import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcampServicePort {
    Mono<Bootcamp> createBootcamp(Bootcamp bootcamp);

    Mono<Bootcamp> getBootcampById(Integer id);
}
