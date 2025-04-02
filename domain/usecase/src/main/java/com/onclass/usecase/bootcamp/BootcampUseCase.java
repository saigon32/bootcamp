package com.onclass.usecase.bootcamp;

import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.gateways.IBootcampPersistencePort;
import com.onclass.model.bootcamp.gateways.IBootcampServicePort;
import com.onclass.usecase.bootcamp.validations.BootcampCreateValidations;
import reactor.core.publisher.Mono;

public class BootcampUseCase implements IBootcampServicePort {
    private final IBootcampPersistencePort persistencePort;
    private final BootcampCreateValidations bootcampCreateValidations;

    public BootcampUseCase(IBootcampPersistencePort persistencePort, BootcampCreateValidations bootcampCreateValidations) {
        this.persistencePort = persistencePort;
        this.bootcampCreateValidations = bootcampCreateValidations;
    }

    public Mono<Bootcamp> createBootcamp(Bootcamp bootcamp) {
        return bootcampCreateValidations.validateBootcamp(bootcamp)
                .flatMap(persistencePort::saveBootcamp);
    }

    @Override
    public Mono<Bootcamp> getBootcampById(Integer id) {
        return persistencePort.findById(id);
    }

}
