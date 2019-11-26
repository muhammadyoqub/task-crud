package com.example.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "manufacturer"})
})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name, manufacturer;

    private Timestamp productionDate;

    public Car(String name, String manufacturer, Timestamp productionDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
    }
}
