package com.example.food.service;

import com.example.food.domain.Food;
import com.example.food.dto.FoodRequestDTO;
import com.example.food.repository.FoodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository repository;

    public List<Food> getAllFoods() {
        return repository.findAllByActiveTrue();
    }

    public Food getFoodById(int id) {
        Optional<Food> optionalFood = repository.findById(id);
        if (optionalFood.isPresent()) {
            return optionalFood.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Food registerFood(FoodRequestDTO data) {
        Food food = new Food(data);
        repository.save(food);

        return food;
    }

    public Food updateFood(int id, FoodRequestDTO data) throws EntityNotFoundException {
        Optional<Food> optionalFood = repository.findById(id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setNome(data.nome());
            food.setValor(data.valor());
            repository.save(food);
            return food;
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }

    public Food patchFood(int id, FoodRequestDTO data) throws EntityNotFoundException {
        Optional<Food> optionalFood = repository.findById(id);
        if(optionalFood.isPresent()) {
            Food food = optionalFood.get();
            if (data.nome() != null) {
                food.setNome(data.nome());
            }

            if (data.valor() != null) {
                food.setValor(data.valor());
            }

            repository.save(food);
            return food;
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }

    public Food deleteFood(int id) throws EntityNotFoundException {
        Optional<Food> optionalFood = repository.findById(id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setActive(false);
            repository.save(food);
            return food;
        } else {
            throw new EntityNotFoundException("Entidade não encontrada.");
        }
    }
}
