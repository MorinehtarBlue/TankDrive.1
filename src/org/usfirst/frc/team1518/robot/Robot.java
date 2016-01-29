package org.usfirst.frc.team1518.robot;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.TalonSRX;

/*  This is a test frame for the 2016 FRC - PalMac RaiderBots 1518
 *  
*/

public class Robot extends IterativeRobot {
    RobotDrive myRobot;  // class that handles basic drive operations

    Joystick leftStick = new Joystick(1);  // set to ID 1 in DriverStation
    Button leftTrigger = new JoystickButton(leftStick, 1);

    Joystick rightStick = new Joystick(0); // set to ID 2 in DriverStation
    Button rightTrigger = new JoystickButton(rightStick, 1);
   
    Compressor cmp1;
    
    TalonSRX rearLeft, rearRight, thrower, picker;
    Solenoid sol1, sol2;

    int session;
    
    Command grabBall;
    Command shootBall;
    Command reverseDrive;
    
    private int mode = 1; // initialize default mode
    private SendableChooser autoChoice;

    
    public void robotInit() {

        autoChoice = new SendableChooser();
        autoChoice.addDefault("Auto OFF", 0);
        autoChoice.addObject("Auto Mode 1", 1);
        autoChoice.addObject("Auto Mode 2", 2);
        autoChoice.addObject("Auto Mode 3", 3);
        SmartDashboard.putData("Autonomous Selector", autoChoice);

    }

    
    public Robot() {
        rearLeft = new TalonSRX(3); // Left hand driving motor
        rearRight = new TalonSRX(4); // Right hand drive motor
        myRobot = new RobotDrive(rearLeft, rearRight); 
        
        myRobot.setExpiration(0.1);
        myRobot.setMaxOutput(.75);
        cmp1 = new Compressor(0);
        cmp1.setClosedLoopControl(false);        

        picker = new TalonSRX(0);
        //frontLeft.disable();
        thrower = new TalonSRX(8);
        //frontRight.disable();
        sol1 = new Solenoid(0);
        
    }

    /** Autonomous operations
     * 
     */
    public void autonomousInit() {
        mode = (int) autoChoice.getSelected();

    }
    public void autonomousPeriodic() {
        myRobot.setSafetyEnabled(true);
        // myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        // myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

    	while (isAutonomous() && isEnabled()){
    		switch (mode){
    		case 0: {
    			Timer.delay(15);
    		}
    		case 1: {
    			AutoOptions.autoOption1(myRobot);
    		}
    		case 2: {
    			// need to add call for 2nd option
    		}
    		case 3: {
    			// need to add call for 3rd option
    		}
    		}
    		
    	}
    }
    /**
     * TeleOp setup in Tank Mode
     */
    public void operatorControlInit() {
    	
    }
    
    public void operatorControlPeriodic() {
        myRobot.setSafetyEnabled(true);
        myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	AirBoss.AirBossInit(cmp1);
    	
        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(leftStick, rightStick);
            
            //look for trigger pull
            while (leftTrigger.get()) {
            	// picker.set(-0.5); // Commented out to test solenoid
            }
            picker.set(0.0);
            while (rightTrigger.get()){
            	// thrower.set(1.0); // Commented out to test solenoid
            	sol1.set(true);
            }
            sol1.set(false);
            thrower.set(0.0);
            // rightTrigger.whenPressed();
            Timer.delay(0.005);		// wait for a motor update time
        }
    }
}
