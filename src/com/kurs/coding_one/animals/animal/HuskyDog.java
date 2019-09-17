package com.kurs.coding_one.animals.animal;

public class HuskyDog extends AbstractAnimal {

    public HuskyDog() {
        super(AnimalFamily.DOG, 20);
    }

    @Override
    public String introduceYourself() {
        return "I'm a dog";
    }

    @Override
    public void speak() {
        System.out.println("wof wof wof");
    }
}
