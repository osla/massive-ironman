package sensorit;

import lejos.nxt.*;

public class Valosensori {

	private LightSensor ls;
	private int VALKOINEN;
	private int PUNAINEN;

	public Valosensori(SensorPort sp, int valkoinen, int punainen){
		this.ls = new LightSensor(sp);
		this.PUNAINEN = punainen;
		this.VALKOINEN = valkoinen;
	}

	public int mikaVari(){
		int arvo = ls.getLightValue();
		System.out.println("sensori:"+arvo);
		//Thr.sleep(2000);
		if (arvo>VALKOINEN) return 0;
		else return 1;
	}
}

