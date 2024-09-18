package tables;

import db.MySQLConnect;
import objects.Animal;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals";

    public AnimalTable() {
        super(NAME);
    }

    public void write(Animal animal){
        this.dbConnector.execute(String.format("INSERT INTO %s (id,color,name,weight,type,age) " +
                "VALUES('%s','%s','%s','%s','%s','%s')",NAME,animal.getId(),
                animal.getColor(),animal.getName(),animal.getWeight(),animal.getType(),animal.getAge()));
    }

    public void print(ResultSet rs) throws SQLException {
        //Вывод заголовка на экран
        System.out.printf("%-10s %-20s %-10s %-5s %-10s %-5s%n", "Color", "Name", "Weight", "ID", "Type", "Age");
        System.out.println("-----------------------------------------------------------");

        while(rs.next()){
            System.out.printf("%-10s %-20s %-10s %-5d %-10s %-5d%n",
                    rs.getString("color"),
                    rs.getString("name"),
                    rs.getString("weight"),
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getInt("age"));
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
            animals.getAge();
            animal.add(animals);
        }
        return animal;
    }

}
