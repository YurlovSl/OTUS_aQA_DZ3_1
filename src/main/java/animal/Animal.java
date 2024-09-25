package animal;



import utils.ValidationLine;
import utils.ValidationNumber;


public abstract class Animal {
    private String name;
    private int id;
    private int age;
    private int weight;
    private String color;
    private String years;
    private String type;
    private ValidationNumber validationNumber = new ValidationNumber();
    private ValidationLine validationLine = new ValidationLine();



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String say() {
        return ("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        String s = "Привет! я, " + type + " меня зовут " + name + ", мне " + age + " " + countAge(getAge()) + ", я вешу - " + weight + " кг, мой цвет - " + color;
        return s;
    }

    public Animal() {
    }

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public Animal(String name, int id, int age, int weight, String color, String years, String type) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.years = years;
        this.type = type;
    }
    public Animal(String type,String name, int age, int weight, String color) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;

    }

    public Animal(String name, int age, int weight, String color, String years, String type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.years = years;
        this.type = type;
    }
  //  id,color,name,weight,type,age
    public Animal( String color, String name, int weight, String type, int age){

        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }
    public Animal(int id, String color, String name, int weight, String type, int age) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public String countAge(int age) {

        int count = age % 100;
        if (count >= 5 && count <= 20) {
            years = "лет";
        } else {
            count = count % 10;
            if (count == 1) {
                years = "год";
            } else if (count >= 2 && count <= 4) {
                years = "года";
            } else {
                years = "лет";
            }
        }
        return years;
    }


}
