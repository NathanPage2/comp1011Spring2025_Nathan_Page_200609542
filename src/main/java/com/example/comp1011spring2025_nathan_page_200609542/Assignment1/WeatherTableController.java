package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
//Done by Nathan Page (200609542)
//June 12th 2025
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherTableController {
    @FXML
    private TableView<WeatherModel> tableView;
    @FXML
    private TableColumn<WeatherModel, Integer> idColumn;

    @FXML
    private TableColumn<WeatherModel, String> cityColumn;

    @FXML
    private TableColumn<WeatherModel, Time> timeDayColumn;

    @FXML
    private TableColumn<WeatherModel, Double> tempertaureColumn;

    @FXML
    private TableColumn<WeatherModel, String> weatherColumn;

    @FXML
    private TableColumn<WeatherModel, String> specialNotesColumn;
    //Setting up all of our values to go in the table column

    public void initialize() {
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        cityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCity()));
        timeDayColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getTimeDay()));
        tempertaureColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTemperature()).asObject());
        weatherColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWeather()));
        specialNotesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSpecialNotes()));
        //Informing our column how to get the getters and setters from our model
        ObservableList<WeatherModel> data = FXCollections.observableArrayList();
        data.addAll(getWeatherData());
        tableView.setItems(data);
        //Creating an empty list, filling it and setting the items
    }

    private ObservableList<WeatherModel> getWeatherData() {
        ObservableList<WeatherModel> data = FXCollections.observableArrayList();
        //Creating a new empty list for changes
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://database-1.clcsm88w2wu1.us-east-2.rds.amazonaws.com:3306/COMP1011",
                    "NathanPage",
                    "Jarwars89"
                    //Very same login stuff we have been doing
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weatherApp");
            //The very same retriving from the SQL database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                Time timeDay = resultSet.getTime("timeDay");
                double temperature = resultSet.getDouble("temperature");
                String weather = resultSet.getString("weather");
                String specialNotes = resultSet.getString("specialNote");
                data.add(new WeatherModel(id, city, timeDay, temperature, weather, specialNotes));
                //Inserting all that data that matches the requirements into the list
            }
            resultSet.close();
            //Closing what we got
            statement.close();
            //Closing database
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //very simple one catches basic errors
        }


        return data;
        //Closing list
    }
}