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

public class LightSensorTemperature extends VBox{
	TextField tfTemp;
	float f;
	Time t;

	public LightSensorTemperature(){
		final Label labelTemp = new Label();
		labelTemp.setText("Temperature");
		tfTemp = new TextField();
		
		final Circle circle_Temp = new Circle();
		circle_Temp.setRadius(10);
		circle_Temp.setStrokeType(StrokeType.INSIDE);
		circle_Temp.setStrokeWidth(10);
		
		tfTemp.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov1,
					String n1, String n2) {
				Float tempS=Float.valueOf(n2);
				float temp = Float.valueOf(tempS);
				
				if(temp > -30 && temp < 80){
				circle_Temp.setFill(Color.GREEN);
			}
			else{
				circle_Temp.setFill(Color.RED);
			}	
			}
		});
		
		/*tfTemp.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov,
					String s1, String s2) {
				double temperature = Double.valueOf(s2);
				double temp = Double.valueOf(temperature);
				if(temp > -30 && temp < 80){
					circle_Temp.setFill(Color.GREEN);
				}
				else{
					circle_Temp.setFill(Color.RED);
				}	
			}
		});*/
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Temperature");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Temperature of the sensor");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
        
        this.getChildren().addAll(labelTemp, tfTemp, circle_Temp, lineChart);
	}
	
	public void setTextTemp(String s){
		tfTemp.setText(s);
	}
}
