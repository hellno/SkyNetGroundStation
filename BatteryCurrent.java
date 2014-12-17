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

public class BatteryCurrent extends VBox{
	TextField tfCurrent;
	XYChart.Series<Number, Number> xyc;
	//float f;
	Time t;
	
	public BatteryCurrent(){
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
					String n1, String n2) {
				Float CurrentS=Float.valueOf(n2);
				float cur = Float.valueOf(CurrentS);
				
				if(cur <= 3.22){
				circle_Current.setFill(Color.GREEN);
				}
				
				else{
					circle_Current.setFill(Color.RED);
				}	
			}
		});
		
		
		final NumberAxis Xaxis = new NumberAxis();
		final NumberAxis Yaxis = new NumberAxis();
		Xaxis.setLabel("Current");
		Yaxis.setLabel("Number of measurements");
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(Xaxis,Yaxis);
		lineChart.setTitle("Current of the battery");
		
		xyc= new XYChart.Series<Number, Number>();
		t = new Time();
		//xyc.getData().add(new XYChart.Data<Number, Number>(f, t.maxSize));
        
        lineChart.getData().add(xyc);
		
		this.getChildren().addAll(labelC, tfCurrent, circle_Current, lineChart);
	}
	
	public void setTextBatCur(String s){
		tfCurrent.setText(s);
		xyc.getData().add(new XYChart.Data<Number, Number>(Double.valueOf(s), t.maxSize));
	}
	
}
