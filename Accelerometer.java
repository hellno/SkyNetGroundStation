package skyNet;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Accelerometer extends VBox{
	TextField tfx;
	TextField tfy;
	TextField tfz;
	Time t;
	float fx;
	float fy;
	float fz;
	
	@SuppressWarnings("unchecked")
	public Accelerometer(){
		final Label lx = new Label();
		lx.setText("x component");
		final Label ly = new Label();
		ly.setText("y component");
		final Label lz = new Label();
		lz.setText("z component");
		
		tfx = new TextField();
		tfy = new TextField();
		tfz = new TextField();
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("x, y, z of the accelerometer");
		Xaxis.autoRangingProperty();
		Yaxis.setLabel("time");
		Yaxis.autoRangingProperty();
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Accelerometer");
		
		t = new Time();
		
		XYChart.Series<Number, Number> series1= new XYChart.Series<Number, Number>();
		series1.setName("x");
		fx = 0;
		series1.getData().add(new XYChart.Data<Number, Number>(fx, t.maxSize));
        
        XYChart.Series<Number, Number> series2= new XYChart.Series<Number, Number>();
        series2.setName("y");
        fy = 0;
		series2.getData().add(new XYChart.Data<Number, Number>(fy, t.maxSize));
        
        XYChart.Series<Number, Number> series3= new XYChart.Series<Number, Number>();
        series3.setName("z");
        fz = 0;
		series3.getData().add(new XYChart.Data<Number, Number>(fz, t.maxSize));
        
        lineChart.getData().addAll(series1, series2, series3);
        
        this.getChildren().addAll(lx, tfx, ly, tfy, lz, tfz, lineChart);
	}
	
	public void setTextAccX(String s){
		tfx.setText(s);
	}
	
	public void setTextAccY(String s){
		tfy.setText(s);
	}
	
	public void setTextAccZ(String s){
		tfz.setText(s);
	}
}
