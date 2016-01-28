package org.usfirst.frc.team1518.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class AutoOptions {

//    RobotDrive myRobot;  // class that handles basic drive operations
//    Compressor cmp1;
//    
//    TalonSRX rearLeft, rearRight, thrower, picker;
//    Solenoid sol1, sol2;

	public AutoOptions() {
//	    rearLeft = new TalonSRX(0); // Left hand driving motor
//	    rearRight = new TalonSRX(1); // Right hand drive motor
//	    myRobot = new RobotDrive(rearLeft, rearRight); //PWM0=LEFT | PWM1=RIGHT
//	    myRobot.setExpiration(0.1);
//	    myRobot.setMaxOutput(.75);
//	    cmp1 = new Compressor(0);
//	    cmp1.setClosedLoopControl(false);
//        picker = new TalonSRX(2);
//        thrower = new TalonSRX(3);
//        sol1 = new Solenoid(0);

	}
	
	public static void autoOption1(RobotDrive robo1) {

        robo1.tankDrive(.5, .5);
        Timer.delay(.5);
        robo1.tankDrive(-.5, .5);
        Timer.delay(1.5);
        
//        robo1.tankDrive(.5, .5);
//        Timer.delay(.5);
//        robo1.tankDrive(0, 0);

	}
	
}
