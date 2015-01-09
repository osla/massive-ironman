package liikkuminen;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;


/*
 *Kontrolloi syöttökonetta
 */

public class Tiputtaja {

	NXTRegulatedMotor tiputtaja;
	TouchSensor painoSensori;
	public int lkm = 0;

	public Tiputtaja (NXTRegulatedMotor tiputtavaMoottori){
		tiputtaja = tiputtavaMoottori;
		painoSensori = new TouchSensor(SensorPort.S3); 
	}

	public boolean tiputaYksi() throws Exception {
		lkm++;
		if(painoSensori.isPressed()){
			LCD.clear();
			LCD.drawString("Lajittelin " + lkm, 0, 1);
			LCD.drawString("palaa", 0, 2);
			Button.waitForPress(5000);
			System.exit(0);
		}
		tiputtaja.setSpeed(100);
		tiputtaja.rotate(-33);
		return true;
	}
}