package skyNet;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;


public class GroundStation extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	SendAndReceive sar = new SendAndReceive();
	Quaternions quat = new Quaternions(100);
	GyroRoll r = new GyroRoll(-360, 360);
	GyroPitch p = new GyroPitch(-360, 360);
	GyroYaw y = new GyroYaw(-360, 360);
	RotationVelocity rv = new RotationVelocity();
	BatteryVoltage bv = new BatteryVoltage();
	BatteryCurrent bc = new BatteryCurrent();
	LightSensorTemperature lst = new LightSensorTemperature();
	LightSensorLightIntensity lsli = new LightSensorLightIntensity();
	LightSensorSunFinder lssf = new LightSensorSunFinder();
	ReactionWheelCurrent rwc = new ReactionWheelCurrent();
	ReactionWheelVoltage rwv = new ReactionWheelVoltage();
	ReactionWheelPWM rwp = new ReactionWheelPWM();
	Camera c = new Camera();
	Gyrometer g = new Gyrometer();
	Magnetometer m = new Magnetometer();
	RawTelemetryData rtd = new RawTelemetryData();
	Communication com = new Communication();
	Accelerometer a = new Accelerometer();
	
	public void start(final Stage stage) throws Exception{
		
		TabPane tp = new TabPane();
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		Tab y_tab = new Tab("Satellite");
		Tab quat_tab = new Tab("Quaternions");
		Tab battery_tab = new Tab("Battery");
		Tab sensor_tab = new Tab("Light Sensor");
		Tab camera_tab = new Tab("Camera");
		Tab reactionwheel_tab = new Tab("Reaction Wheel");
		Tab gyroAndMagnetometer_tab = new Tab("Gyrometer and Magnetometer");
		Tab rawTelemetry_tab = new Tab("Raw Data of the Telemetry");
		Tab communication_tab = new Tab("Communication");
		Tab accelerometer_tab = new Tab("Accelerometer");
		tp.getTabs().addAll(y_tab, quat_tab, battery_tab, sensor_tab, camera_tab, reactionwheel_tab, 
				gyroAndMagnetometer_tab, accelerometer_tab, rawTelemetry_tab, communication_tab);
		
		GridPane gp = new GridPane();
		gp.add(y, 2, 0);
		gp.add(rv, 3, 0);
		gp.add(r, 0, 0);
		gp.add(p, 1, 0);
		
		y_tab.setContent(gp);
		
		GridPane gp1 = new GridPane();
		gp1.add(lssf, 0, 0);
		gp1.add(lst, 0, 1);
		gp1.add(lsli, 1, 1);
		
		sensor_tab.setContent(gp1);		
		
		GridPane gp2 = new GridPane();
		gp2.add(c, 0, 0);
		
		camera_tab.setContent(gp2);
		
		GridPane gp3 = new GridPane();
		gp3.add(rwc, 0, 0);
		gp3.add(rwv, 1, 0);
		gp3.add(rwp, 2, 0);
		
		reactionwheel_tab.setContent(gp3);
		
		GridPane gp4 = new GridPane();
		gp4.add(com, 0, 0);
		
		communication_tab.setContent(gp4);
		
		GridPane gp5 = new GridPane();
		gp5.add(g, 0, 0);
		gp5.add(m, 1, 0);
		
		gyroAndMagnetometer_tab.setContent(gp5);
		
		GridPane gp6 = new GridPane();
		gp6.add(rtd, 0, 0);
		
		rawTelemetry_tab.setContent(gp6);
		
		GridPane gp7 = new GridPane();
		gp7.add(bc, 0, 0);
		gp7.add(bv, 1, 0);
		
		battery_tab.setContent(gp7);
		
		GridPane gp8 = new GridPane();
		gp8.add(a, 0, 0);
		
		accelerometer_tab.setContent(gp8);
		
		GridPane gp9 = new GridPane();
		gp9.add(quat, 0, 0);
		
		quat_tab.setContent(gp9);
		
		
		Scene scene = new Scene(tp);
		scene.setFill(Color.AZURE);
		
		lssf.setSunFound();
		lssf.setSunNotFound();
		
		c.setPictureIsLoad();
		c.setPictureIsNotLoad();
		
		r.newValue(30);
		p.newValue(60);
		y.newValue(90);
		
		stage.setX(100);
		stage.setY(10);
		stage.setHeight(700);
		stage.setWidth(1150);
		
		
		
		stage.setScene(scene);
		
		stage.show();
	}
}

