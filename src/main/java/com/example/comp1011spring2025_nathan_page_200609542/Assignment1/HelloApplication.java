package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/comp1011spring2025_nathan_page_200609542/Assignment1/weather-chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/comp1011spring2025_nathan_page_200609542/Assignment1/Icon/weather-icon-size_24.png")));
        //Image in the corner provided by https://creazilla.com/media/icon/7911203/weather
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}