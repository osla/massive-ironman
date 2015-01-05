package lajittelukone;

import lejos.nxt.*;
import liikkuminen.*;
import sensorit.Valosensori;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Lajittelukone {

	private Valosensori vs;
	private Matkaaja kone;
	private Tiputtaja tiputtaja;
	private final int raja_VALKOINEN = 38;
	private final int raja_PUNAINEN = 25;
	private final int MATKA = 10;



	public Lajittelukone(NXTRegulatedMotor tm, NXTRegulatedMotor om, NXTRegulatedMotor vm, SensorPort valoSensori) {
		kone = new Matkaaja(vm, om);
		vs = new Valosensori(valoSensori, raja_VALKOINEN, raja_PUNAINEN);
		tiputtaja = new Tiputtaja(tm);
	}

	public void aloita() throws Exception{
		int vari;
		while(!Button.ESCAPE.isPressed()){
			vari=vs.mikaVari();
			System.out.println("Vari " + vari);
			Thread.sleep(2000);
			kone.liiku(MATKA*vari);
			
			if(Tiputtaja.tiputaYksi()){
				kone.liiku(-MATKA*1);
			}
		}
	}
}










