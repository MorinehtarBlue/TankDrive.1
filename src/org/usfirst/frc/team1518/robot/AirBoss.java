package org.usfirst.frc.team1518.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class AirBoss extends Robot {
	
	// Compressor cmp1,cmp2;
	// Solenoid onePos1;
	// DoubleSolenoid twoPos1;
	
	public AirBoss() {
		
	}
	public static void AirBossInit(Compressor cmp1) {
		if (!cmp1.getClosedLoopControl()) {
		cmp1.setClosedLoopControl(true);
		}
	}
	public static void AirBossOn(Compressor cmp1) {
		cmp1.setClosedLoopControl(true);
	}
	public static void AirBossOff(Compressor cmp1) {
		cmp1.setClosedLoopControl(false);
	}
	public static void singleSolenoidOpen(Solenoid onePos1){
		onePos1.set(true);
	}
	public static void singleSolenoidExhaust(Solenoid onePos1){
		onePos1.set(false);
	}
	public static void dblSolOut(DoubleSolenoid twoPos1){
		twoPos1.set(DoubleSolenoid.Value.kForward);
	}
	public static void dblSolIn(DoubleSolenoid twoPos1){
		twoPos1.set(DoubleSolenoid.Value.kReverse);
	}
	public static void dblSolHold(DoubleSolenoid twoPos1){
		twoPos1.set(DoubleSolenoid.Value.kOff);
	}
}
