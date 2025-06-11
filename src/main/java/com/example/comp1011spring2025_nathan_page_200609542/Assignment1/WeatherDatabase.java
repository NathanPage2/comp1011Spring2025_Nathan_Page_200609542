package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
import java.sql.*;
public class WeatherDatabase {
    public static void main(String[] args){

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://database-1.clcsm88w2wu1.us-east-2.rds.amazonaws.com:3306/COMP1011",
                    "NathanPage",
                    "Jarwars89"
                    //Had to force it through with cloudshell commands
            );
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO weatherApp (city,timeDay, temperature, weather, specialNote) VALUES (?,?,?,?,?)");
            System.out.println("Test");

            Time currentTime = new Time(System.currentTimeMillis());
            //Gets the currant time which is nice
            preparedStatement.setString(1, "Sutton");
            preparedStatement.setTime(2, currentTime);
            preparedStatement.setDouble(3, 22);
            preparedStatement.setString(4, "Sunny");
            preparedStatement.setString(5, "Weather is very nice out");

            preparedStatement.execute();
            //Executed successfully
        }

        catch(SQLException e){
            e.printStackTrace();
            //Placeholder catch to simply not annoy me
        }





    }
}
