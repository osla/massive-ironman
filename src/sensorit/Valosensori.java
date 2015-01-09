package sensorit;

import lejos.nxt.*;

public class Valosensori {

	private LightSensor ls;
	private int VALKOINEN;

	public Valosensori(SensorPort sp){
		this.ls = new LightSensor(sp);
	}

	public int mikaVari(){
		int arvo = ls.getLightValue();
		System.out.println("sensori:" + arvo);
		if (arvo < VALKOINEN){
			return 1;
		} else { 
			return 0;
		}
	}
	
	//Robotin kalibrointi. Ensimmäisen palan väriset ja sitä vaaleammat palat 
	//tiputetaan ensimmäiseen kasaan.
	public void kalibroi() throws Exception {
		LCD.drawString("Paina VASEN:", 0, 1);
		LCD.drawString("aloittaaksesi", 0, 2);
		LCD.drawString("arvolla: ", 0, 3);
		while(!Button.LEFT.isPressed()){
			LCD.drawString(" " + (ls.getLightValue()-1), 8, 3); //raja-arvo lavennetaan yhtä pykälää tummemaksi
		}
		VALKOINEN = ls.getLightValue()-1;
		Thread.sleep(2000);;
	}
}


