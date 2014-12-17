package skyNet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Communication extends VBox{
	public Communication(){
		final Button bStandBy = new Button();
		bStandBy.setText("Standby Mode");
		bStandBy.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("STNDBY");
			}
		});
		
		final Button bRotation = new Button();
		bRotation.setText("Rotation Mode");
		bRotation.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("ROTMOD");
			}
		});
		
		final Button bCompassStabilizing = new Button();
		bCompassStabilizing.setText("CompassStabilizing Mode");
		bCompassStabilizing.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("COMPAS");
			}
		});
		
		final Button bSunFinder = new Button();
		bSunFinder.setText("Sun Finder Mode");
		bSunFinder.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("SUNFIN");
			}
		});
		
		final Button bSpaceMission = new Button();
		bSpaceMission.setText("Space Mission Mode");
		bSpaceMission.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("MISION");
			}
		});
		
		//Rotationsgeschwindigkeit SETROT deg/sec
		final Button bRotationVelocity = new Button();
		bRotationVelocity.setText("Rotationvelocity of the Satellite");
		bRotationVelocity.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("SETROT");
			}
		});
		
		final Button bYawAngle = new Button();
		bYawAngle.setText("Yaw angle of the Satellite");
		bYawAngle.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("SETYAW");
			}
		});
		
		//SETPWM +-0-100% (Reaction wheel)
		final Button bPWM = new Button();
		bPWM.setText("PWM signal of the reaction wheel");
		bPWM.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				SendAndReceive sar = SendAndReceive.getInstance();
				sar.sendSerialPort("SETPWM");
			}
		});
		
		this.getChildren().addAll(bStandBy, bRotation, bCompassStabilizing, bSunFinder, bSpaceMission, 
				bRotationVelocity, bYawAngle, bPWM);
	}
}
