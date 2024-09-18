import animal.Animal;
import tables.AnimalTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        AnimalTable animalTable = new AnimalTable();

        List<String> columnsAnimalTable = new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("color VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("age INT");
       animalTable.create(columnsAnimalTable);


        animalTable.write(new Animal("черный","Иван",7,"енот",5));
        animalTable.write(new Animal("белый", "Пес", 8, "собака",  10));
        animalTable.write(new Animal("красный", "Бадди", 5, "собака",  5));
        animalTable.write(new Animal("черный", "Игорь", 5, "енот",  5));
        animalTable.write(new Animal("серый", "Пушок", 3, "выдра",  2));
        animalTable.write(new Animal("серый", "Серый", 3, "кошка",  4));
//
//
//        ResultSet rs = animalTable.selectall();
//        animalTable.print(rs);
//
//        ArrayList<Animal>  an= animalTable.read();
//        System.out.println(an);

    }
}
