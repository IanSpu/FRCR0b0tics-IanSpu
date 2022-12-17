// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterCommandType;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants.ShooterConstants;

public class DefaultShoot extends CommandBase {
  private final Shooter m_shooter;
  private final ShooterCommandType m_commandType;

  public DefaultShoot(Shooter shooter, ShooterCommandType commandType) {
    m_shooter = shooter;
    m_commandType = commandType;
    addRequirements(m_shooter);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_commandType == ShooterCommandType.Low) m_shooter.Start(ShooterConstants.lowMotorSpeed);
    else m_shooter.Start(ShooterConstants.highMotorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.Stop();
  }
}
