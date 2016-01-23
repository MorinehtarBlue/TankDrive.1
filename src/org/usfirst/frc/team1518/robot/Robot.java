package org.usfirst.frc.team1518.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.TalonSRX;

/*  This is a test frame for the 2016 FRC - PalMac RaiderBots 1518
 *  
*/

public class Robot extends SampleRobot {
    RobotDrive myRobot;  // class that handles basic drive operations

    Joystick leftStick = new Joystick(1);  // set to ID 1 in DriverStation
    Button leftTrigger = new JoystickButton(leftStick, 1);

    Joystick rightStick = new Joystick(0); // set to ID 2 in DriverStation
    Button rightTrigger = new JoystickButton(rightStick, 1);
   
    Compressor cmp1;
    
    TalonSRX rearLeft, rearRight, thrower, picker;
    
    int session;
    Image frame;
    AxisCamera camera;
    
    Command grabBall;
    Command shootBall;
    
    
    public void robotInit() {

        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // open the camera at the IP address assigned. This is the IP address that the camera
        // can be accessed through the web interface.
        camera = new AxisCamera("10.15.18.100");
    }

    
    public Robot() {
        rearLeft = new TalonSRX(0); // Left hand driving motor
        rearRight = new TalonSRX(1); // Right hand drive motor
        myRobot = new RobotDrive(rearLeft, rearRight); //PWM0=LEFT | PWM1=RIGHT
        myRobot.setExpiration(0.1);
        myRobot.setMaxOutput(.75);
        cmp1 = new Compressor(0);
        cmp1.setClosedLoopControl(true);
        
        // rearLeft.setBounds(0.75, 0.1, 0, -0.1, -0.75); // need to find updated call
        // rearRight.setBounds(0.75, 0.1, 0, -0.1, -0.75); // need to find updated call
        // Will likely need to make adjustment in Joystick instead of PWM's
        

        picker = new TalonSRX(2);
        //frontLeft.disable();
        thrower = new TalonSRX(3);
        //frontRight.disable();
        
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

        NIVision.Rect rect = new NIVision.Rect(270, 190, 100, 100);

        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(leftStick, rightStick);
            camera.getImage(frame);
            //NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

            CameraServer.getInstance().setImage(frame);
            
            //look for trigger pull
            while (leftTrigger.get()) {
            	picker.set(-0.5);
            }
            picker.set(0.0);
            while (rightTrigger.get()){
            	thrower.set(1.0);
            }
            thrower.set(0.0);
            Timer.delay(0.005);		// wait for a motor update time
        }
    }
}
