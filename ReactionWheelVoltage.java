package skyNet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class ReactionWheelVoltage extends VBox{
	TextField tfVoltage;
	float f;
	Time t;
	
	public ReactionWheelVoltage(){
		final Label labelV = new Label();
		labelV.setText("Voltage");
		tfVoltage = new TextField();
		
		final Circle circle_Voltage = new Circle();
		circle_Voltage.setRadius(10);
		circle_Voltage.setStrokeType(StrokeType.INSIDE);
		circle_Voltage.setStrokeWidth(10);
		
		tfVoltage.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov,
					String n1,String n2) {
				Float VoltageS=Float.valueOf(n2);
				float cur = Float.valueOf(VoltageS);
				
				if(cur <= 3.22){
				circle_Voltage.setFill(Color.GREEN);
				}
				
				else{
					circle_Voltage.setFill(Color.RED);
				}	
			}
		});
		
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Voltage");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Voltage of the reaction wheel");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
		
		this.getChildren().addAll(labelV, tfVoltage, circle_Voltage, lineChart);
	}
	
	public void setTextRWVolt(String s){
		tfVoltage.setText(s);
	}
}
