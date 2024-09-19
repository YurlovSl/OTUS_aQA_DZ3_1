import animal.Animal;
import data.ChooseActions;
import data.ChooseTypeAnimals;
import fabrika.FabrikaForAnimals;
import tables.AnimalTable;
import utils.Help;
import utils.ValidationLine;
import utils.ValidationNumber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        ArrayList<Animal> animals = new ArrayList<>();
        ChooseActions chooseActions;
        AnimalTable animalTable = new AnimalTable();
        Help help = new Help();

        List<String> columnsAnimalTable = new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("age INT");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("color VARCHAR(20)");
        animalTable.create(columnsAnimalTable);

        while (true) {
            ArrayList<String> actionForEnum = new ArrayList<>();
            for (ChooseActions chooseActions1 : ChooseActions.values()) {
                actionForEnum.add(chooseActions1.name().toUpperCase());
            }
            System.out.println("Введите введите команду: \n" + String.join(" | ", actionForEnum));                      // Вывод команд через Enum
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
                    Animal animal = help.createUpdateAnimals();
                    animals.add(animal);
                    animalTable.write(animal);
                    System.out.println(animal.say());
                    break;

                case UPDATE:
                    System.out.println("Введите id");
                    int id = scanner.nextInt();
                    Animal newAnimal = help.createUpdateAnimals();
                    newAnimal.setId(id);
                    animalTable.updateAnimal(newAnimal);
                    break;

                case LIST:
                    if (animalTable.isTableExists() == false) {
                        System.out.println("На данный момент список пуст");
                        continue;
                    } else {
//
                        ResultSet resultSet = animalTable.selectAll();
                        animalTable.print(resultSet);

                        animals = animalTable.read();
                        //System.out.println(animals);
                    }
                    break;
                case DELETE:
                    animalTable.delete();
                    break;
                case EXIT:
                    scanner.close();
                    System.out.println("Выход");
                    System.exit(0);
            }

        }

    }

}