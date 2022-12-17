// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.PneumaticsCommandType;
import frc.robot.subsystems.PneumaticArm;

public class PneumaticCommand extends CommandBase {
  private final PneumaticsCommandType m_commandType;
  private final PneumaticArm m_armSub;
  public PneumaticCommand(PneumaticArm armSub, PneumaticsCommandType commandType) {
    m_commandType = commandType;
    m_armSub = armSub;
    addRequirements(m_armSub);
  }

  @Override
  public void execute() {
    if (m_commandType == PneumaticsCommandType.Up) m_armSub.armUp();
    else if (m_commandType == PneumaticsCommandType.Down) m_armSub.armDown();
    else m_armSub.armMaintain();
  }
}