//Hüseyin Aksoy 150122010
//Eren Emre Aycibin 150122054
//Kerim Ak 150123515

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class App extends Application {
	ArrayList<Path> paths = new ArrayList<>();
	ArrayList<TrafficLight> trafficLights = new ArrayList<TrafficLight>();
	MetaData metadata = null;
	ArrayList<Car> cars = new ArrayList<Car>();
	int crashed=0;
	int finished=0;
	private Label scoreLabel = new Label();
	private Label crashLabel = new Label();
	int accidentLimit=-1;
	int winCondition=-1;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		StackPane pane3 = new StackPane(); // Creating pane for lose condition
		Image img3 = new Image("WinScene.png"); // Taking image
		ImageView imageView3 = new ImageView(img3);
		imageView3.setFitWidth(800); // Taking width
		imageView3.setFitHeight(800); // Taking height
		pane3.getChildren().add(imageView3); // Adding image to pane
		
		Scene winScene = new Scene(pane3,800,800); // The scene that will be displayed when the winning condition is met
		
		StackPane pane4 = new StackPane(); // Creating pane for win condition
		Image img4 = new Image("LoseScene.png"); // Taking image
		ImageView imageView4 = new ImageView(img4);
		imageView4.setFitWidth(800); // Taking width
		imageView4.setFitHeight(800); // Taking height
		pane4.getChildren().add(imageView4); // Adding image to pane
		
		Scene loseScene = new Scene(pane4,800,800);// The scene that will be displayed when the losing condition is met
		
		
		
		StackPane pane = new StackPane(); // Creating pane for main login page
		Image img = new Image("Play.png");
		ImageView imageView = new ImageView(img);
		imageView.setFitWidth(800);
		imageView.setFitHeight(800);
		pane.getChildren().add(imageView);
		Scene firstScene = new Scene(pane,800,800);
		

		
		
		StackPane pane2 = new StackPane(); // Creating pane for levels page
		Image img2 = new Image("Levels.png");
		ImageView imageView2 = new ImageView(img2);
		imageView2.setFitWidth(800);
		imageView2.setFitHeight(800);
		pane2.getChildren().add(imageView2);
		Scene secondScene = new Scene(pane2,800,800);
		
		VBox vbox2 = new VBox(); // Creating vbox for rectangles that we will create
		pane2.getChildren().add(vbox2);
		
		Rectangle level1Button = new Rectangle(350,68,Color.color(0, 0, 0, 0)); // We create rectangles and place them respectively 
		Rectangle level2Button = new Rectangle(350,70,Color.color(0, 0, 0, 0)); // on the image where necessary
		Rectangle level3Button = new Rectangle(350,70,Color.color(0, 0, 0, 0));
		Rectangle level4Button = new Rectangle(350,75,Color.color(0, 0, 0, 0));
		Rectangle level5Button = new Rectangle(350,75,Color.color(0, 0, 0, 0));
		
		Rectangle rectangle = new Rectangle(800,340,Color.color(0, 0, 0, 0));
		vbox2.getChildren().addAll(rectangle,level1Button,level2Button,level3Button,level4Button,level5Button);
		vbox2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
		level1Button.setOnMouseClicked(e -> { // level buttons and corresponding level creations
			File file = new File("level1.txt");
			try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		
		level2Button.setOnMouseClicked(e -> {
			File file = new File("level2.txt");
		    try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		});
		
		level3Button.setOnMouseClicked(e -> {
			File file = new File("level3.txt");
		    try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		});
		
		level4Button.setOnMouseClicked(e -> {
			File file = new File("level4.txt");
		    try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		});
		
		level5Button.setOnMouseClicked(e -> {
			File file = new File("level5.txt");
		    try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		});
		
		
		VBox vbox = new VBox(); // Creating vbox for rectangles that we will create
		pane.getChildren().add(vbox);
		
		Rectangle playButton = new Rectangle(600, 200,Color.color(0, 0, 0, 0)); // Rectangle for play button
		vbox.getChildren().add(playButton);
		playButton.setOnMouseClicked(e -> { // When the play button is clicked, it starts from the first level
			File file = new File("level1.txt");
		    try {
				primaryStage.setScene(createMap(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		});
		
		
		Rectangle levelsButton = new Rectangle(500, 150,Color.color(0, 0, 0, 0)); // Rectangle for levels button
		vbox.getChildren().add(levelsButton);
		levelsButton.setOnMouseClicked(e -> primaryStage.setScene(secondScene)); // When to button is clicked it goes to levels screen

		vbox.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER); //Aligns rectangles bottom to center
		
		
		

        
		new AnimationTimer() {  //win-lose condition checking animation timer
		    @Override
		    public void handle(long now) {
		        if (crashed == accidentLimit || finished == winCondition) {
		            Platform.runLater(() -> {
		                if (crashed == accidentLimit) {
		                    primaryStage.setScene(loseScene);
		                } else {
		                    primaryStage.setScene(winScene);
		                }
		            });
		        }
		    }
		}.start();

		primaryStage.setTitle("Traffic Simulator Game");
		primaryStage.setScene(firstScene);
		primaryStage.show();	
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
    public ArrayList<Path> getPaths() {
        return paths;
    }
    public void checkTrafficLight(Car car) {  //traffic light checker
        for (TrafficLight light : trafficLights) { //for each traffic light
        	if (light.getCircle().getBoundsInParent().intersects(car.getBoundsInParent())) { // if given car and traffic light intersects
        		car.set_isOnLight(true); // car is on the light
        	}
        	else if (!light.getCircle().getBoundsInParent().intersects(car.getBoundsInParent()))
        	{
        		car.set_isOnLight(false);
        	}
        	if (car.get_isOnLight() && light.isRed()) { //if car is on light and light is red
                car.stop(); // stop the car
                break;
            }
        	if (car.get_isOnLight() && light.isGreen()) //if car is on light and light is green
        	{
        		car.move(); //move the car
        		break;
        	}
        }
    }
    
    ArrayList<Car> collidedCars = new ArrayList<>();
    private double time = 0.0;
    
    private void createTraffic() { // traffic creator
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
       }

       private void update() { //check the state of the cars
           time += 0.1;
           isGonnaStop(collidedCars);


       if(time > 2) {
           if(Math.random() < 0.3) {
               spawnCar();

           }
           time = 0;
       }}
    	
	public void spawnCar() { // spawning car on a random path
		
		Path selectedPath = getRandomPath();
		
		PathTransition pathTransition = new PathTransition();
		Car car = new Car(selectedPath,pathTransition);
		cars.add(car);	
	    double pathLength = calculatePathLength(selectedPath);
	    double speed = 100;
	    double durationInSeconds = pathLength / speed;
		pathTransition.setDuration(Duration.seconds(durationInSeconds));
		pathTransition.setPath(selectedPath);
		pathTransition.setNode(car);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setInterpolator(Interpolator.LINEAR);
	    pathTransition.setOnFinished(event -> {
	        cars.remove(car);
	        metadata.get_pane().getChildren().remove(car);
	        finished++;
	        scoreLabel.setText("Score: " + finished + "/" + metadata.getWinCondition()); 
	    });
		pathTransition.play();
		metadata.get_pane().getChildren().add(car);
	}
	
	private Path getRandomPath() {  // random path selector
	    int randomIndex = (int) (Math.random() * paths.size());
	    return paths.get(randomIndex);
	}

	public double calculatePathLength(Path path) {  // path length calculator
		double preX=0;
		double preY=0;
		double length = 0;
		
		for(int i =0;i<path.getElements().size();i++) {
			if(path.getElements().get(i) instanceof MoveTo) {
				MoveTo moveto = (MoveTo) path.getElements().get(i);
				preX= moveto.getX();
				preY= moveto.getY();
			}
			else if(path.getElements().get(i) instanceof LineTo) {
				LineTo lineto = (LineTo) path.getElements().get(i);
				length += Math.sqrt(Math.pow(lineto.getX()-preX, 2)+ Math.pow(lineto.getY()-preY, 2));
				preX= lineto.getX();
				preY= lineto.getY();
			}
		}
		return length;
	}
	
	public Scene createMap(File file) throws FileNotFoundException {  // map creator by taking input from txt files
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String line = input.nextLine();
			String[] words = line.split(" ");
			if (words[0].equals("Metadata")) {
				metadata = new MetaData(Double.parseDouble(words[1]),Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]),Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]));
			}
			else if (words[0].equals("Building")) {
				Building build = new Building(Integer.parseInt(words[1]),Double.parseDouble(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]));
				if((Integer.parseInt(words[1])==0 ||Integer.parseInt(words[1])==1 ) && (Integer.parseInt(words[2])== 0 || Integer.parseInt(words[2])== 180 ||Integer.parseInt(words[2])== 90)) {
			        metadata.get_pane().add(build,build.getGridX(),build.getGridY()+1);
			} 
			else 
				metadata.get_pane().add(build,build.getGridX(),build.getGridY());
			}
			else if (words[0].equals("RoadTile")) {
				RoadTile road = new RoadTile(Integer.parseInt(words[1]), Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]));
				metadata.get_pane().add(road, road.getGridX(), road.getGridY());
			}
			else if (words[0].equals("TrafficLight")) {
				TrafficLight trafficlight = new TrafficLight(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]), Double.parseDouble(words[4]));
				 trafficLights.add(trafficlight);
				 metadata.get_overlayPane().getChildren().add(trafficlight.getLine());
			     metadata.get_overlayPane().getChildren().add(trafficlight.getCircle());
				
			}
			
			else if (words[2].equals("MoveTo")) {
		        Path path = new Path();
		        MoveTo moveTo = new MoveTo(Double.parseDouble(words[3]), Double.parseDouble(words[4]));
		        path.getElements().add(moveTo);
		        Scanner input1 = new Scanner(file);
		        while (input1.hasNext()) {
		            String innerLine = input1.nextLine();
		            String[] innerWords = innerLine.split(" ");
		            if(innerWords[2].equals("LineTo") && Integer.parseInt(innerWords[1])== Integer.parseInt(words[1])) {
			            LineTo lineTo = new LineTo(Double.parseDouble(innerWords[3]), Double.parseDouble(innerWords[4])-20);
			            path.getElements().add(lineTo);
		            }
		        }
		        input1.close();
		        paths.add(path);
		    }
		}
		input.close();
	    scoreLabel.setText("Score: " + finished + "/" + metadata.getWinCondition());
	    scoreLabel.setFont(new Font(20));
	    crashLabel.setText("Crashes: " + crashed + "/" + metadata.getAccidentLimit());
	    crashLabel.setFont(new Font(20));
	    scoreLabel.setPadding(new Insets(0, 0, 0, 10));
	    crashLabel.setPadding(new Insets(0, 0, 0, 10));
	    VBox overlayBox = new VBox(-5);
	    overlayBox.getChildren().addAll(scoreLabel, crashLabel);
	    metadata.get_overlayPane().getChildren().add(overlayBox);
		accidentLimit = metadata.getAccidentLimit();
		winCondition = metadata.getWinCondition();
		createTraffic();
		return metadata.get_scene();
	}
	
	public void checkCollisions(ArrayList<Car> collidedCars) {  // collision checker
        Platform.runLater(() -> {
            for (int i = 0; i < cars.size(); i++) {
                Car car1 = cars.get(i);
                Bounds bounds1 = car1.getBoundsInParent();
                for (int j = 0; j < cars.size() && j != i; j++) {
                    Car car2 = cars.get(j);
                    Bounds bounds2 = car2.getBoundsInParent();
                    if (bounds1.intersects(bounds2)){ // if two cars intersects at any point
                        car1.stop(); // stop both cars
                        car2.stop();
                        crashed++;
                        collidedCars.add(car1);  // add them to collidedCars array
                        collidedCars.add(car2);
	    	            crashLabel.setText("Crashes: " + crashed + "/" + metadata.getAccidentLimit());
                    }
                }
            }
            removeCollidedCars(collidedCars);  // removing collided cars from pane
        });
    }

	private void removeCollidedCars(ArrayList<Car> collidedCars) {  // collided car remover
        for (Car car : collidedCars) {
                metadata.get_pane().getChildren().remove(car);
                cars.remove(car);
        }
    }
	
	public void isGonnaStop(ArrayList<Car> collidedCars) { // this method checks whether car is gonna stop on a given situation
	    Platform.runLater(() -> {
	    	checkCollisions(collidedCars);
	        for (int i = 0; i < cars.size(); i++) {
	            Car car1 = cars.get(i);
	                for (int j = 0; j < cars.size(); j++) {
	                    if (i != j) {
	                        Car car2 = cars.get(j);
	                        checkTrafficLight(car1);
	                        checkTrafficLight(car2);
	                        double car1degree = car1.getRotate();
	                        double car2degree = car2.getRotate();
	                        double distance = calculateDistance(car1, car2);
	                        double diff = car1degree - car2degree;
	                        if (!car1.get_stopped() && distance < 27)
	                        {
                        		if (((car1degree > 270 && car1degree <= 360) || (car1degree >= 0 && car1degree < 90)) //right
                        				&& ((car2degree > 270 && car2degree <= 360) || (car2degree >= 0 && car2degree < 90))) {
                        			if (car2.getTranslateX() < car1.getTranslateX()) {
                        				car2.move();
                        				car2.set_shouldStop(false);
                        				car2.set_stopped(false);
                        			}
                        		}
                        		if ((car1degree > 0 && car1degree < 180) && (car2degree > 0 && car2degree < 180)) {
                        			if (car2.getTranslateY() < car1.getTranslateY()){
                        				car2.move();
                        				car2.set_shouldStop(false);
                        				car2.set_stopped(false);
                        			}
                        		}
                        		if ((car1degree > 90 && car1degree < 270) && ((car2degree > 90 && car2degree < 270))) {
                        			if (car2.getTranslateX() > car1.getTranslateX()) {
                        				car2.move();
                        				car2.set_shouldStop(false);
                        				car2.set_stopped(false);
                        			}
                        		}
                        		if ((car1degree > 180 && car1degree < 360) && ((car2degree > 180 && car2degree < 360))) {
                        			if (car2.getTranslateY() > car1.getTranslateY()) {
                        				car2.move();
                        				car2.set_shouldStop(false);
                        				car2.set_stopped(false);
                        			}
                        		}
	                        }
                        	else if (car1.get_stopped() && distance < 27) {
                        		if (((car1degree > 270 && car1degree <= 360) || (car1degree >= 0 && car1degree < 90)) //right
                        				&& ((car2degree > 270 && car2degree <= 360) || (car2degree >= 0 && car2degree < 90))) {
                        			if (car2.getTranslateX() < car1.getTranslateX()) {
                        				car2.stop();
                        				car2.set_shouldStop(true);
                        				car2.set_stopped(true);
                        			}
                        		}
                        		if (diff <= 90 && diff >= -90) {
                        			
                            		if ((car1degree > 0 && car1degree < 180) && ((car2degree > 0 && car2degree < 180))) { //down
                            			if (car2.getTranslateY() < car1.getTranslateY()) {
                            				car2.stop();
                            				car2.set_shouldStop(true);
                            				car2.set_stopped(true);
                            			}
                            		}
                            		if ((car1degree > 90 && car1degree < 270) && ((car1degree > 90 && car1degree < 270))) { //left
                            			if (car2.getTranslateX() > car1.getTranslateX()) {
                            				car2.stop();
                            				car2.set_shouldStop(true);
                            				car2.set_stopped(true);
                            			}
                            		}
                            		if ((car1degree > 180 && car1degree < 360) && ((car1degree > 180 && car1degree < 360))) { //up
                            			if (car2.getTranslateY() > car1.getTranslateY()) {
                            				car2.stop();
                            				car2.set_shouldStop(true);
                            				car2.set_stopped(true);
                            			}
                            		}
                            	}
                        	}
	                    }
	                }
	        }
	    });
	}
	
	public boolean inList(ArrayList<Car> arr , Car car) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)==car) {
				return true;
			}
		}
		return false;
	}
	
	private double calculateDistance(Car car1, Car car2) {  // calculates the distance between the midpoints of two given car
	    double deltaX = car2.getTranslateX() - car1.getTranslateX();
	    double deltaY = car2.getTranslateY() - car1.getTranslateY();
	    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}
	public double calculateDistanceX(Car car1, Car car2) {  // calculates the distance between two x points of two given car
	    return car2.getTranslateX() - car1.getTranslateX();
	}
	public double calculateDistanceY(Car car1, Car car2) {  // calculates the distance between two y points of two given car
	    return car2.getTranslateY() - car1.getTranslateY();
	}
}