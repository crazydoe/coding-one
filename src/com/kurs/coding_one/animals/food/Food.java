package com.kurs.coding_one.animals.food;

import com.kurs.coding_one.animals.animal.AnimalFamily;

public class Food {

    private int amount;
    private int priceForAmount;
    private FoodType foodType;
    private static final int FULL_AMOUNT = 100;

    public Food(FoodType type, int priceForAmount) {
        this.priceForAmount = priceForAmount;
        this.foodType = type;
        this.amount = 0;
    }

    public FoodType getType() {
        return foodType;
    }

    public int getAPiece(int amount) {
        this.amount = this.amount - amount;
        return amount;
    }

    public int refillAndGetCost() {
        int difference = FULL_AMOUNT - amount;
        amount = FULL_AMOUNT;
        return difference * priceForAmount;
    }

    public boolean isEnough(int amount) {
        return amount <= this.amount;
    }

    public boolean fitsAnimal(AnimalFamily animalFamily) {
        return foodType.containsAnimal(animalFamily);
    }
}
