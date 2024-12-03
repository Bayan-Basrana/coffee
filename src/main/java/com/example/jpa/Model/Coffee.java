package com.example.jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;
    @NotNull(message = "price is empty")
    @Positive(message = "price must be Positive")
    @Min(value = 1,message = "price cannot be les than 1")
    @Column(columnDefinition = "int not null")
    private Integer price ;
    @NotEmpty(message = "category is empty")
    @Pattern(regexp = "drink|sweet")
    @Column(columnDefinition = "varchar(5) not null")
    private String category;
    @Column(columnDefinition = "int not null")
    private Integer employeeid;

}
