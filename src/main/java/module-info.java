module project.motus {
    requires javafx.controls;
    requires javafx.fxml;
	requires de.jensd.fx.glyphs.fontawesome;
	requires javafx.graphics;

    opens project.motus to javafx.fxml;
    opens project.motus.controller to javafx.fxml;
    exports project.motus;
    exports project.motus.controller;
   
}
