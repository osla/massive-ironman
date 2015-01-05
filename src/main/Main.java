package main;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lajittelukone.Lajittelukone;

public class Main {

		static final NXTRegulatedMotor tMoottori = Motor.C;
		static final NXTRegulatedMotor vMoottori = Motor.B;
		static final NXTRegulatedMotor oMoottori = Motor.A;
		static final SensorPort valoSensori = SensorPort.S2;
		static final SensorPort painoSensori = SensorPort.S3; //syöttöhäiriön käsittelyyn
	
	public static void main (String[]  aArg) throws Exception{
		Lajittelukone lajittelija = new Lajittelukone(tMoottori, vMoottori, oMoottori, valoSensori);
		
		LCD.drawString("Paina ENTER", 0, 1);
		LCD.drawString("aloittaaksesi", 0, 2);
		Button.waitForPress();
		LCD.clear();
		
		Button.ESCAPE.addButtonListener(new Pysaytysnappi());
		lajittelija.aloita();
	}
}
