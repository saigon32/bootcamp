package com.onclass.api.helper.mappers;

import com.onclass.api.helper.request.dto.BootcampResponseDto;
import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBootcampResponseMapper {
    BootcampResponseDto toDto (Bootcamp bootcamp);
    Technology toDomain (BootcampResponseDto bootcampResponseDto);
}
