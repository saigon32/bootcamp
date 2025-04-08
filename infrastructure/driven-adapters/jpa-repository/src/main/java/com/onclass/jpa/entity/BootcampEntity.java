package com.onclass.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("bootcamp.bootcamp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BootcampEntity {
    @Id
    private Integer id;
    private String name;
    private String description;
}
