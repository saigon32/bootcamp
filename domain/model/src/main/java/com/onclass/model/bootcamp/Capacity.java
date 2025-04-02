package com.onclass.model.bootcamp;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Capacity {
    private Integer id;
    private String name;
    private List<Technology> technologies;

}
