//We imported the javaFx libraries
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

// We are creating metaData class
public class MetaData {
    GridPane gridPane = new GridPane();// Main GridPane for layout
    Pane pane = new Pane();// Pane for additional overlays
    Path path = new Path(); // Path object to draw lines or shapes
    int winCondition;
    int accident;
    double x = 800;// Default width
    double y = 800;// Default height
    Scene scene;// Scene object to contain all elements

    public MetaData(double width, double height, int rows, int columns, int path, int winCondition, int accident) {
    	pane.getChildren().addAll(gridPane,this.path);// Add gridPane and path to pane
    	this.winCondition=winCondition;
    	this.accident=accident;
    	x=width;
    	y=height;
        // Set the GridPane background to a specific color
        gridPane.setStyle("-fx-background-color: #F0F8FF;"); // Set background color for gridPane

        // Set column and row constraints to create grid layout
        for (int i = 0; i < rows; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(width / columns)); // Set column width
            gridPane.getRowConstraints().add(new RowConstraints(height / rows));// Set row height
        }

        gridPane.setGridLinesVisible(true);// Make grid lines visible
        
        // Create grid cells with rectangles
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Rectangle square = new Rectangle(width / columns, height / rows);// Create rectangle for grid cell
                square.setFill(Color.LIGHTBLUE); // Set fill color
                square.setStroke(Color.BLACK); // Set stroke color
                square.setStyle("-fx-stroke-width: 0.3;"); // Set stroke width for the outline
                gridPane.add(square, column, row);// Add the square to the gridPane
            }
        }
        scene = new Scene(pane, width, height);// Create a scene with the specified width and height
    }

    public Scene get_scene() { // Getter for the scene
        return scene;
    }

    public GridPane get_pane() {// Getter for the gridPane
        return gridPane;
    }
    Pane get_overlayPane() {// Getter for the pane (for overlays)
        return pane;
    }
    public Path getPath() { // Getter for the path
        return path;
    }

    public void setPath(Path path) { // Setter for the path
        this.path = path;
    }
    public int getWinCondition() {
    	return winCondition;
    }
    public int getAccidentLimit() {
    	return accident;
    }
    public double getHeight() {
    	return y;
    }
    public double getWidth() {
    	return x;
    }
}