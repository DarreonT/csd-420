import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * File: DarreonCircles.java
 * Purpose: Display four circles styled by external CSS using class and IDs.
 * Author: Darreon Tolen
 */
public class DarreonCircles extends Application {

    @Override
    public void start(Stage stage) {
        // Create circles
        Circle c1 = new Circle(45);
        c1.getStyleClass().addAll("plaincircle", "circleborder");

        Circle c2 = new Circle(45);
        c2.getStyleClass().addAll("plaincircle", "circleborder");
        c2.setId("redcircle"); // ID styling: red fill/stroke

        Circle c3 = new Circle(45);
        c3.getStyleClass().addAll("plaincircle", "circleborder");
        c3.setId("greencircle"); // ID styling: green fill/stroke

        Circle c4 = new Circle(45);
        c4.getStyleClass().addAll("plaincircle", "circleborder");

        // Put each circle in a StackPane (nice spacing + optional border class)
        StackPane p1 = new StackPane(c1);
        StackPane p2 = new StackPane(c2);
        StackPane p3 = new StackPane(c3);
        StackPane p4 = new StackPane(c4);

        // Optional: add a border around each pane (matches sample CSS style name)
        p1.getStyleClass().add("border");
        p2.getStyleClass().add("border");
        p3.getStyleClass().add("border");
        p4.getStyleClass().add("border");

        // Layout
        HBox root = new HBox(15, p1, p2, p3, p4);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root);

        // Load external CSS
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        stage.setTitle("Module 7 - Styled Circles");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
