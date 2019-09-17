package com.kurs.coding_one.animals.food;

import com.kurs.coding_one.animals.animal.AnimalFamily;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Fridge {

    private List<Food> foods = new LinkedList<>();

    public Set<Food> getFoodForAnimal(AnimalFamily animalFamily) {
        return foods.stream().filter(food -> food.getType().containsAnimal(animalFamily)).collect(Collectors.toSet());
    }

    public void addProduct(Food food) {
        foods.add(food);
    }

    public int refillFridge() {
        return foods.stream().map(Food::refillAndGetCost).reduce(0, Integer::sum);
    }

}
