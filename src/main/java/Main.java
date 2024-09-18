import animal.Animal;
import data.ChooseActions;
import data.ChooseTypeAnimals;
import fabrika.FabrikaForAnimals;
import tables.AnimalTable;
import utils.ValidationLine;
import utils.ValidationNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        ChooseActions chooseActions;
        ValidationNumber validationNumber = new ValidationNumber();
        ValidationLine validationLine = new ValidationLine();

        AnimalTable animalTable = new AnimalTable();

        List<String> columnsAnimalTable = new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("color VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("age INT");
        animalTable.create(columnsAnimalTable);

        while (true) {
            ArrayList<String> actionForEnum = new ArrayList<>();
            for (ChooseActions chooseActions1 : ChooseActions.values()) {
                actionForEnum.add(chooseActions1.name().toUpperCase());
            }
            System.out.println("Введите введите команду: " + String.join("/", actionForEnum));                      // Вывод команд через Enum
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toUpperCase().trim();
            try {
                chooseActions = ChooseActions.valueOf(line);
            } catch (Exception exception) {
                System.out.println("Такой команды нет, повторите попытку еще раз");
                continue;
            }
            switch (chooseActions) {
                case ADD:
                    ArrayList<String> animalsForEnum = new ArrayList<>();
                    for (ChooseTypeAnimals chooseTypeAnimals1 : ChooseTypeAnimals.values()) {
                        animalsForEnum.add(chooseTypeAnimals1.name().toUpperCase());
                    }
                    while (true) {
                        System.out.println("Введите название животного: " + String.join("/", animalsForEnum));          // Вывод животных через Enum
                        String typeAnimal = scanner.nextLine().toUpperCase().trim();

                        if (!animalsForEnum.contains(typeAnimal)) {                                                             // Сравнение строки с элементами массива, полученных из Enum
                            System.out.println("Такого животного нет, повторите попытку еще раз");
                        } else {
                            System.out.println("Введите имя");
                            String name = validationLine.validateLine(line);

                            System.out.println("Введите возраст");
                            int age = validationNumber.validateNumber(line);

                            System.out.println("Введите вес");
                            int weight = validationNumber.validateNumber(line);

                            System.out.println("Введите цвет");
                            String color = validationLine.validateLine(line);

                            Animal animal = new FabrikaForAnimals(color,name, weight, typeAnimal, age).createAnimal(ChooseTypeAnimals.valueOf(typeAnimal));
                            System.out.println(animal.getClass());
                            animals.add(animal);
                            animalTable.write(animal);


                            System.out.println(animal.say());
                            break;
                        }
                    }
                    break;

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("На данный момент список пуст");
                        continue;
                    } else {
                        for (Animal an : animals)
                            System.out.println(an.toString());

                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход");
                    System.exit(0);
            }

        }

    }
}