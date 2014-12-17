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

public class ReactionWheelPWM extends VBox{
	TextField tfPWM;
	float f;
	Time t;
	
	public ReactionWheelPWM(){
		final Label labelPWM = new Label();
		labelPWM.setText("PWM signal");
		tfPWM = new TextField();
		
		final Circle circle_PWM = new Circle();
		circle_PWM.setRadius(10);
		circle_PWM.setStrokeType(StrokeType.INSIDE);
		circle_PWM.setStrokeWidth(10);
		
		tfPWM.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov,
					String n1, String n2) {
				Float CurrentS=Float.valueOf(n2);
				float cur = Float.valueOf(CurrentS);
				
				if(cur <= 3.22){
				circle_PWM.setFill(Color.GREEN);
				}
				
				else{
					circle_PWM.setFill(Color.RED);
				}	
			}
		});
		
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("PWM");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("PWM of the reaction wheel");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
		
		this.getChildren().addAll(labelPWM, tfPWM, circle_PWM, lineChart);
	}
	
	public void setTextPWM(String s){
		tfPWM.setText(s);
	}
}
