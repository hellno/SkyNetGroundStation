package skyNet;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Quaternions extends VBox{
	int maxWidth;
	Label labelQuaternions;
	TextField q1;
	TextField q2;
	TextField q3;
	TextField q4;
	VBox vbox;
	public Quaternions(int maxWidth){
		this.maxWidth = maxWidth;
		maxWidth = 100;
				
		labelQuaternions = new Label();
		labelQuaternions.setText("Quaternions");
		
		q1 = new TextField();
		q1.setMaxWidth(maxWidth);
		
		q2 = new TextField();
		q2.setMaxWidth(maxWidth);
		
		q3 = new TextField();
		q3.setMaxWidth(maxWidth);
		
		q4 = new TextField();
		q4.setMaxWidth(maxWidth);
		
		this.getChildren().addAll(labelQuaternions, q1, q2, q3, q4);
	}
	
	public VBox getVbox(){
		return vbox;
	}
	
	public void setTextQ1(String s){
		q1.setText(s);
	}
	
	public void setTextQ2(String s){
		q2.setText(s);
	}
	
	public void setTextQ3(String s){
		q3.setText(s);
	}
	
	public void setTextQ4(String s){
		q4.setText(s);
	}
}
