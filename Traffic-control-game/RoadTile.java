//Hüseyin Aksoy 150122010
//Eren Emre Aycibin 150122054
//Kerim Ak 150123515

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;


public class RoadTile extends StackPane {

	private int type;
	private double rotation;
	private int gridX;
	private int gridY;	
    // Constructor to initialize the RoadTile object

	public RoadTile(int type, double rotation, int gridX, int gridY) {
		this.type = type;
		this.rotation = rotation;
		this.gridX = gridX;
		this.gridY = gridY;
        // Handling the different types of road tiles

		if (type == 0) {	// Type 0: Straight road
			Rectangle road = new Rectangle(); // Create a rectangle for the road
			road.setFill(Color.WHITE);// Set the color to white of the road

			if (rotation == 0 || rotation == 180) { // Adjusting dimensions based on rotation
				road.setHeight(40);
				road.setWidth(53.3);
			} else if (rotation == 90|| rotation == 270) {
				road.setHeight(53.3);
				road.setWidth(40);
			}
			getChildren().add(road);// Add the road to the StackPane
		}

		else if (type == 1) {// Type 1: Curved road

			Arc quarterCircle1 = new Arc(0, 0, 46.8, 46.8, 0, 90); // First quarter circle
			quarterCircle1.setType(ArcType.ROUND);
			quarterCircle1.setFill(Color.WHITE);

			Arc quarterCircle2 = new Arc(0, 0, 6.5, 6.5, 0, 90); // Second smaller quarter circle
			quarterCircle2.setType(ArcType.ROUND);
			quarterCircle2.setFill(Color.LIGHTBLUE);// Different color for inner edge
			
            // Align and rotate based on the specified rotation

			if (rotation == 0) {
				StackPane.setAlignment(quarterCircle2, Pos.BOTTOM_LEFT); // Align to bottom-left
				StackPane.setAlignment(quarterCircle1, Pos.BOTTOM_LEFT);
			}

			else if (rotation == 90) {

				quarterCircle1.setRotate(270);
				quarterCircle2.setRotate(270);
				StackPane.setAlignment(quarterCircle2, Pos.BOTTOM_RIGHT); // Aligning the second quarter to the bottom right 														
				StackPane.setAlignment(quarterCircle1, Pos.BOTTOM_RIGHT);

			}

			else if (rotation == 180) {

				quarterCircle1.setRotate(180);
				quarterCircle2.setRotate(180);
				StackPane.setAlignment(quarterCircle2, Pos.TOP_RIGHT); // Aligning the second quarter to the top right
				StackPane.setAlignment(quarterCircle1, Pos.TOP_RIGHT);
			}

			else if (rotation == 270) {

				quarterCircle1.setRotate(90);
				quarterCircle2.setRotate(90);
				StackPane.setAlignment(quarterCircle2, Pos.TOP_LEFT); // Aligning the second quarter to the top left
				StackPane.setAlignment(quarterCircle1, Pos.TOP_LEFT);

			}

			getChildren().addAll(quarterCircle1, quarterCircle2); // Add the arcs to the StackPane

		} else if (type == 2) {// Type 2: Intersection

			// Horizontal road
			Rectangle road1 = new Rectangle();
			
			road1.setHeight(40);
			road1.setWidth(53);
			road1.setFill(Color.WHITE);
			//Vertical road
			Rectangle road2 = new Rectangle();
			road2.setHeight(53);
			road2.setWidth(40);
			road2.setFill(Color.WHITE);
			getChildren().add(road1);// Add the horizontal road
			getChildren().add(road2);// Add the vertical road
		} else if (type == 3) {
			// Main road
			Rectangle road4 = new Rectangle();
			road4.setHeight(40);
			road4.setWidth(53);
			road4.setFill(Color.WHITE);
			// Secondary road
			Rectangle road5 = new Rectangle();
			road5.setHeight(6.5);
			road5.setWidth(40);
			road5.setFill(Color.WHITE);

			if (rotation == 0) {
				StackPane.setAlignment(road4, Pos.CENTER); // Aligning the second quarter circle to center
				StackPane.setAlignment(road5, Pos.BOTTOM_CENTER);//Align to the bottom center
				getChildren().addAll(road4, road5);// Add both roads
			}

			else if (rotation == 90) {// Rotate to 270 degrees
				road4.setRotate(270);
				road5.setRotate(270);
				road5.setTranslateX(-(road5.getWidth() / 2) - 3);// Translate to avoid overlap
				getChildren().addAll(road4, road5);// Add both roads
			}

			else if (rotation == 180) {// Rotate to 180 degrees
				road4.setRotate(180);
				road5.setRotate(180);
				StackPane.setAlignment(road4, Pos.CENTER); // İkinci QuarterCircle'ı sol alt köşeye hizala
				StackPane.setAlignment(road5, Pos.TOP_CENTER);
				getChildren().addAll(road4, road5);
			}

			else if (rotation == 270) {// Rotate to 90 degrees
				road4.setRotate(270);
				road5.setRotate(270);
				road5.setTranslateX((road5.getWidth() / 2) + 3);// Adjust translation
				getChildren().addAll(road4, road5);
			}

		} else {

		}

	}

	// Getter methods for grid coordinates
	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

}
