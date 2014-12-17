package skyNet;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class LightSensorSunFinder extends HBox{
	TextField tfSun = new TextField();
	Circle circleSun = new Circle();
	
	public LightSensorSunFinder(){
		circleSun.setRadius(10);
		this.setMinWidth(200);
		
		this.getChildren().addAll(tfSun, circleSun);
	}
	
	public void setSunFound(){
		tfSun.setText("sun is found");
		circleSun.setFill(Color.GREEN);
	}
	
	public void setSunNotFound(){
		tfSun.setText("sun is not found");
		circleSun.setFill(Color.RED);
	}
}
