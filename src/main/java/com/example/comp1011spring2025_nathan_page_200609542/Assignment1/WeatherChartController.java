package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
//Done by Nathan Page(200609542)
//June 12th, 2025
//The big bar chart
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherChartController {
    @FXML
    private Button SwitchToTable;
    //Now it does!

    @FXML
    public void switchToTable(javafx.event.ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("weather-table-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Table View!");
            stage.setScene(scene);
            stage.show();
            //Creating a new scene and giving it a title
            //Same way as we do in class
        } catch (IOException e) {
            throw new RuntimeException(e);
            //Catches very basic stuff
        }
    }
    @FXML
    private TableColumn<WeatherModel, String> weatherColumn;

    @FXML
    private TableColumn<WeatherModel, String> timeColumn;

    @FXML
    private TableColumn<WeatherModel, String> specialNotesColumn;
//Those three table columns are to put the values near the bar chart in the table view
    @FXML
    private BarChart<String, Number> chart;
    //Our actual bar chart that will take our cities and tempeture
    @FXML
    private TableView<WeatherModel> tableview;
    //Our side table view
    @FXML
    private void initialize() {
        List<WeatherModel> weatherData = getWeatherData();
        //Putting all our lovely weather data into a list
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        //Creating a new series
        for (WeatherModel weatherModel : weatherData) {
            //Looping through each
            XYChart.Data<String, Number> newData = new XYChart.Data<>(weatherModel.getCity(), weatherModel.getTemperature());
            //Setting City as the x and tempeture as the y
            data.getData().add(newData);
        }   //Adds the bar
        chart.getData().add(data);
        //Helps display the full series

        timeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTimeDay().toString()));
        weatherColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWeather()));
        specialNotesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSpecialNotes()));
        //Setting the time, weather and speical notes
        tableview.getItems().addAll(weatherData);
        //Adding it all the  row of table
    }

    private List<WeatherModel> getWeatherData() {
        List<WeatherModel> list = new ArrayList<>();
        //Creating a new list
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://database-1.clcsm88w2wu1.us-east-2.rds.amazonaws.com:3306/COMP1011",
                    "NathanPage",
                    "Jarwars89"
                    //Our login info again same as before had to force it through
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weatherApp");
            //Retriving our data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                Time timeDay = resultSet.getTime("timeDay");
                double temperature = resultSet.getDouble("temperature");
                String weather = resultSet.getString("weather");
                String specialNotes = resultSet.getString("specialNote");
                list.add(new WeatherModel(id, city, timeDay, temperature, weather, specialNotes));
                //Inserting all our data in the list
            }
            connection.close();
            //Closing our database
            return list;
            //Returning list
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //This will catch very basic errors
        }
    }
    }

