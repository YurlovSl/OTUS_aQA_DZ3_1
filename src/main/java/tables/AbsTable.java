package tables;

import db.IDBConnect;
import db.MySQLConnect;
import utils.Help;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbsTable implements ITable {
    protected IDBConnect dbConnector = null;
    private String tableName = "";
    Help help = new Help();


    public AbsTable(String tableName) {
        dbConnector = new MySQLConnect();
        this.tableName = tableName;
    }

    @Override
    public void create(List<String> columns) {
        // Проверяем существование таблицы
        if (!isTableExists()) {
            dbConnector.execute(String.format("CREATE TABLE %s (%s);", tableName, String.join(",", columns)));
        }
    }

    @Override
    public void clear() {
        dbConnector.execute(String.format("drop table if exists %s;", this.tableName));
        create(help.addTitleForTable());

    }

    public ResultSet selectAll() {
        return dbConnector.executeQuery(String.format("SELECT * FROM  %s;", this.tableName));
    }

    // Метод для проверки существования таблицы
    public boolean isTableExists() {
        String query = String.format("SHOW TABLES LIKE '%s';", this.tableName);
        try (ResultSet rs = dbConnector.executeQuery(query)) {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}