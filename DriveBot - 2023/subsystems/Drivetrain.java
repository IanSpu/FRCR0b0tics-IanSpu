// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {

  /** Creates the motor controller groups!
   * We want to use motor controller groups because they are easier
   * to work with than individual motors.
   * 
   * For example, if we want all of the motors on the left side of
   * the robot to turn at the same speed, you only need to tell the
   * 'leftMotors' group to go at that speed instead of telling all 
   * of the motors seperately.
   */
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(
    new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_1_ID, MotorType.kBrushless),
    new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_2_ID, MotorType.kBrushless)
  );
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(
    new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_1_ID, MotorType.kBrushless),
    new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_2_ID, MotorType.kBrushless)
  );

  public Drivetrain() {
    /** Inverts the direction of the motors!
     * We may want to invert the motors for several reasons, but one
     * of the most common is to ensure that the robot moves forward
     * when both motor controller groups are given positive values.
     * 
     * This makes it easier for setting up controller input, as well
     * as creating autonomous commands.
     * 
     * We can decide which motor controller group(s) are inverted by
     * changing the corresponding value in the 'Constants.java' file.
     */
    leftMotors.setInverted(DrivetrainConstants.LEFT_MOTORS_INVERTED);
    rightMotors.setInverted(DrivetrainConstants.RIGHT_MOTORS_INVERTED);
  }

  // Differential Drive! (Handles inputs for the motor controller groups.)
  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

  /** The Drive Method!
   * This is the thing that tells the motor controllers to tell the
   * motors that it's time to go!
   * 
   * In this case we use a tank drive.
   * 
   * This means that giving the 'tankDrive' method two doubles will 
   * tell the left motors to go at a speed of the first double, and
   * the right motors to go at a speed of the second double.
   * 
   * Other differential drive examples include:
   * Arcade Drive,
   * Curvature Drive,
   * Probably Others 
   */
  public void drive(Double leftSpeed, Double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

}
