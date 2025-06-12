module com.example.comp1011spring2025_nathan_page_200609542 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.comp1011spring2025_nathan_page_200609542.Assignment1 to javafx.fxml, javafx.graphics;
    exports com.example.comp1011spring2025_nathan_page_200609542.Assignment1;
}
