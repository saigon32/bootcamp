package com.onclass.jpa.adapter.port;

import com.onclass.jpa.entity.BootcampEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IBootcampRepository extends ReactiveCrudRepository<BootcampEntity, Integer> {

}
