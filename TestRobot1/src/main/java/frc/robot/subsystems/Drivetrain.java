// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain extends SubsystemBase {

  // Set up motor controller groups:
  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(
    new CANSparkMax(DrivetrainConstants.leftMotor1ID, MotorType.kBrushed),
    new CANSparkMax(DrivetrainConstants.leftMotor2ID, MotorType.kBrushed),
    new CANSparkMax(DrivetrainConstants.leftMotor3ID, MotorType.kBrushed)
  );
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(
    new CANSparkMax(DrivetrainConstants.rightMotor1ID, MotorType.kBrushed),
    new CANSparkMax(DrivetrainConstants.rightMotor2ID, MotorType.kBrushed),
    new CANSparkMax(DrivetrainConstants.rightMotor3ID, MotorType.kBrushed)
  );

  // Set up differential drive:
  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  public Drivetrain() {
    // Invert right motors:
    m_rightMotors.setInverted(true);
  }

  // The actual drive method
  public void drive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed * DrivetrainConstants.speedMultiplier, rightSpeed * DrivetrainConstants.speedMultiplier);
  }
}
