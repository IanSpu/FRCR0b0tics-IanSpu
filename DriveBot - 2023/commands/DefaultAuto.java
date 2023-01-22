// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class DefaultAuto extends SequentialCommandGroup {
  private final Drivetrain m_drivetrain;
  public DefaultAuto(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addCommands(
      new DefaultDrive(m_drivetrain, () -> 0.2, () -> 0.2).withTimeout(2)
    );
  }
}
