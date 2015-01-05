package liikkuminen;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;


/*
 *Kontrolloi syöttökonetta
 */

public class Tiputtaja {

	private static NXTRegulatedMotor tiputtaja;

	public Tiputtaja (NXTRegulatedMotor tiputtavaMoottori){
		tiputtaja = new NXTRegulatedMotor(MotorPort.C);
	}

	public static boolean tiputaYksi() throws Exception {
		tiputtaja.setSpeed(100);
		tiputtaja.rotate(-33);
		return true;
	}
}