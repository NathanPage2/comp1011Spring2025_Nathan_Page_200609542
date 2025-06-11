module com.example.comp1011spring2025_nathan_page_200609542 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.comp1011spring2025_nathan_page_200609542 to javafx.fxml;
    exports com.example.comp1011spring2025_nathan_page_200609542;
}