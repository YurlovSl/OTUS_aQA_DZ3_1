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

        animalTable.create(help.addTitleForTable());

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
                    System.out.println("Введите id животного");
                    int id = scanner.nextInt();
                    Animal newAnimal = help.createUpdateAnimals();
                    newAnimal.setId(id);
                    animalTable.updateAnimal(newAnimal);
                    break;

                case LIST:
                    if (!animalTable.isTableExists()) {
                        System.out.println("На данный момент список пуст");
                        continue;
                    } else {
                        System.out.println("Введите цифру 1 или 2.\n1 для вывода всего списка,\n2 для вывода списка по фильтру:");
                        int option = scanner.nextInt();
                        scanner.nextLine();
                        switch (option) {
                            case 1:
                                ResultSet resultSet = animalTable.selectAll();
                                animalTable.print(resultSet);
                                break;
                            case 2:
                                boolean rightType = false;
                                String typeAnimal;
                                ArrayList<String> animalsForEnum = new ArrayList<>();
                                for (ChooseTypeAnimals chooseTypeAnimals1 : ChooseTypeAnimals.values()) {
                                    animalsForEnum.add(chooseTypeAnimals1.name().toUpperCase());
                                }
                                do {
                                    System.out.println("Введите название животного: " + String.join("/", animalsForEnum));          // Вывод животных через Enum
                                    typeAnimal = scanner.nextLine().toUpperCase().trim();
                                    if (animalsForEnum.contains(typeAnimal)) {
                                        rightType = true;
                                    } else {
                                        System.out.println("Такого животного нет, повторите попытку еще раз");
                                    }
                                } while (!rightType);

                                ResultSet resultSetWithFilter = animalTable.selectWithFilter(ChooseTypeAnimals.valueOf(typeAnimal));
                                animalTable.print(resultSetWithFilter);
                                break;
                        }
                    }
                    break;

                case CLEAR:
                    animalTable.clear();
                    break;
                case EXIT:
                    scanner.close();
                    System.out.println("Выход");
                    System.exit(0);
            }

        }

    }

}