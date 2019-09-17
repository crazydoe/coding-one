package com.kurs.coding_one.animals.animal;

public class CanaryBird extends AbstractAnimal {

    public CanaryBird() {
        super(AnimalFamily.BIRD, 2);
    }

    @Override
    public String introduceYourself() {
        return "I'm a canary bird!";
    }

    @Override
    public void speak() {
        System.out.println("ćwir ćwir ćwir ćwir ćwir ćwir");
    }
}
