package com.onclass.config;

import com.onclass.jpa.adapter.BootcampR2DbcAdapter;
import com.onclass.jpa.adapter.port.IBootcampRepository;
import com.onclass.jpa.helper.IBootcampEntityMapper;
import com.onclass.model.bootcamp.gateways.IBootcampPersistencePort;
import com.onclass.model.bootcamp.gateways.IBootcampServicePort;
import com.onclass.usecase.bootcamp.BootcampUseCase;
import com.onclass.usecase.bootcamp.validations.BootcampCreateValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Bean
    public IBootcampPersistencePort bootcampPersistencePort() {
        return new BootcampR2DbcAdapter(bootcampRepository, bootcampEntityMapper);
    }

    @Bean
    public BootcampCreateValidations validations() {
        return new BootcampCreateValidations();
    }


    @Bean
    public IBootcampServicePort bootcampServicePort(IBootcampPersistencePort bootcampPersistencePort, BootcampCreateValidations bootcampCreateValidations) {
        return new BootcampUseCase(bootcampPersistencePort, bootcampCreateValidations);
    }


}
