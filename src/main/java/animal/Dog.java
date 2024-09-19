package animal;


public class Dog extends Animal {
    public Dog(String type, String name, int age, int weight, String color){
        super(type,name,age,weight,color);
    }


    @Override
    public String say() {
        return ("Гав");
    }
}
