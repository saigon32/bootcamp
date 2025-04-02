package com.onclass.jpa.adapter;

import com.onclass.jpa.adapter.port.IBootcampWebClientPort;
import com.onclass.model.bootcamp.Capacity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
@Slf4j
public class CapacityWebClientAdapter implements IBootcampWebClientPort {
    private final WebClient webClient;

    public CapacityWebClientAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/capacity").build();
    }

    @Override
    public Mono<Void> associateBootcampToCapacities(Integer bootcampId, List<Capacity> capacities) {
        List<Integer> capacityIds = capacities.stream()
                .map(Capacity::getId)
                .toList();
        CapacityBootcampRequestDto requestDto = new CapacityBootcampRequestDto(bootcampId, capacityIds);

        return webClient.post()
                .uri("/capacityBootcamp")
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(Void.class);

    }

}
