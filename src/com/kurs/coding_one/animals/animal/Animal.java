package com.kurs.coding_one.animals.animal;

import com.kurs.coding_one.animals.food.Food;

public interface Animal {

    boolean feed(Food food);

    String introduceYourself();

    void speak();

    void enlargeHunger(int amount);

    AnimalFamily getFamily();

    boolean isHungry();
}
