package com.onclass.jpa.adapter.port;

import com.onclass.model.bootcamp.Capacity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IBootcampWebClientPort {

    Mono<Void> associateBootcampToCapacities(Integer bootcampId, List<Capacity> capacityIds);

}
