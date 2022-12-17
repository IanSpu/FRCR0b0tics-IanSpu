// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticArm extends SubsystemBase {
  
  private final DoubleSolenoid m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);

  public void armUp() {
    m_solenoid.set(Value.kForward);
  }
  public void armDown() {
    m_solenoid.set(Value.kReverse);
  }
  public void armMaintain() {
    m_solenoid.set(Value.kOff);
  }
}
