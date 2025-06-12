//Done by Nathan Page (200609542)
//June 12th 2025
package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
import java.sql.*;
//Importing our sql
public class WeatherDatabase {
    public static void main(String[] args){

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://database-1.clcsm88w2wu1.us-east-2.rds.amazonaws.com:3306/COMP1011",
                    "NathanPage",
                    "Jarwars89"
                    //Had to force it through with cloudshell commands
                    //Big note for the whole project, it's set up with the amazon aws
                    //Had too much set up in the database to switch
                    //I followed the first video not the second basically
            );
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO weatherApp (city,timeDay, temperature, weather, specialNote) VALUES (?,?,?,?,?)");
        //Ensuring a safe entry point for our code

            Time currentTime = new Time(System.currentTimeMillis());
            //Gets the current time which is nice
            preparedStatement.setString(1, "Sutton");
            preparedStatement.setTime(2, currentTime);
            preparedStatement.setDouble(3, 22);
            preparedStatement.setString(4, "Sunny");
            preparedStatement.setString(5, "Weather is very nice out");
            //All of this is pretty understandable, we are just creating a new column

            preparedStatement.execute();
            //Executed successfully

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weatherApp");
            //Retriving our data

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                String timeDay = resultSet.getString("timeDay");
                double temperature = resultSet.getDouble("temperature");
                String weather = resultSet.getString("weather");
                String specialNote = resultSet.getString("specialNote");
                //Retriving all the data from the MYSQL

                System.out.println(id);
                System.out.println(city);
                System.out.println(timeDay);
                System.out.println(temperature);
                System.out.println(weather);
                System.out.println(specialNote);
                System.out.println("-".repeat(25));
                //Printing it back out into the console with line dividers

            }
        }

        catch(SQLException e){
            e.printStackTrace();
            //This catch statement is fine for what we are doing, it will catch basic errors
        }





    }
}
