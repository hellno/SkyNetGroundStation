package skyNet;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RotationVelocity extends VBox{
	TextField tfRV;
	float f;
	Time t;
	
	public RotationVelocity(){
		final Label labelRV = new Label();
		labelRV.setText("Rotationvelocity");
		tfRV = new TextField();
		

		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Rotationvelocity");
		Yaxis.setLabel("Time");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Rotation velocity of the satellite");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
		
		this.getChildren().addAll(labelRV, tfRV, lineChart);
	}
	
	public void setTextRotVel(String s){
		tfRV.setText(s);
	}
	
	public void setValueFloat(float f){
		f = 0;
	}
}

