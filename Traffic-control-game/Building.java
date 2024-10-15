//Hüseyin Aksoy 150122010
//Eren Emre Aycibin 150122054
//Kerim Ak 150123515

//Firstly we imported javaFx libraries that we needed
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
	
	public class Building extends StackPane { // We defined the building class and the main varieables we need
		private int type;
		private double rotation;
		private int gridX;
		private int gridY;
		public int gridSize = 53;
		// We created an array that contains the color codes we want to use for creating the buildings
		public Color[] arr = {Color.web("#8ad8b2"),Color.web("#b1a9da"),Color.web("#f2c291"),Color.web("#df768a")};

		//We coded the buialding constructor below
		public Building(int type,double rotation,int color,int gridX,int gridY) {
			this.type=type; // Type is the building type 
			this.rotation=rotation; // Rotation is the rotation of the house 
			this.gridX= gridX; // GridX and GridY is for the location of the building in our pane 
			this.gridY=gridY;
			Color chosenColor = (arr[color]); // Color we wanted house to be  
			
			if(type==0) { // This is the code for the style of the building with type 0 
				if(rotation ==0) { // This is the code for the style of the building with rotation 0 
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); // Creating the building's rectangle with the given size
					rect.setFill(Color.WHITE); //making the rectangle white 
					rect.setArcHeight(27); //Making the corners of it parabolic 
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);// Adding border to it 
			        rect.setStroke(Color.BLACK);// Making the border black
			        getChildren().add(rect);// Adding the rectangle to our pane 
			        
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10); // Creating the big square inside the rectangle with given size
			        square.setFill(chosenColor);//giving color to it 
			        getChildren().add(square); // adding to our pane 
			        square.setTranslateY(-26);//We are locating the square inside the rectangle 
			        square.setTranslateX(0);
			        square.setArcHeight(27);//making its border parabolic
			        square.setArcWidth(27);
			        square.setStrokeWidth(2);//adding a border with 2 pixels 
			        square.setStroke(Color.BLACK);//making the border black
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20); // Creating the small square inside the rectangle with given size
			        square2.setFill(chosenColor);//giving the its color 
			        getChildren().add(square2); //adding to our pane 
			        square2.setTranslateY(-26);//locating it inside the rectangle and big square
			        square2.setTranslateX(0);
			        square2.setArcHeight(27);//making its border parabolic
			        square2.setArcWidth(27);
			        square2.setStrokeWidth(2);//adding border with 2 pixels 
			        square2.setStroke(Color.BLACK);//making the border black
				}
				else if (rotation == 90) { // We are checking a rectangle with the rotation 90 degrees and creating the rectangle with the same steps above
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
			        rect.setFill(Color.WHITE);
			        rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);

			        rect.setRotate(90); // We are rotating the rectangle first we created then we are rotating it 90 degrees with this code 
			        rect.setTranslateX(gridSize*0.5);// Then rectangle slipped little bit without our wish so we translated its X axis with the half of its size
			        rect.setTranslateY(-gridSize*0.5);// We translated its location half of its size 
	
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10); // We created a big square just like above 
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(-26.5); // Then we translated its Y axis  location because we rotated the outer rectangle
			        square.setTranslateX(0);
			        square.setArcHeight(27);
			        square.setArcWidth(27);
			        square.setStrokeWidth(2);
			        square.setStroke(Color.BLACK);
			       
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
			        square2.setFill(chosenColor);
			        getChildren().add(square2); 
			        square2.setTranslateY(-26);
			        square2.setTranslateX(0);
			        square2.setArcHeight(27);
			        square2.setArcWidth(27);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				else if (rotation == 180) {// We are creating a rectangle with the 180 degrees rotated version of the first rectangle
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
			        rect.setFill(Color.WHITE);
			        rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);
			       
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10);
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(26.5); // We are changing the Y axis location of big square inside the rectangle 
			        square.setTranslateX(0);
			        square.setArcHeight(27);
			        square.setArcWidth(27);
			        square.setStrokeWidth(2);
			        square.setStroke(Color.BLACK);
			       // square.setRotate(90);
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
			        square2.setFill(chosenColor);
			        getChildren().add(square2); 
			        square2.setTranslateY(26);// We are changing the Y axis location of small square inside the rectangle 
			        square2.setTranslateX(0);
			        square2.setArcHeight(27);
			        square2.setArcWidth(27);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				else if (rotation == 270) {// We are creating a rectangle with the 270 degrees rotated version of the first rectangle
					 Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
				        rect.setFill(Color.WHITE);
				        rect.setArcHeight(27);
				        rect.setArcWidth(27);
				        rect.setStrokeWidth(2);
				        rect.setStroke(Color.BLACK);
				        // Place the rectangle at column 3, row 1 (second row)
				        getChildren().add(rect);
				        
				        rect.setRotate(270);// We are rotating the first rectangle with 270 degrees		
				        rect.setTranslateX(gridSize*0.5);// The rectangle's location is changed because of rotating so we are changing it's X axis with half of it's size
				        rect.setTranslateY(gridSize*0.5);//Then we are translating it's Y axis 
				        
				        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10); //Big square inside rectangle
				        square.setFill(chosenColor);
				        getChildren().add(square); 
				        square.setTranslateY(27);//Repositioning it's y axis because of the rotating 
				        square.setTranslateX(gridSize+5);// Then it's X axis 
				        square.setArcHeight(27);
				        square.setArcWidth(27);
				        square.setStrokeWidth(2);
				        square.setStroke(Color.BLACK);
				        square.setRotate(270); //We are rotating the big square
				        
				        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
				        square2.setFill(chosenColor);
				        getChildren().add(square2); 
				        square2.setTranslateY(26.5);//Repositioning it's x axis because of the rotating 
				        square2.setTranslateX(gridSize+10);	//Repositioning it's y axis because of the rotating 
				        square2.setArcHeight(27);
				        square2.setArcWidth(27);
				        square2.setStrokeWidth(2);
				        square2.setStroke(Color.BLACK);
				}
				
			}
			else if(type==1) {// We are creating the building with the type 1  
				if(rotation ==0) {
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); // Creating the outer rectangle 
					rect.setFill(Color.WHITE); 
					rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);
			        
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10); // Creating the big circle inside the rectangle 
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(-26); // locating it inside the rectangle with the position we want 
			        square.setTranslateX(0);
			        square.setArcHeight(100);// Making the rectangle a circle with making it's corners 100 percent parabolic
			        square.setArcWidth(100);
			        square.setStrokeWidth(2);//adding borders with 2 pixels  
			        square.setStroke(Color.BLACK);
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20); // creating the small square
			        square2.setFill(chosenColor);// giving the colors of it 	
			        getChildren().add(square2); 
			        square2.setTranslateY(-26);//locating it inside the rectangle 
			        square2.setTranslateX(0);
			        square2.setArcHeight(100);
			        square2.setArcWidth(100);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				else if (rotation == 90) {// making a rotated type 1 building
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
			        rect.setFill(Color.WHITE);
			        rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);
			        
			        rect.setRotate(90); //rotating the first type 1 building with 90 degrees
			        rect.setTranslateX(gridSize*0.5);// translating it's position to where we want 
			        rect.setTranslateY(-gridSize*0.5);
			        
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10);
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(-26.5);
			        square.setTranslateX(0);
			        square.setArcHeight(100);
			        square.setArcWidth(100);
			        square.setStrokeWidth(2);
			        square.setStroke(Color.BLACK);
			       
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
			        square2.setFill(chosenColor);
			        getChildren().add(square2); 
			        square2.setTranslateY(-26);
			        square2.setTranslateX(0);
			        square2.setArcHeight(100);
			        square2.setArcWidth(100);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				else if (rotation == 180) {// making a rotated type 1 building
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
			        rect.setFill(Color.WHITE);
			        rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);
			       
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10);// creating  the big circle with the given size
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(26.5);
			        square.setTranslateX(0);
			        square.setArcHeight(100);
			        square.setArcWidth(100);
			        square.setStrokeWidth(2);
			        square.setStroke(Color.BLACK);
			       
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
			        square2.setFill(chosenColor);
			        getChildren().add(square2); 
			        square2.setTranslateY(26.5);
			        square2.setTranslateX(0);
			        square2.setArcHeight(100);
			        square2.setArcWidth(100);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				else if (rotation == 270) {// making a 270 degree rotated type 1 building
					Rectangle rect = new Rectangle(gridSize * 2, gridSize * 3); 
			        rect.setFill(Color.WHITE);
			        rect.setArcHeight(27);
			        rect.setArcWidth(27);
			        rect.setStrokeWidth(2);
			        rect.setStroke(Color.BLACK);
			        getChildren().add(rect);
			        
			        rect.setRotate(270);
			        rect.setTranslateX(gridSize*0.5);
			        rect.setTranslateY(gridSize*0.5);
			      
			        Rectangle square = new Rectangle(2*gridSize-10,2*gridSize-10);
			        square.setFill(chosenColor);
			        getChildren().add(square); 
			        square.setTranslateY(27);
			        square.setTranslateX(gridSize);
			        square.setArcHeight(100);
			        square.setArcWidth(100);
			        square.setStrokeWidth(2);
			        square.setStroke(Color.BLACK);
			        
			        Rectangle square2 = new Rectangle(2*gridSize-20,2*gridSize-20);
			        square2.setFill(chosenColor);
			        getChildren().add(square2); 
			        square2.setTranslateY(26.5);
			        square2.setTranslateX(gridSize);	
			        square2.setArcHeight(100);
			        square2.setArcWidth(100);
			        square2.setStrokeWidth(2);
			        square2.setStroke(Color.BLACK);
				}
				}
			else if(type ==2) {// creating a type 2 building 
				Rectangle rect = new Rectangle(gridSize , gridSize); // creating a square with the given gridsize
		        rect.setFill(chosenColor);
		        rect.setArcHeight(27);
		        rect.setArcWidth(27);
		        rect.setStrokeWidth(2);
		        rect.setStroke(Color.BLACK);
		        getChildren().add(rect);
			}
		}	
		
		//getter methods for getting grids 
		public int getGridX() {
			return gridX;
		}
		public int getGridY() {
			return gridY;
		}
		    
	}