package com.kurs.coding_one.animals;

import com.kurs.coding_one.animals.animal.*;
import com.kurs.coding_one.animals.food.Food;
import com.kurs.coding_one.animals.food.FoodType;
import com.kurs.coding_one.animals.food.Fridge;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String... args) {
        Fridge fridge = new Fridge();
        fridge.addProduct(new Food(FoodType.MEAT, 40));
        fridge.addProduct(new Food(FoodType.FISH_FOOD, 20));
        fridge.addProduct(new Food(FoodType.GRAINS, 5));
        fridge.addProduct(new Food(FoodType.DRY_FOOD_FOR_DOG, 35));
        fridge.addProduct(new Food(FoodType.WATER, 2));


        Animal huskyDog = new HuskyDog();
        Animal canaryBird = new CanaryBird();
        Animal goldFish = new GoldFish();
        Animal sphinxCat = new SphinxCat();


        Person owner = new Person(fridge, 100000);
        owner.adoptPet(huskyDog);
        owner.adoptPet(canaryBird);
        owner.adoptPet(goldFish);
        owner.adoptPet(sphinxCat);


        owner.introduceAnimals();

        System.out.println("\n Let's bring them to life! \n");

        Thread hungerThread = createHungerThread(Arrays.asList(huskyDog, canaryBird, goldFish, sphinxCat));
        hungerThread.start();

        owner.takeCareOfThem();

        hungerThread.stop();
    }

    private static Thread createHungerThread(List<Animal> animals) {
        return new Thread(new HungerEnlarger(animals));
    }

}
