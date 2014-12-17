package skyNet;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Magnetometer extends VBox{
	TextField tfMx;
	TextField tfMy;
	TextField tfMz;
	
	public Magnetometer(){
		final Label lMagnet = new Label();
		lMagnet.setText("Magnetic Earth Field M");
		
		final Label lMx = new Label();
		lMx.setText("x component of matrix M");
		tfMx = new TextField();
		
		final Label lMy = new Label();
		lMy.setText("y component of matrix M");
		tfMy = new TextField();
		
		final Label lMz = new Label();
		lMz.setText("z component of matrix M");
		tfMz = new TextField();
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(lMx, tfMx);
		
		VBox vbox1 = new VBox();
		vbox1.getChildren().addAll(lMy, tfMy);
		
		VBox vbox2 = new VBox();
		vbox2.getChildren().addAll(lMz, tfMz);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, vbox1, vbox2);
		
		this.getChildren().addAll(lMagnet, hbox);
	}
	
	public void setTextMagnetometerX(String s){
		tfMx.setText(s);
	}
	
	public void setTextMagnetometerY(String s){
		tfMy.setText(s);
	}
	
	public void setTextMagnetometerZ(String s){
		tfMz.setText(s);
	}
	
}
