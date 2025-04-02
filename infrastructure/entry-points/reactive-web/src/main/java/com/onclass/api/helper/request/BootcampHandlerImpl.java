package com.onclass.api.helper.request;

import com.onclass.api.helper.IBootcampHandler;
import com.onclass.api.helper.mappers.IBootcampRequestMapper;
import com.onclass.api.helper.mappers.IBootcampResponseMapper;
import com.onclass.api.helper.request.dto.BootcampRequestDto;
import com.onclass.model.bootcamp.Capacity;
import com.onclass.jpa.adapter.port.IBootcampWebClientPort;
import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.gateways.IBootcampServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.List;


@Component
@RequiredArgsConstructor
public class BootcampHandlerImpl implements IBootcampHandler {

    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;
    private final IBootcampWebClientPort bootcampWebClientPort;

    @Override
    public Mono<ServerResponse> createBootcamp(ServerRequest request) {
        return request.bodyToMono(BootcampRequestDto.class)
                .flatMap(bootcampRequestDto -> {
                    Bootcamp bootcamp = bootcampRequestMapper.toDomain(bootcampRequestDto);
                    List<Capacity> capacities = bootcamp.getCapacities();

                    return bootcampServicePort.createBootcamp(bootcamp)
                            .flatMap(createdBootcamp ->
                                    associateBootcampsWithCapacities(createdBootcamp.getId(), capacities)
                                            .then(Mono.just(createdBootcamp))
                            )
                            .flatMap(createdBootcamp ->
                                    ServerResponse.status(HttpStatus.CREATED)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue((createdBootcamp))
                            );
                });
    }
    private Mono<Void> associateBootcampsWithCapacities(Integer bootcampId, List<Capacity> capacities) {
        return bootcampWebClientPort.associateBootcampToCapacities(bootcampId, capacities);
    }
}
