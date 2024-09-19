package animal;

public class Cat extends Animal {
//    public Cat( String color, String name, int weight, String type, int age) {
//        super( color, name, weight, type, age);
//    }
    public Cat(String type, String name, int age, int weight, String color){
        super(type,name,age,weight,color);
    }

    @Override
    public String say() {
        return ("Мяу");
    }

}
