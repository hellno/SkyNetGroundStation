package skyNet;

import gnu.io.SerialPortEvent;

public class SerialPortEventListener implements gnu.io.SerialPortEventListener{

	SendAndReceive sar = new SendAndReceive();
	@Override
	public void serialEvent(SerialPortEvent spe) {
		switch (spe.getEventType()) {
		case SerialPortEvent.DATA_AVAILABLE:
			sar.serialPortDataAvailable();
			break;
		case SerialPortEvent.BI:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.FE:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
		case SerialPortEvent.PE:
		case SerialPortEvent.RI:
		default:
		}
	}

}
