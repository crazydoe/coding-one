package com.kurs.coding_one.animals.food;

import com.kurs.coding_one.animals.animal.AnimalFamily;

import java.util.Arrays;
import java.util.List;

import static com.kurs.coding_one.animals.animal.AnimalFamily.*;

public enum FoodType {
    MEAT(DOG, CAT),
    DRY_FOOD_FOR_DOG(DOG),
    FISH_FOOD(FISH),
    WATER(BIRD, CAT, DOG),
    GRAINS(BIRD);

    FoodType(AnimalFamily... types) {
        animalFamily = Arrays.asList(types);
    }

    private List<AnimalFamily> animalFamily;

    public boolean containsAnimal(AnimalFamily animal) {
        return animalFamily.contains(animal);
    }
}
