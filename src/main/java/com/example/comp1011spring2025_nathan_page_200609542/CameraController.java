package com.example.comp1011spring2025_nathan_page_200609542;
/*Lab done by Nathan Page (200609542)
* May 13, 2025 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Camera;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CameraController {
    @FXML
    private ComboBox<String> brandList;

    @FXML
    private ComboBox<String> cameralist;

    @FXML
    private ComboBox<String> memoryList;

    @FXML
    private TextArea output;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtLensLength;

    @FXML
    private TextField txtResolution;

    @FXML
    void onCameraListSubmit(ActionEvent event) {

    }

    @FXML
    void onFormSubmit(ActionEvent event) {

        //Idk why I could not get it fully working and would love to hear a fix


//Adding all the different choices for the user
        brandList.getItems().addAll("CANON", "POLAROID", "SONY");
       memoryList.getItems().addAll("GB_32", "GB_64", "GB_128");

       //Printing all the different items so they can display in the console
    System.out.println(txtLensLength.getText());
    System.out.println(txtResolution.getText());
    System.out.println(txtColor.getText());
    System.out.println(brandList.getItems());
    System.out.println(memoryList.getItems());

    //This line puts it into the box in the form
    output.setText(txtColor.getText() + txtLensLength.getText() + txtResolution.getText());

    //In theory this should do the same however I could not get it working
        String memoryItem = memoryList.getItems().toString();
        String brandItem = brandList.getItems().toString();

        //This creates a new instance after the user goes through it
        CameraModel camera = new CameraModel(CameraModel.MemoryOptions.GB_64, txtColor.getText(), CameraModel.AvailableBrands.CANON, Double.parseDouble(txtResolution.getText()), Integer.parseInt(txtLensLength.getText()));
    }

}
