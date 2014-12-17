package skyNet;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class GyroRoll extends VBox{
	Label labelRoll;
	float min;
	float max;
	
	TextField tfRoll;
	Line line;
	
	public GyroRoll(float min, float max){		
		this.min = min;
		min = -360;
		this.max = max;
		max = 360;
		
		labelRoll = new Label();
		labelRoll.setText("Roll");
		
		tfRoll = new TextField();
		
		Circle circle = new Circle();
		circle.setRadius(120);
		circle.setStrokeType(StrokeType.INSIDE);
		circle.setFill(Color.YELLOW);
		circle.setStrokeWidth(10);
		
		Text text1 = new Text("0°/360°");
		text1.setX(-10);
		text1.setY(-120);
        Text text2 = new Text("90°");
        text2.setX(120);
        text2.setY(0);
        Text text3 = new Text("180°");
        text3.setX(0);
        text3.setY(130);
        Text text4 = new Text("270°");
        text4.setX(-145);
        text4.setY(0);
		
        line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(120);
        line.setEndY(0);
        
        Group group = new Group();
        group.prefHeight(10);
        group.prefWidth(0);
		group.getChildren().addAll(circle, text1, text2, text3, text4, line);
		
		this.getChildren().addAll(labelRoll, tfRoll, group);
	}
	
	public void newValue(double angle){
		tfRoll.setText(String.valueOf(angle));
		line.setEndX(Math.sin(angle*(Math.PI/180))*120);
		line.setEndY(Math.cos(angle*(Math.PI/180))*120);
	}
	
	public void setTextRoll(String s){
		tfRoll.setText(s);
	}
}
