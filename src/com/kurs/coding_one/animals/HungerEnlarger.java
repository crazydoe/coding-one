package com.kurs.coding_one.animals;

import com.kurs.coding_one.animals.animal.Animal;

import java.util.List;
import java.util.Random;

public class HungerEnlarger implements Runnable {

    private List<Animal> animals;
    private Random random;

    public HungerEnlarger(List<Animal> animals) {
        this.animals = animals;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            animals.get(random.nextInt(animals.size() - 1)).enlargeHunger(randomHungerGenerator());
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int randomHungerGenerator() {
        return random.nextInt(50);
    }
}
