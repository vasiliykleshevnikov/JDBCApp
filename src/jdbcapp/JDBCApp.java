/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcapp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Василий
 */
public class JDBCApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Регистрация драйвера
            Class.forName("com.mysql.jdbc.Driver");
            // Подключение к БД
            Connection connection = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "admin", "password");
            Statement statement = (Statement) connection.createStatement();
            // Выполнение запроса и получение результата
            ResultSet result = statement.executeQuery("SELECT * FROM auto.brand");
            // Вывод результата на экран
            while (result.next()) {
                System.out.println(result.getInt("ID") + "\t" + result.getString("NAME"));
            }
            
            // Удаление и добавление нескольких записей из БД
            statement.execute("DELETE FROM auto.brand WHERE id < 7");
            statement.execute("INSERT INTO auto.brand (name) value ('Opel')");
            // Вывод таблицы brand после изменений
            result = statement.executeQuery("SELECT * FROM auto.brand");
            while (result.next()) {
                System.out.println(result.getInt("ID") + "\t" + result.getString("NAME"));
            }
        } catch (ClassNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
