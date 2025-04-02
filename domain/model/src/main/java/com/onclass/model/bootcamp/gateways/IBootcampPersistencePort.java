package com.onclass.model.bootcamp.gateways;

import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcampPersistencePort {
    Mono<Bootcamp> saveBootcamp(Bootcamp bootcamp);

    Mono<Bootcamp> findById(Integer id);
}
