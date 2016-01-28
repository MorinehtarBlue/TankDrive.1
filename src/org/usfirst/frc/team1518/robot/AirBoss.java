package org.usfirst.frc.team1518.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class AirBoss extends Robot {
	
	Compressor cmp1,cmp2;
	Solenoid onePos1, onePos2;
	
	public AirBoss(Solenoid onePos1, Solenoid onePos2) {
		
	}
	public static void AirBossInit(Compressor cmp1) {
		cmp1.setClosedLoopControl(true);
		Timer.delay(0.5);
		cmp1.setClosedLoopControl(false);
	}
	public static void AirBossOn(Compressor cmp1) {
		cmp1.setClosedLoopControl(true);
	}
	public static void AirBossOff(Compressor cmp1) {
		cmp1.setClosedLoopControl(false);
	}
}
