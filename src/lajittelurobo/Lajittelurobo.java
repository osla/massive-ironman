package lajittelurobo;

import lejos.nxt.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Lajittelurobo {

	public static void main(String[] args) throws Exception {

		Button.waitForPress();		
		LightSensor ls = new LightSensor(SensorPort.S2);
		LCD.drawString("Valoa %: ", 0, 0);
		LCD.drawString("Paina VASEN", 0, 2);
		LCD.drawString("aloittaaksesi", 0, 3);
		LCD.drawString("lajittelun.", 0, 4);
		while (! Button.LEFT.isPressed()){
			LCD.drawInt(ls.readValue(), 3, 9, 0);
		}
		LCD.drawString("Paina ESCAPE", 0, 6);
		LCD.drawString("lopettaaksesi", 0, 7);
		int i = 0;
		while (! Button.ESCAPE.isDown()){
			while (i < 5){
				tiputaYksi();
				i++;
			};
		}
		Button.waitForPress(10000);	
	}

	public static boolean tiputaYksi() throws Exception {
		Motor.C.setSpeed(100);
		Motor.C.backward();
		Thread.sleep(345);//pienen legon pituus = 345ms , pitkän pituus xxx
		Motor.C.stop();
		Thread.sleep(3000);
		return true;
	}
}

