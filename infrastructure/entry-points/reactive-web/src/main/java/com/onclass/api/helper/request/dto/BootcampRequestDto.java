package com.onclass.api.helper.request.dto;

import com.onclass.model.bootcamp.Capacity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BootcampRequestDto {
    private String name;
    private String description;
    private List<Integer> capacities;
}
