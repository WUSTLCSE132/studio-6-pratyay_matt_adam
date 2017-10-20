package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	void writeByte(byte singleByte) {
		try {
			debug = port.writeByte(singleByte);
		}
		catch(SerialPortException e) {
			e.printStackTrace();
		}
		if(debug) {
			String temp = Integer.toHexString(singleByte);
			System.out.println("0x" + temp);
		}
	}
	
	
	
	// TODO: Add available() method
	boolean available() {
		boolean avail = false;
		try {
			if(port.getInputBufferBytesCount() > 0)
				avail = true;
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return avail;
		
	}
	
	// TODO: Add readByte() method	
	
	// TODO: Add a main() method
}
