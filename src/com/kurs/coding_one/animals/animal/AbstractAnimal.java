package com.kurs.coding_one.animals.animal;

import com.kurs.coding_one.animals.food.Food;

public abstract class AbstractAnimal implements Animal {
    private AnimalFamily animalFamily;
    private int biteSize;
    private int hungryLevel = 0;

    public AbstractAnimal(AnimalFamily animalFamily, int biteSize) {
        this.animalFamily = animalFamily;
        this.biteSize = biteSize;
    }

    @Override
    public boolean feed(Food food) {
        if (hungryLevel == 0) {
            return true;
        }
        if (!food.fitsAnimal(animalFamily)) {
            return false;
        }
        if (!food.isEnough(biteSize)) {
            return false;
        }
        hungryLevel -= food.getAPiece(biteSize);
        return true;
    }

    @Override
    public void enlargeHunger(int amount) {
        hungryLevel += amount;
        System.out.println(animalFamily.toString() + " is getting hungry");
    }

    @Override
    public AnimalFamily getFamily() {
        return animalFamily;
    }

    @Override
    public boolean isHungry() {
        return (hungryLevel != 0);
    }
}
