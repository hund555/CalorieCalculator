package com.example.calorie_calc;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label calculationResult;

    @FXML
    private ChoiceBox<String> activityChoice;

    private String[] activities = {"Løb (12 km/t)", "Svømning", "Badminton", "Powerwalking", "Mountainbike"};

    @FXML
    private TextField minutesTextField;

    @FXML
    private TextField weightTextField;

    /**
     * Calculates how many calories the user have burned
     */
    @FXML
    protected void onCalculateClick()
    {
        try
        {
            double activityValue = 0;
            activityValue = switch (activityChoice.getValue()){
                case "Løb (12 km/t)" -> 11.5;
                case "Svømning" -> 5.8;
                case "Badminton" -> 5.5;
                case "Powerwalking" -> 6.3;
                case "Mountainbike" -> 8.5;
                default -> 0;
            };
            double minutes = Double.parseDouble(minutesTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());
            double calories = (activityValue * weight * minutes) / 60;
            calculationResult.setText("Du har forbrandt " + calories + " kalorier");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong, try again");
        }
    }

    /**
     * adds all activity values to choicebox
     */
    @FXML
    public void initialize()
    {
        activityChoice.getItems().addAll(activities);
        activityChoice.getSelectionModel().selectFirst();
    }
}