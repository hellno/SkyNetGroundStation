package skyNet;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Gyrometer extends VBox{
	TextField tfGyro;
	float f;
	Time t;
	
	public Gyrometer(){
		final Label lGyro = new Label();
		lGyro.setText("Angular Rate of the Gyrometer");
		tfGyro = new TextField();
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Angular Rate");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Angular Rate of the Gyrometer");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
        
        this.getChildren().addAll(lGyro, tfGyro, lineChart);
	}
	
	public void setTextGyrometer(String s){
		tfGyro.setText(s);
	}
}
