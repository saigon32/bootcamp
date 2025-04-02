package com.onclass.api.helper.request.dto;

import com.onclass.model.bootcamp.Technology;
import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapacityDto {
    private Integer id;
    private String name;
    private List<TechnologyDto> technologies;
}
