package com.kurs.coding_one.animals.animal;

public class GoldFish extends AbstractAnimal {

    public GoldFish() {
        super(AnimalFamily.FISH, 1);
    }

    @Override
    public String introduceYourself() {
        return "I'm a gold fish";
    }

    @Override
    public void speak() {
        System.out.println("bul bul bul bul");
    }
}
