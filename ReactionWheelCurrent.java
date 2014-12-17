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

public class ReactionWheelCurrent extends VBox{
	TextField tfCurrent;
	float f;
	Time t;
	
	public ReactionWheelCurrent(){
		final Label labelC = new Label();
		labelC.setText("Current");
		tfCurrent = new TextField();
		
		final Circle circle_Current = new Circle();
		circle_Current.setRadius(10);
		circle_Current.setStrokeType(StrokeType.INSIDE);
		circle_Current.setStrokeWidth(10);
		

		tfCurrent.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov,
					String s1, String s2) {
				Float CurrentS=Float.valueOf(s2);
				float cur = Float.valueOf(CurrentS);
				if(cur <= 3.22){
				circle_Current.setFill(Color.GREEN);
				}
					
				else{
					circle_Current.setFill(Color.RED);					}	
				}
		});
		
		
		
/*		sliderC.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> ov,
					Number n1, Number n2) {
				String CurrentS=Integer.toString(n2.intValue());
				double cur = Double.valueOf(CurrentS);
				
				if(cur <= 3.22){
				circle_Current.setFill(Color.GREEN);
				}
				
				else{
					circle_Current.setFill(Color.RED);
				}	
			}
		});*/
		
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Current");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Current of the reaction wheel");
		
		XYChart.Series<Number, Number> xyc= new XYChart.Series<Number, Number>();
		f = 0;
		t = new Time();
		xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
		
		this.getChildren().addAll(labelC, tfCurrent, circle_Current, lineChart);
	}
	
	public void setTextRWCurrent(String s){
		tfCurrent.setText(s);
	}
}
