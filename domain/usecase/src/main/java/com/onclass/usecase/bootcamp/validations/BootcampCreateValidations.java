package com.onclass.usecase.bootcamp.validations;

import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.Capacity;
import com.onclass.model.exception.BusinessErrorMessage;
import com.onclass.model.exception.BusinessException;
import com.onclass.model.bootcamp.Technology;
import reactor.core.publisher.Mono;
import static com.onclass.usecase.bootcamp.Constants.MAX_DESCRIPTION_LENGTH;
import static com.onclass.usecase.bootcamp.Constants.MAX_NAME_LENGTH;

public class BootcampCreateValidations {

    public Mono<Bootcamp> validateBootcamp(Bootcamp bootcamp) {
        return validateName(bootcamp)
                .then(validateDescription(bootcamp))
                .then(validateCapacitiesCount(bootcamp))
                .then(Mono.just(bootcamp));
    }

    private Mono<Void> validateName(Bootcamp bootcamp) {
        if (bootcamp.getName().length() > MAX_NAME_LENGTH) {
            return Mono.error(new BusinessException(BusinessErrorMessage.NAME_CHARACTERS_EXCEED));
        }
        if (bootcamp.getName().isEmpty()) {
            return Mono.error(new BusinessException(BusinessErrorMessage.MANDATORY_NAME));
        }
        return Mono.empty();
    }

    private Mono<Void> validateDescription(Bootcamp bootcamp) {
        if (bootcamp.getDescription().isEmpty()) {
            return Mono.error(new BusinessException(BusinessErrorMessage.MANDATORY_DESCRIPTION));
        }
        if (bootcamp.getDescription().length() > MAX_DESCRIPTION_LENGTH) {
            return Mono.error(new BusinessException(BusinessErrorMessage.DESCRIPTION_CHARACTERS_EXCEED));
        }
        return Mono.empty();
    }

    private Mono<Void> validateCapacitiesCount(Bootcamp bootcamp) {
        int bootcampCount = bootcamp.getCapacities() != null ? bootcamp.getCapacities().size() : 0;
        if (bootcampCount < 1 || bootcampCount > 4) {
            return Mono.error(new BusinessException(BusinessErrorMessage.INVALID_BOOTCAMP_COUNT));
        }
        return Mono.empty();
    }


}
