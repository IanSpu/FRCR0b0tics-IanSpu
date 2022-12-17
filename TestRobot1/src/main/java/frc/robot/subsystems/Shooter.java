// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  private final TalonSRX m_shootMotor1 = new TalonSRX(ShooterConstants.motorNum1);
  private final TalonSRX m_shootMotor2 = new TalonSRX(ShooterConstants.motorNum2);

  public Shooter() {
    m_shootMotor2.setInverted(true);
  }

  public void Start(double motorSpeed) {
    m_shootMotor1.set(TalonSRXControlMode.Velocity, motorSpeed);
    m_shootMotor2.set(TalonSRXControlMode.Velocity, motorSpeed);
  }

  public void Stop() {
    m_shootMotor1.set(TalonSRXControlMode.Velocity, 0);
    m_shootMotor2.set(TalonSRXControlMode.Velocity, 0);
  }
}
