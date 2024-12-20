package hust.soict.dsai.aims.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterControllerTungNM {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;

    private Color currentColor = Color.RED;  

    @FXML
    void toolSelection(ActionEvent event) {
        if (pen.isSelected()) {
            currentColor = Color.RED;
        } else if (eraser.isSelected()) {
            currentColor = Color.WHITE;
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void initialize() {
        drawingAreaPane.setOnMouseDragged(this::drawingAreaMouseDragged);
    }

    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
