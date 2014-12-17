package skyNet;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RawTelemetryData extends VBox{
	TextField tfR;
	TextField tfP;
	TextField tfY;
	TextField tfRV;
	TextField tfBC;
	TextField tfBV; 
	TextField tfST;
	TextField tfSLI;
	TextField tfRWC;
	TextField tfRWV;
	TextField tfPWM;
	TextField tfG;
	TextField tfMx;
	TextField tfMy;
	TextField tfMz;
	TextField tfAx;
	TextField tfAy;
	TextField tfAz;
	
	public RawTelemetryData(){
		final Label lRoll = new Label();
		lRoll.setText("roll angle");
		tfR = new TextField();
		
		final Label lPitch = new Label();
		lPitch.setText("pitch angle");
		tfP = new TextField();
		
		final Label lYaw = new Label();
		lYaw.setText("yaw angle");
		tfY = new TextField();
		
		final Label lRV = new Label();
		lRV.setText("rotationvelocity");
		tfRV = new TextField();
		
		final Label lBC = new Label();
		lBC.setText("current of the battery");
		tfBC = new TextField();
		
		final Label lBV = new Label();
		lBV.setText("voltage of the battery");
		tfBV = new TextField();
		
		final Label lSensorTemp = new Label();
		lSensorTemp.setText("temperature of the sensor");
		tfST = new TextField();
		
		/*final Label lSensorVolt = new Label();
		lSensorVolt.setText("Voltage of the sensor");
		final TextField tfSV = new TextField();
		
		final Label lSensorCur = new Label();
		lSensorCur.setText("Current of the sensor");
		final TextField tfSC = new TextField();*/
		
		final Label lSensorLightIntensity = new Label();
		lSensorLightIntensity.setText("light intensity of the sensor");
		tfSLI = new TextField();
		
		final Label lRWC = new Label();
		lRWC.setText("current of the reaction wheel");
		tfRWC = new TextField();
		
		final Label lRWV = new Label();
		lRWV.setText("voltage of the reaction wheel");
		tfRWV = new TextField();
		
		final Label lPWM = new Label();
		lPWM.setText("PWM signal of the reaction wheel");
		tfPWM = new TextField();
		
		/*final Label lReactionWheelRoll = new Label();
		lReactionWheelRoll.setText("roll angle of the reaction wheel");
		tfRWR = new TextField();*/
		
		final Label lGyro = new Label();
		lGyro.setText("Angular rate of the gyrometer");
		tfG = new TextField();
		
		final Label lMagnetx = new Label();
		lMagnetx.setText("x component of the magnetic earth field M");
		tfMx = new TextField();
		
		final Label lMagnety = new Label();
		lMagnety.setText("y component of the magnetic earth field M");
		tfMy = new TextField();
		
		final Label lMagnetz = new Label();
		lMagnetz.setText("z component of the magnetic earth field M");
		tfMz = new TextField();
		
		final Label lAx = new Label();
		lAx.setText("x component of the accelerometer");
		tfAx = new TextField();
		
		final Label lAy = new Label();
		lAy.setText("y component of the accelerometer");
		tfAy = new TextField();
		
		final Label lAz = new Label();
		lAz.setText("z component of the accelerometer");
		tfAz = new TextField();
		
		HBox hb10 = new HBox();
		hb10.getChildren().addAll(lRoll, tfR);
		
		HBox hb11 = new HBox();
		hb11.getChildren().addAll(lPitch, tfP);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(lYaw, tfY);
		
		HBox hb12 = new HBox();
		hb12.getChildren().addAll(lRV, tfRV);
		
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(lSensorTemp, tfST);
		
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(lBC, tfBC);
		
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(lBV, tfBV);
		
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(lSensorLightIntensity, tfSLI);
		
		HBox hb6 = new HBox();
		hb6.getChildren().addAll(lRWC, tfRWC);
		
		HBox hb7 = new HBox();
		hb7.getChildren().addAll(lRWV, tfRWV);
		
		HBox hb13 = new HBox();
		hb13.getChildren().addAll(lPWM, tfPWM);
		
		HBox hb8 = new HBox();
		hb8.getChildren().addAll(lGyro, tfG);
		
		HBox hb9 = new HBox();
		hb9.getChildren().addAll(lMagnetx, tfMx);
		
		HBox hb17 = new HBox();
		hb17.getChildren().addAll(lMagnety, tfMy);
		
		HBox hb18 = new HBox();
		hb18.getChildren().addAll(lMagnetz, tfMz);
		
		HBox hb14 = new HBox();
		hb14.getChildren().addAll(lAx, tfAx);
		
		HBox hb15 = new HBox();
		hb15.getChildren().addAll(lAy, tfAy);
		
		HBox hb16 = new HBox();
		hb16.getChildren().addAll(lAz, tfAz);
		
		this.getChildren().addAll(hb10, hb11, hb, hb12, hb1, hb4, hb2, hb3, hb6, hb7, hb13, hb8, 
				hb9, hb17, hb18, hb14, hb15, hb16);
	}
	
	public void setTextRoll(String s){
		tfR.setText(s);
	}
	
	public void setTextPitch(String s){
		tfP.setText(s);
	}
	
	public void setTextYaw(String s){
		tfY.setText(s);
	}
	
	public void setTextRotVel(String s){
		tfRV.setText(s);
	}
	
	public void setTextBatCur(String s){
		tfBC.setText(s);
	}
	
	public void setTextBatVol(String s){
		tfBV.setText(s);
	}
	
	public void setTextSensorTmp(String s){
		tfST.setText(s);
	}
	
	public void setTextSensorLI(String s){
		tfSLI.setText(s);
	}
	
	public void setTextRWCur(String s){
		tfRWC.setText(s);
	}

	public void setTextRWVolt(String s){
		tfRWV.setText(s);
	}

	public void setTextRWPWM(String s){
		tfPWM.setText(s);
	}
	
	public void setTextGyrometer(String s){
		tfG.setText(s);
	}
	
	public void setTextMagnetometerX(String s){
		tfMx.setText(s);
	}
	
	public void setTextMagnetometerY(String s){
		tfMy.setText(s);
	}
	
	public void setTextMagnetometerZ(String s){
		tfMz.setText(s);
	}
	
	public void setTextAccelerometerX(String s){
		tfAx.setText(s);
	}

	public void setTextAccelerometerY(String s){
		tfAy.setText(s);
	}

	public void setTextAccelerometerZ(String s){
		tfAz.setText(s);
	}
}
