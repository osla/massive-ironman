package liikkuminen;

/** 
 *Robotti liikkuu eteen ja taakse (negatiiviset arvot) ja mikäli palat loppuvat, robotti
 *pysähtyy.
 */

import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class Matkaaja {

	DifferentialPilot pilotti;
	TouchSensor ts = new TouchSensor(SensorPort.S3);
	NXTRegulatedMotor vasenMoottori;

	public Matkaaja(NXTRegulatedMotor vm, NXTRegulatedMotor om){
		vasenMoottori = vm;
		pilotti = new DifferentialPilot(2.25f, 5.5f, vm, om);
		pilotti.setAcceleration(1000); //default on 6000 (astetta/sekuntti)
	}

	public void liiku(float matka){
		pilotti.travel(matka);
		while (pilotti.isMoving()){
			if(ts.isPressed()){
				pilotti.stop();
				System.exit(0);
			}
		}
	}
	
	public boolean liikkuuko(){
		return pilotti.isMoving();
	}

}
