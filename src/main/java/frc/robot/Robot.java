/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  public WPI_TalonFX rightMain;
  public WPI_TalonFX rightFollow;
  public WPI_TalonFX leftMain;
  public WPI_TalonFX leftFollow;

  public SpeedControllerGroup leftMotors;
  public SpeedControllerGroup rightMotors;
  public DifferentialDrive twoMotorDrive;

  public Joystick leftStick;
  public Joystick rightStick;


  @Override
  public void robotInit() {
    leftMain = new WPI_TalonFX(1);
    leftFollow = new WPI_TalonFX(2);
    rightMain = new WPI_TalonFX(3);
    rightFollow = new WPI_TalonFX(4);

    leftMotors = new SpeedControllerGroup(leftMain, leftFollow);
    rightMotors = new SpeedControllerGroup(rightMain, rightFollow);

    twoMotorDrive = new DifferentialDrive(leftMotors, rightMotors);

    leftStick = new Joystick(0);
    rightStick = new Joystick(1);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    twoMotorDrive.tankDrive(leftStick.getY(), rightStick.getY());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
