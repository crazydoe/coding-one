package com.kurs.coding_one.animals.animal;

public class SphinxCat extends AbstractAnimal {

    public SphinxCat() {
        super(AnimalFamily.CAT, 5);
    }

    @Override
    public String introduceYourself() {
        return "I'm a cat";
    }

    @Override
    public void speak() {
        System.out.println("meow mr mr mrrrrr");
    }

}
