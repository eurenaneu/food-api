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
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> allFoods = this.foodService.getAllFoods();

        return new ResponseEntity<>(allFoods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable int id) {
        Food newFood = this.foodService.getFoodById(id);

        return new ResponseEntity<>(newFood, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> registerFood(@RequestBody @Validated FoodRequestDTO data) {
        Food newFood = this.foodService.registerFood(data);

        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable int id, @RequestBody @Validated FoodRequestDTO data) throws EntityNotFoundException {
        Food newFood = this.foodService.updateFood(id, data);

        return new ResponseEntity<>(newFood, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Food> patchFood(@PathVariable int id, @RequestBody @Validated FoodRequestDTO data) throws EntityNotFoundException {
        Food updatedFood = this.foodService.patchFood(id, data);

        return new ResponseEntity<>(updatedFood, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable int id) throws EntityNotFoundException {
        this.foodService.deleteFood(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
