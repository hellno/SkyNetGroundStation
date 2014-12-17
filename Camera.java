package skyNet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Camera extends VBox{
	Circle circle = new Circle();
	TextField tfcircle = new TextField();
	public Camera(){
		final Button b_camera = new Button();
		b_camera.setText("load picture");
		b_camera.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	
		    }
		});
		
		circle.setRadius(10);
		circle.setStrokeType(StrokeType.INSIDE);
		circle.setStrokeWidth(10);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(tfcircle, circle);
		this.getChildren().addAll(b_camera, hb);
	}
	
	public void setPictureIsLoad(){
		tfcircle.setText("picture loads");
		circle.setFill(Color.GREEN);
	}
	
	public void setPictureIsNotLoad(){
		tfcircle.setText("picture is not load");
		circle.setFill(Color.RED);
	}
}
