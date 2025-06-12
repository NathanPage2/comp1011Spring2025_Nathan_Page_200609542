package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class WeatherTableController {
    @FXML
    private TableView<WeatherModel> tableView;
    @FXML
    private TableColumn<WeatherModel, Integer> idColumn;

    @FXML
    private TableColumn<WeatherModel, String> cityColumn;

    @FXML
    private TableColumn<WeatherModel, String> timeDayColumn;

    @FXML
    private TableColumn<WeatherModel, Double> tempertaureColumn;

    @FXML
    private TableColumn<WeatherModel, String> weatherColumn;

    @FXML
    private TableColumn<WeatherModel, String> specialNotesColumn;

    public void initialize() {
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        cityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCity()));
        timeDayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTimeDay().toString()));
        tempertaureColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTemperature()).asObject());
        weatherColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWeather()));
        specialNotesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSpecialNotes()));

    }



}
