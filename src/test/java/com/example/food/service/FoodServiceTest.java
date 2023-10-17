package com.example.food.service;

import com.example.food.domain.Food;
import com.example.food.dto.FoodRequestDTO;
import com.example.food.repository.FoodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodServiceTest {
    @Mock
    private FoodRepository repository;

    @Autowired
    @InjectMocks
    private FoodService foodService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create food succesfully when everything is okay")
    void registerFood() {
        FoodRequestDTO data = new FoodRequestDTO(1, "Cookie", 125.90); // cria dados da comida teste
        Food expectedFood = new Food(data); // cria comida teste com os dados

        when(repository.save(expectedFood)).thenReturn(expectedFood); // testa se o retorno corresponde com o objeto salvo

        Food actualFood = foodService.registerFood(data);

        assertEquals(expectedFood, actualFood); // testa se o resultado do método é igual ao objeto criado

        verify(repository, times(1)).save(any(Food.class)); // verifica se o repository foi chamado 1 vez
    }

    @Test
    @DisplayName("Should update food with the correct data when entity exists")
    void updateFoodCase1() {
        FoodRequestDTO data = new FoodRequestDTO(1, "Feijão", 30.00);
        Food oldFood = new Food(1, "Cookie", 125.90, true);

        when(repository.findById(1)).thenReturn(Optional.of(oldFood));

        Food expectedFood = this.foodService.updateFood(1, data);

        verify(repository, times(1)).save(any(Food.class));
        assertEquals(data.nome(), expectedFood.getNome());
        assertEquals(data.valor(), expectedFood.getValor());
    }

    @Test
    @DisplayName("Should throw exception when updating food")
    void updateFoodCase2() {
        FoodRequestDTO data = new FoodRequestDTO(1, "Feijão", 30.00);
        Food oldFood = new Food(1, "Cookie", 125.90, true);

        when(repository.findById(oldFood.getId())).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> this.foodService.updateFood(1, data));

        assertEquals("Entidade não encontrada.", thrown.getMessage());
    }

    @Test
    @DisplayName("Should partially update food with the correct data when entity exists")
    void patchFoodCase1() {
        FoodRequestDTO data = new FoodRequestDTO(null, null, 999.90);
        Food oldFood = new Food(1, "Cookie", 125.90, true);

        when(repository.findById(1)).thenReturn(Optional.of(oldFood));

        Food expectedFood = this.foodService.patchFood(1, data);

        verify(repository, times(1)).save(any(Food.class));
        assertEquals(data.valor(), expectedFood.getValor());
    }

    @Test
    @DisplayName("Should throw exception when partially updating food")
    void patchFoodCase2() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> this.foodService.patchFood(1, any()));

        assertEquals("Entidade não encontrada.", thrown.getMessage());
    }

    @Test
    @DisplayName("Should delete food when entity exists")
    void deleteFoodCase1() {
        Food oldFood = new Food(1, "Cookie", 125.90, true);

        when(repository.findById(any())).thenReturn(Optional.of(oldFood));

        Food expectedFood = this.foodService.deleteFood(1);

        verify(repository, times(1)).save(any(Food.class));
        assertEquals(oldFood.isActive(), expectedFood.isActive());
    }

    @Test
    @DisplayName("Should throw exception when deleting food")
    void deleteFoodCase2() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        EntityNotFoundException thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> this.foodService.deleteFood(1));

        assertEquals("Entidade não encontrada.", thrown.getMessage());
    }
}