//Done by Nathan Page (200609542)
//June 12, 2025
//Constructor and empty getters and setters page
package com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
import java.sql.Time;
public class WeatherModel {

    private int id;
private String city;
private Time timeDay;
private double temperature;
private String weather;
private String specialNotes;
//Declaring all our values from the database

public WeatherModel(int id, String city, Time timeDay, double temperature, String weather, String specialNotes) {
    this.id = id;
    this.city = city;
    this.timeDay = timeDay;
    this.temperature = temperature;
    this.weather = weather;
    this.specialNotes = specialNotes;
    //Putting them through a constructor
}
//AND then all below is empty getters and settters
    //The point of this page is not all the functionality
    //It's the functionality it brings to the other pages acting as a model
    public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Time getTimeDay() {
    return timeDay;
    }
    public void setTimeDay(Time timeDay) {
    this.timeDay = timeDay;
    }
    public double getTemperature() {
    return temperature;
    }
    public void setTemperature(double temperature) {
    this.temperature = temperature;
    }
    public String getWeather() {
    return weather;
    }
    public void setWeather(String weather) {
    this.weather = weather;
    }
    public String getSpecialNotes() {
    return specialNotes;
    }
    public void setSpecialNotes(String specialNotes) {
    this.specialNotes = specialNotes;
    }
}

