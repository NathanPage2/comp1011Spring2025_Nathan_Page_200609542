package com.example.comp1011spring2025_nathan_page_200609542;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class CameraController {

    @FXML
    private ComboBox<String> brandList;

    @FXML
    private ComboBox<String> cameraList;

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
    private Slider sldPrice;

    CameraModel model = new CameraModel();

    @FXML
    void onCameraListSubmit(ActionEvent event) {

    }

    @FXML
    void initialize() {

        model.getAllMemoryOptions();

        memoryList.getItems().addAll(model.getAllMemoryOptions());
        brandList.getItems().addAll(model.getAllBrands());


        memoryList.getSelectionModel().selectFirst();
        brandList.getSelectionModel().selectFirst();
        //lamba expression
        cameraList.setOnAction(
                event -> {
                    System.out.println("You selected index:" + cameraList.getSelectionModel().getSelectedIndex());
                    output.setText(cameraList.getSelectionModel().getSelectedItem());
                }

        );
        //price slider
       ChangeListener changeListener = (observable, oldValue, newValue) -> {
           System.out.println("Sld price:" + newValue);
           System.out.println("old price:" + oldValue);
       };
      // sldPrice.valueProperty().addListener(
             //   (observable, oldValue, newValue) -> {
                  //  System.out.println("Sld price:" + newValue);
                  //  System.out.println("old price:" + oldValue);
              //  }
       // );

        //sldPrice.valueProperty().addListener(changeListener);

        //Functional Interface: only one abstarct method

        sldPrice.valueProperty().addListener(

                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue,
                                        Number newValue) {
                        System.out.println("Sld price:" + newValue);
                        System.out.println("old price:" + oldValue);
                    }
                }
        );


    }
    @FXML
    void onFormSubmit(ActionEvent event) {

//        System.out.println(txtColor.getText());
//        System.out.println(txtLensLength.getText());
//        System.out.println(txtResolution.getText());
//
//        output.setText(txtColor.getText() + txtLensLength.getText() + txtResolution.getText());

        System.out.println(brandList.getSelectionModel().getSelectedItem());
        System.out.println(memoryList.getSelectionModel().getSelectedIndex());

        //get all of the values that the user inputted
        //use the getters of cameramodel object to set all the values of the class

        //if any validation error occurs, create an alert to display message to user
        try {
            model.setBrand(CameraModel.AvailableBrands.valueOf(brandList.getSelectionModel().getSelectedItem()));
            model.setMemory(CameraModel.MemoryOptions.valueOf(memoryList.getSelectionModel().getSelectedItem()));
            model.setColor(txtColor.getText());
            model.setResolution(Double.parseDouble(txtResolution.getText()));
            model.setLensLength(Integer.parseInt(txtLensLength.getText()));

            output.setText(model.toString());
            cameraList.getItems().add(model.comboBoxDisplay());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText("Incorrect Values");
            alert.setContentText(e.getMessage());
            alert.show();

        }



    }

}


















    //@FXML LAB 1
   /* void onFormSubmit(ActionEvent event) {

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
*/

