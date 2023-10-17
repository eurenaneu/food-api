package com.example.food.domain;

import com.example.food.dto.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;
    private boolean active;

    public Food(FoodRequestDTO foodRequestDTO) {
        this.nome = foodRequestDTO.nome();
        this.valor = foodRequestDTO.valor();
        this.active = true;
    }
}
