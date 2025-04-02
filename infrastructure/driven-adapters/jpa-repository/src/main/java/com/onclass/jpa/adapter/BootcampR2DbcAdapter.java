package com.onclass.jpa.adapter;

import com.onclass.jpa.adapter.port.IBootcampRepository;
import com.onclass.jpa.config.DBErrorMessage;
import com.onclass.jpa.config.DBException;
import com.onclass.jpa.entity.BootcampEntity;
import com.onclass.jpa.helper.IBootcampEntityMapper;
import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.gateways.IBootcampPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class BootcampR2DbcAdapter implements IBootcampPersistencePort {

    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Override
    public Mono<Bootcamp> saveBootcamp(Bootcamp bootcamp) {

        BootcampEntity bootcampEntity = bootcampEntityMapper.toEntity(bootcamp);
        return bootcampRepository.save(bootcampEntity)
                .map(bootcampEntityMapper::toModel)
                .onErrorResume(DuplicateKeyException.class, ex -> Mono.error(new DBException(DBErrorMessage.BOOTCAMP_ALREADY_EXISTS)));
    }

    @Override
    public Mono<Bootcamp> findById(Integer id) {
        return bootcampRepository.findById(id)
                .map(bootcampEntityMapper::toModel);
    }


}
