package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
import java.sql.*;
public class WeatherDatabase {
    public static void main(String[] args){

        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://database-1.clcsm88w2wu1.us-east-2.rds.amazonaws.com:3306/COMP1011;user=NathanPage;password=Jarwars89;");
        }

        catch(SQLException e){
            e.printStackTrace();
        }





    }
}
