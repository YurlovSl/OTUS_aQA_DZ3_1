package animal;


public class Dog extends Animal {
    public Dog( String color, String name, int weight, String type, int age) {
        super( color, name, weight, type, age);

    }

    @Override
    public String say() {
        return ("Гав");
    }
}
