package utils;

import animal.Animal;
import data.ChooseTypeAnimals;
import fabrika.FabrikaForAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Help {

    private ValidationNumber validationNumber = new ValidationNumber();
    private ValidationLine validationLine = new ValidationLine();



    public Animal createUpdateAnimals(){
        boolean rightType = false;
        String typeAnimal;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> animalsForEnum = new ArrayList<>();
        for (ChooseTypeAnimals chooseTypeAnimals1 : ChooseTypeAnimals.values()) {
            animalsForEnum.add(chooseTypeAnimals1.name().toUpperCase());
        }
        do {
            System.out.println("Введите название животного: " + String.join("/", animalsForEnum));          // Вывод животных через Enum
            typeAnimal = scanner.nextLine().toUpperCase().trim();
            if (animalsForEnum.contains(typeAnimal)){
                rightType = true;
            }
            else{
                System.out.println("Такого животного нет, повторите попытку еще раз");
            }
        } while (!rightType);
        System.out.println("Введите имя");
        String name = validationLine.validateLine();

        System.out.println("Введите возраст");
        int age = validationNumber.validateNumber();

        System.out.println("Введите вес");
        int weight = validationNumber.validateNumber();

        System.out.println("Введите цвет");
        String color = validationLine.validateLine();

        return new FabrikaForAnimals(typeAnimal,name,age,weight,color).createAnimal(ChooseTypeAnimals.valueOf(typeAnimal));
    }

    public List<String> addTitleForTable(){
        List<String> columnsAnimalTable = new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("age INT");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("color VARCHAR(20)");
        return columnsAnimalTable;
    }
}
