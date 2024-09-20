package tables;

import data.ChooseTypeAnimals;
import db.MySQLConnect;
import animal.Animal;
import utils.Help;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals";

    public AnimalTable() {
        super(NAME);
    }

    public void write(Animal animal){
        this.dbConnector.execute(String.format("INSERT INTO %s (id,type,name,age,color,weight) " +
                        "VALUES('%s','%s','%s','%s','%s','%s')",NAME,animal.getId(),
                animal.getType(),animal.getName(),animal.getAge(),animal.getColor(),animal.getWeight()));
    }

    public void print(ResultSet rs) throws SQLException {
        //Вывод заголовка на экран
        System.out.printf("%-5s %-5s %-20s %-10s %-10s %-5s%n", "ID", "Type", "Name", "Age", "Weight", "Color");
        System.out.println("-----------------------------------------------------------");

        while(rs.next()){
            System.out.printf("%-5d %-5s %-20s %-10d %-10s %-5s%n",
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("weight"),
                    rs.getString("color"));
        }
    }

    public ArrayList<Animal> read() throws SQLException {
        ArrayList<Animal> animal = new ArrayList<>();
        ResultSet resultSet;

        dbConnector = new MySQLConnect();
        resultSet = this.dbConnector.executeQuery(String.format("SELECT * FROM  %s;",NAME));
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String color = resultSet.getString("color");
            String name = resultSet.getString("name");
            int weight = resultSet.getInt("weight");
            String type = resultSet.getString("type");
            int age = resultSet.getInt("age");

            Animal animals = new Animal(id,color,name,weight,type,age);
            animal.add(animals);
        }
        return animal;
    }


    public ResultSet selectWithFilter(ChooseTypeAnimals chooseTypeAnimals) {                                                       // Фильтрация
        return dbConnector.executeQuery(String.format("SELECT * FROM  %s where type='%s';", NAME, chooseTypeAnimals));
    }

    public void updateAnimal(Animal animal){
        this.dbConnector.execute(String.format(
                "update %s set type='%s', name='%s', age=%d, weight=%d, color='%s' where id=%d;",
                NAME,
                animal.getType(),
                animal.getName(),
                animal.getAge(),
                animal.getWeight(),
                animal.getColor(),
                animal.getId()));
    }
}
