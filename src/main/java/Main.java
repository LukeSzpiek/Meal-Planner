package src.main.java;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double width = visualBounds.getWidth();
        double height = visualBounds.getHeight();

        Label label = new Label("Click the button.");
        label.setTranslateY(30);

        Button button = new Button("Hello JavaFXPorts");
        button.setOnAction(e -> label.setText("You clicked the button!"));

        Rectangle rectangle = new Rectangle(width - 20, height - 20);
        rectangle.setFill(Color.LIGHTBLUE);
        rectangle.setArcHeight(6);
        rectangle.setArcWidth(6);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, button, label);

        Scene scene = new Scene(stackPane, visualBounds.getWidth(), visualBounds.getHeight());

        stage.setScene(scene);
        stage.show();
    }
}
