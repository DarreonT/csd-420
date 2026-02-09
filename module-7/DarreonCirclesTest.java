import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: DarreonCirclesTest.java
 * Purpose: Basic tests to verify 4 circles exist and CSS IDs/classes are applied.
 * Author: Darreon Tolen
 */
public class DarreonCirclesTest extends ApplicationTest {

    private HBox root;

    @Override
    public void start(Stage stage) {
        Circle c1 = new Circle(45);
        c1.getStyleClass().addAll("plaincircle", "circleborder");

        Circle c2 = new Circle(45);
        c2.getStyleClass().addAll("plaincircle", "circleborder");
        c2.setId("redcircle");

        Circle c3 = new Circle(45);
        c3.getStyleClass().addAll("plaincircle", "circleborder");
        c3.setId("greencircle");

        Circle c4 = new Circle(45);
        c4.getStyleClass().addAll("plaincircle", "circleborder");

        StackPane p1 = new StackPane(c1);
        StackPane p2 = new StackPane(c2);
        StackPane p3 = new StackPane(c3);
        StackPane p4 = new StackPane(c4);

        root = new HBox(15, p1, p2, p3, p4);
        Scene scene = new Scene(root, 600, 200);

        // Load CSS (must be available on classpath)
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @Test
    void shouldContainFourCircles() {
        // Lookup all circles in the scene graph
        var circles = lookup(".circle").queryAllAs(Circle.class);
        assertEquals(4, circles.size(), "Expected exactly 4 circles.");
    }

    @Test
    void shouldHaveRedAndGreenIds() {
        Circle red = lookup("#redcircle").queryAs(Circle.class);
        Circle green = lookup("#greencircle").queryAs(Circle.class);

        assertNotNull(red, "Red circle (id=redcircle) should exist.");
        assertNotNull(green, "Green circle (id=greencircle) should exist.");
    }

    @Test
    void shouldApplyStyleClasses() {
        // Just verify classes are attached (CSS application depends on runtime rendering)
        Circle any = lookup(".circle").queryAs(Circle.class);
        assertTrue(any.getStyleClass().contains("plaincircle"));
        assertTrue(any.getStyleClass().contains("circleborder"));
    }
}
