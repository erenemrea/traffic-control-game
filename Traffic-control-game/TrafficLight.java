//Hüseyin Aksoy 150122010
//Eren Emre Aycibin 150122054
//Kerim Ak 150123515

// first we imported some of the javaFx libraries
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;

public class TrafficLight {
	private Line lightLine;
	private Circle light;
	private boolean isRed;

	// Creating the traffic light constructor
	public TrafficLight(double x1, double y1, double x2, double y2) {
		lightLine = new Line(x1, y1, x2, y2); // Creating a line with the given x and y values

		// Creating the line length with the given formula
		double lineLength = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));

		light = new Circle();// Creating the circle of the trafficlight
		light.setRadius(lineLength / 4);// giving it's radius
		// with the code below we located the circle to the half of line's length + min
		// y or x value
		if (y1 == y2) {
			light.setCenterX(Math.min(x2, x1) + lineLength / 2);
			light.setCenterY(Math.min(y2, y1));
		} else if (x1 == x2) {
			light.setCenterY(Math.min(y2, y1) + lineLength / 2);
			light.setCenterX(Math.min(x2, x1));
		}

		light.setStroke(Color.BLACK); // making its border black
		light.setFill(Color.GREEN); // making the circle green at the begining
		light.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) { // when we click to the light
				if (light.getFill() == Color.GREEN) {
					light.setFill(Color.RED);// changing its color to the red
					isRed = true;
				} else {
					light.setFill(Color.GREEN);
					isRed = false;
				}
			}
		});
		isRed = false;
	}

	// getter methods for the line and cicle
	public Line getLine() {
		return lightLine;
	}

	public Circle getCircle() {
		return light;
	}

	// Methods for controling the light's color
	public boolean isRed() {
		return isRed;
	}

	public boolean isGreen() {
		return !isRed;
	}

}