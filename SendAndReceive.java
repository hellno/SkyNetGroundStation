package skyNet;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;


public class SendAndReceive {

	CommPortIdentifier serialPortId;
	@SuppressWarnings("rawtypes")
	Enumeration enumComm = null;
	SerialPort serialPort;
	OutputStream outputStream;
	InputStream inputStream;
	boolean serialPortIsOpen = false;

	int baudrate = 115200;
	int dataBits = SerialPort.DATABITS_8;
	int stopBits = SerialPort.STOPBITS_1;
	int parity = SerialPort.PARITY_NONE;
	String portName = "/dev/ttyUSB0";
	
	int secondsRuntime = 60;
	
	public boolean openSerialPort(String portName){
		//portName = "COM3";
		Boolean foundPort = false;
		if (serialPortIsOpen != false) {
			System.out.println("serialport is already open");
			return false;
		}
		System.out.println("open serialport");
		enumComm = CommPortIdentifier.getPortIdentifiers();
		while(enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (portName.contentEquals(serialPortId.getName())) {
				foundPort = true;
				break;
			}
		}
		if (foundPort != true) {
			System.out.println("serialport not found: " + portName);
			return false;
		}
		try {
			serialPort = (SerialPort) serialPortId.open("open and send", 500);
		} catch (PortInUseException e) {
			System.out.println("port is already taken");
		}
		try {
			inputStream = serialPort.getInputStream();
		} catch (IOException e) {
			System.out.println("no access to the InputStream");
		}
		
		try {
			serialPort.addEventListener(new SerialPortEventListener());
		} catch (TooManyListenersException e) {
			System.out.println("TooManyListenersException for Serialport");
		}
		serialPort.notifyOnDataAvailable(true);
		try {
			serialPort.setSerialPortParams(baudrate, dataBits, stopBits, parity);
		} catch(UnsupportedCommOperationException e) {
			System.out.println("couldn´t set the interface-paramter");
		}
		
		serialPortIsOpen = true;
		return true;
	}
	
	public void closeSerialPort()
	{
		if ( serialPortIsOpen == true) {
			System.out.println("close Serialport");
			serialPort.close();
			serialPortIsOpen = false;
		} else {
			System.out.println("Serialport is already closed");
		}
	}
	
	
	BatteryCurrent bc = new BatteryCurrent();
	BatteryVoltage bv = new BatteryVoltage();
	Accelerometer a = new Accelerometer();
	Magnetometer m = new Magnetometer();
	LightSensorTemperature lst = new LightSensorTemperature();
	LightSensorLightIntensity lsli = new LightSensorLightIntensity();
	Gyrometer g = new Gyrometer();
	ReactionWheelCurrent rwc = new ReactionWheelCurrent();
	ReactionWheelVoltage rwv = new ReactionWheelVoltage();
	ReactionWheelPWM rwp = new ReactionWheelPWM();
	RotationVelocity rv = new RotationVelocity();
	GyroPitch gp = new GyroPitch(-360, 360);
	GyroRoll gr = new GyroRoll(-360, 360);
	GyroYaw gy = new GyroYaw(-360, 360);
	RawTelemetryData rtd = new RawTelemetryData();
	
	public void receive(String s){
		String delims = ",";
		String s1 = s.substring(0, 5);
		String sValue = s.substring(6, s.length());
			switch(s1){
			case "GYRDAT": String[] sgyr = sValue.split(delims);
			g.setTextGyrometer(sValue);
			gr.setTextRoll(sgyr[0]); //roll
			gp.setTextPitch(sgyr[1]); //pitch
			gy.setTextYaw(sgyr[2]); //yaw
			rtd.setTextRoll(sgyr[0]);
			rtd.setTextPitch(sgyr[1]);
			rtd.setTextYaw(sgyr[2]);
			rtd.setTextGyrometer(sValue);
			break;
			case "ACCDAT": String[] str = sValue.split(delims); 
			a.setTextAccX(str[0]);	//x
			a.setTextAccY(str[1]);  //y
			a.setTextAccZ(str[2]);  //z
			rtd.setTextAccelerometerX(str[0]);
			rtd.setTextAccelerometerY(str[1]);
			rtd.setTextAccelerometerZ(str[2]);
			break;
			case "MAGDAT": String[] st = sValue.split(delims);
			m.setTextMagnetometerX(st[0]); //x
			m.setTextMagnetometerY(st[1]); //y
			m.setTextMagnetometerZ(st[2]); //z
			rtd.setTextMagnetometerX(st[0]);
			rtd.setTextMagnetometerY(st[1]);
			rtd.setTextMagnetometerZ(st[2]);
			break;
			case "LIGHTSN": lsli.setText(sValue);
			rtd.setTextSensorLI(sValue);
			break;
			case "TEMPLS": lst.setTextTemp(sValue);
			rtd.setTextSensorTmp(sValue);
			break;
			case "CURBAT": bc.setTextBatCur(sValue);
			rtd.setTextBatCur(sValue);
			break;
			case "VOLBAT": bv.setTextBatVolt(sValue);
			rtd.setTextBatVol(sValue);
			break;
			case "CURMOT": rwc.setTextRWCurrent(sValue);
			rtd.setTextRWCur(sValue);
			break;
			case "VOLMOT": rwv.setTextRWVolt(sValue);
			rtd.setTextRWVolt(sValue);
			break;
			case "PWMSIG": rwp.setTextPWM(sValue);
			rtd.setTextRWPWM(sValue);
			break;
			case "ROTVEL": rv.setTextRotVel(sValue);
			rtd.setTextRotVel(sValue);
			break;
			}
	}
	
	public void rawDataReceive(){
		boolean b = true;
		while(b){
			
		}
	}
	
	public void serialPortDataAvailable() {
		try {
			byte[] data = new byte[150];
			int num;
			while(inputStream.available() > 0) {
				num = inputStream.read(data, 0, data.length);
				System.out.println("receive: "+ new String(data, 0, num));
			}
		} catch (IOException e) {
			System.out.println("mistake while reading the received data");
		}
	}
	
	public void updateSerialPort(){
		System.out.println("update Serialport-List");
		if (serialPortIsOpen != false) {
			System.out.println("Serialport is open");
			return;
		}
		enumComm = CommPortIdentifier.getPortIdentifiers();
		while(enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println("Found:" + serialPortId.getName());
			}
		}
	}
	
	private static SendAndReceive instance;
	public SendAndReceive(){}
	public static synchronized SendAndReceive getInstance () {
	    if (SendAndReceive.instance == null) {
	      SendAndReceive.instance = new SendAndReceive();
	    }
	    return SendAndReceive.instance;
	  }
	
	public void sendSerialPort(String message)
	{
		System.out.println("send: " + message);
		if (serialPortIsOpen != true)
			return;
		try {
			outputStream.write(message.getBytes());
		} catch (IOException e) {
			System.out.println("mistake while sending");
		}
	}
}
