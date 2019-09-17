package com.kurs.coding_one.animals;

import com.kurs.coding_one.animals.animal.Animal;
import com.kurs.coding_one.animals.food.Food;
import com.kurs.coding_one.animals.food.Fridge;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Person {

    private Set<Animal> animals;
    private Fridge fridge;
    private Integer budget;


    public Person(Fridge fridge, Integer budget) {
        this.fridge = fridge;
        this.budget = budget;
        animals = new HashSet<>();
    }

    public void adoptPet(Animal animal) {
        animals.add(animal);
    }

    public void introduceAnimals() {
        animals.forEach(animal -> System.out.println(animal.introduceYourself()));
    }

    public boolean feedAnimals() {
        boolean allAnimalsFeeded = true;
        for (Animal animal : animals) {
            Set<Food> foodForAnimal = fridge.getFoodForAnimal(animal.getFamily());

            foodForAnimal.forEach(animal::feed);

            if (animal.isHungry()) {
                allAnimalsFeeded = false;
            }
        }
        return allAnimalsFeeded;
    }

    public void refillFridge() {
        if (budget > 0) {
            budget -= fridge.refillFridge();
        } else {
            throw new LowBudgetException();
        }
    }

    public void takeCareOfThem() {
        while (budget > 0) {
            System.out.println("It's time to feed the animals!");
            if (!feedAnimals()) {
                System.out.println("\noh no! The animals have eaten all the food. time to shop. My budget is: " + budget + "\n");
                refillFridge();
            }

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("I have no more money. It's over.....");
    }
}
