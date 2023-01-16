package me.lunev.homework35.controllers;

import me.lunev.homework35.model.Ingredient;
import me.lunev.homework35.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.getIngredient(id));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Ingredient>> getAllIngredients() {
        Map<Integer, Ingredient> listIngredients = ingredientService.getAllIngredients();
        if (listIngredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listIngredients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.editIngredient(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.deleteIngredient(id));
    }
}
