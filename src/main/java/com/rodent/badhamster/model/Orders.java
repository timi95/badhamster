package com.rodent.badhamster.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
//    private Optional<Boolean> isSelected;

}
