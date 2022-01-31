/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Toussain bankafe
 */
public class UserDAO {

    private Connection connection = DatabaseConnexion.getConnection();

    public boolean verifyCredentials(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utilisateur WHERE username=? AND password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
