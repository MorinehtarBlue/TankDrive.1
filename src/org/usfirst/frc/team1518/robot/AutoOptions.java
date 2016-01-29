package org.usfirst.frc.team1518.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class AutoOptions {


	public AutoOptions() {

	}
	
	public static void autoOption1(RobotDrive robo1) {
		/* Timed motion in place of distance.
		 * Will need to look at using the encoders here.
		 * Could also use distance sensor to measure movement.
		 */
        robo1.tankDrive(.5, .5);
        Timer.delay(.5);  
        robo1.tankDrive(-.5, .5);
        Timer.delay(1.5);
        

	}
	
}
