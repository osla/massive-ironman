package lajittelukone;

import lejos.nxt.*;
import liikkuminen.*;
import sensorit.Valosensori;

/**
 * Luokka sisältää toiminnallisuuden
 *
 */
public class Lajittelukone {

	private Valosensori vs;
	private Matkaaja kone;
	private Tiputtaja tiputtaja;
	private final int MATKA = 10;
	private int sijainti=0;
	private NXTRegulatedMotor vasenMootori;



	public Lajittelukone(NXTRegulatedMotor tm, NXTRegulatedMotor om, NXTRegulatedMotor vm, SensorPort valoSensori) {
		vasenMootori = vm;
		kone = new Matkaaja(vm, om);
		vs = new Valosensori(valoSensori);
		tiputtaja = new Tiputtaja(tm);
	}

	public void aloita() throws Exception{
		vs.kalibroi();
		int vari;
		int ajettavaMatka=0;
		while(!Button.ESCAPE.isPressed()){
			vari=vs.mikaVari();
			if (vari == 0){
				System.out.println("Vari: valkoinen");
			} else {
				System.out.println("Vari: tumma");
			}
			ajettavaMatka = navigaattori(vari);
			Thread.sleep(1000);
			kone.liiku(ajettavaMatka);
			vasenMootori.waitComplete();
			if(!kone.liikkuuko()){
				System.out.println(" ");
				tiputtaja.tiputaYksi();
			}
		}	
	}	

	public int navigaattori(int vari){
		int kohde = vari*MATKA;
		if (sijainti == kohde) {
			return 0;
		} else if (sijainti > kohde){
			sijainti = 0;
			return -MATKA;
		} else if (sijainti < kohde){
			sijainti =kohde;
		}  
		return kohde;
	}
}










