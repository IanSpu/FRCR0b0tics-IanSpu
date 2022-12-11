// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DefaultDrive extends CommandBase {
  
  // Inputs we need to drive (subsystem + inputs):
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  
  // Inputs as parameters:
  public DefaultDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
    m_drivetrain = drivetrain;
    m_left = left;
    m_right = right;
    addRequirements(m_drivetrain);
  }

  // Constantly running the drive method from the drivetrain subsystem:
  @Override
  public void execute() {
    m_drivetrain.drive(m_left.getAsDouble(), m_right.getAsDouble());
  }
}
