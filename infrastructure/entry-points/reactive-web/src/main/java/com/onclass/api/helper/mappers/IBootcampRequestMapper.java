package com.onclass.api.helper.mappers;

import com.onclass.api.helper.request.dto.BootcampRequestDto;
import com.onclass.model.bootcamp.Bootcamp;
import com.onclass.model.bootcamp.Capacity;
import com.onclass.model.bootcamp.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBootcampRequestMapper {

    @Mapping(target = "capacities", source = "capacities", qualifiedByName = "mapCapacitiesToIds")
    BootcampRequestDto toDto(Bootcamp bootcamp);

    @Mapping(target = "capacities", source = "capacities", qualifiedByName = "mapIdsToCapacities")
    Bootcamp toDomain(BootcampRequestDto bootcampRequestDto);

    @Named("mapCapacitiesToIds")
    default List<Integer> mapCapacitiesToIds(List<Capacity> capacities) {
        return capacities.stream()
                .map(Capacity::getId)
                .collect(Collectors.toList());
    }

    @Named("mapIdsToCapacities")
    default List<Capacity> mapIdsToCapacities(List<Integer> ids) {
        return ids.stream()
                .map(id -> new Capacity(id, null, null))
                .collect(Collectors.toList());
    }
}
