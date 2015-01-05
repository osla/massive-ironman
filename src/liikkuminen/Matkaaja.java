package liikkuminen;

/** 
 *Robotti liikkuu eteen ja taakse (negatiiviset arvot) ja mikäli palat loppuvat, robotti
 *pysähtyy ja ilmoittaa kuljetun matkan.
 */

import lejos.nxt.*;
import lejos.robotics.navigation.*;
//import java.util.*;

public class Matkaaja {

	DifferentialPilot pilotti;
	TouchSensor ts = new TouchSensor(SensorPort.S3);

	public Matkaaja(NXTRegulatedMotor vm, NXTRegulatedMotor om){
		pilotti = new DifferentialPilot(2.25f, 5.5f, vm, om);
	}


	public void liiku(float matka){
		pilotti.travel(matka);
		while (pilotti.isMoving()){
			if(ts.isPressed()){
				pilotti.stop();
				System.out.println("Lajittelurobo liikkui "+pilotti.getMovement().getDistanceTraveled());
				Button.waitForPress();
				System.exit(0);
			}
		}
	}
}
