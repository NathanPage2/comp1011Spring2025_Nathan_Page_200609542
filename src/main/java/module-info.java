module com.example.comp1011spring2025_nathan_page_200609542 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.comp1011spring2025_nathan_page_200609542 to javafx.fxml, javafx.graphics;
   exports com.example.comp1011spring2025_nathan_page_200609542;
}
