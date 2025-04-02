package com.onclass.jpa.adapter;

import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapacityBootcampRequestDto {
    private Integer idBootcamp;
    private List<Integer> capacityIds;

}
