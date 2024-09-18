package fabrika;

import data.ChooseTypeAnimals;
import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Duck;

public class FabrikaForAnimals {

    private String type;
    private String name;
    private int age;
    private int weight;
    private String color;


    public FabrikaForAnimals( String color, String name, int weight, String type, int age){

        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public Animal createAnimal (ChooseTypeAnimals chooseTypeAnimals){
        //Animal animal = null;

        switch (chooseTypeAnimals){
            case DOG:
                return new Dog(color,name,weight,type,age);
            case CAT:
                return new Cat(color,name,weight,type,age);

            case DUCK:
                return new Duck(color,name,weight,type,age);

        }

        return null;
    }
}
