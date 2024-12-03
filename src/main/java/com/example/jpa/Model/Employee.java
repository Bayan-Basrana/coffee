package com.example.jpa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "name is empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name ;
    @Positive(message = "age must be Positive")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
