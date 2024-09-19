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


    public FabrikaForAnimals(String type,String name, int age, int weight, String color){

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
                return new Dog(type,name,age,weight,color);
            case CAT:
                return new Cat(type,name,age,weight,color);

            case DUCK:
                return new Duck(type,name,age,weight,color);

        }

        return null;
    }
}
