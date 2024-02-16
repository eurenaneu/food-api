package com.example.food.controller;

import com.example.food.domain.Food;
import com.example.food.dto.FoodRequestDTO;
import com.example.food.service.FoodService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(@RequestParam(value = "active", defaultValue = "true") @Validated boolean active) {
        if (active) {
            return new ResponseEntity<>(this.foodService.getAllActiveFoods(), HttpStatus.OK);
        }

        return new ResponseEntity<>(this.foodService.getAllFoods(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        return this.foodService.getFoodById(id);
    }

    @PostMapping
    public ResponseEntity<Food> registerFood(@RequestBody @Validated FoodRequestDTO data) {
        Food newFood = this.foodService.registerFood(data);

        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Food updateFood(@PathVariable int id, @RequestBody @Validated FoodRequestDTO data) throws EntityNotFoundException {
        return this.foodService.updateFood(id, data);
    }

    @PatchMapping("/{id}")
    public Food patchFood(@PathVariable int id, @RequestBody @Validated FoodRequestDTO data) throws EntityNotFoundException {
        return this.foodService.patchFood(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable int id) throws EntityNotFoundException {
        this.foodService.deleteFood(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
