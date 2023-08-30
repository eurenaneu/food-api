package com.example.food.controller;

import com.example.food.model.Food;
import com.example.food.model.FoodRepository;
import com.example.food.model.FoodRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    private static final String allowedOrigins = "http://localhost:5173";

    @CrossOrigin(origins = allowedOrigins, allowedHeaders = "*")
    @GetMapping
    public ResponseEntity getAllFoods() {
        var allFoods = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allFoods);
    }

    @CrossOrigin(origins = allowedOrigins, allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity getFoodById(@PathVariable int id) {
        Optional<Food> optionalFood = repository.findById(id);
        if(optionalFood.isPresent()) {
            Food newFood = optionalFood.get();
            return ResponseEntity.ok(newFood);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @CrossOrigin(origins = allowedOrigins, allowedHeaders = "*")
    @PostMapping
    public ResponseEntity registerFood(@RequestBody @Validated FoodRequestDTO data){
        Food newFood = new Food(data);
        repository.save(newFood);

        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = allowedOrigins, allowedHeaders = "*")
    @PutMapping
    @Transactional
    public ResponseEntity updateFood(@RequestBody @Validated FoodRequestDTO data){
        Optional<Food> optionalFood = repository.findById(data.id());
        if(optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setNome(data.nome());
            food.setValor(data.valor());
            return ResponseEntity.ok(food);
        } else {
            throw new EntityNotFoundException();
        }

    }

    @CrossOrigin(origins = allowedOrigins, allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteFood(@PathVariable int id) {
        Optional<Food> optionalFood = repository.findById(id);
        if(optionalFood.isPresent()){
            Food food = optionalFood.get();
            food.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
