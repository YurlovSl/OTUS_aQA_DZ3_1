package animal;


public class Duck extends Animal implements Flying {
    public Duck( String color, String name, int weight, String type, int age) {
        super( color, name, weight, type, age);
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

    @Override
    public String say() {
        return ("Кря");
    }
}
