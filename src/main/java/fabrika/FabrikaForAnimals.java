package fabrika;

import data.ChooseTypeAnimals;
import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Duck;

public class FabrikaForAnimals {

    private String name;
    private int age;
    private int weight;
    private String color;

    public FabrikaForAnimals(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal createAnimal (ChooseTypeAnimals chooseTypeAnimals){
        //Animal animal = null;

        switch (chooseTypeAnimals){
            case DOG:
                return new Dog(name,age,weight,color);
            case CAT:
                return new Cat(name,age,weight,color);

            case DUCK:
                return new Duck(name,age,weight,color);

        }

        return null;
    }
}
