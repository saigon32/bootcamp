package com.onclass.jpa.helper;

import com.onclass.jpa.entity.BootcampEntity;
import com.onclass.model.bootcamp.Bootcamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBootcampEntityMapper {
    @Mapping(target = "id", source = "id")
    Bootcamp toModel(BootcampEntity entity);

    @Mapping(target = "id", source = "id")
    BootcampEntity toEntity(Bootcamp bootcamp);
}
