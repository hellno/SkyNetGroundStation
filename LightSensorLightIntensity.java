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

public class LightSensorLightIntensity extends VBox{
	TextField tfLightIntensity;
	float f;
	Time t;
	
	public LightSensorLightIntensity(){
		final Label labelLI = new Label();
		labelLI.setText("LightIntensity");
		tfLightIntensity = new TextField();
		
		final Circle circle_LightIntensity = new Circle();
		circle_LightIntensity.setRadius(10);
		circle_LightIntensity.setStrokeType(StrokeType.INSIDE);
		circle_LightIntensity.setStrokeWidth(10);
		
		tfLightIntensity.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov,
					String n1, String n2) {
				Float LightIntensityS=Float.valueOf(n2);
				float light = Float.valueOf(LightIntensityS);
				
				if(light >= 0 && light <= 255){
				circle_LightIntensity.setFill(Color.GREEN);
			}
			else{
				circle_LightIntensity.setFill(Color.RED);
			}	
			}
		});
		
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Light Intensity");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart4 = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart4.setTitle("Light Intensity of the sensor");
		
		XYChart.Series<Number, Number> xyc4= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc4.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart4.getData().add(xyc4);
		
		this.getChildren().addAll(labelLI, tfLightIntensity, circle_LightIntensity, lineChart4);
	}
	
	public void setText(String s){
		tfLightIntensity.setText(s);
	}
}
