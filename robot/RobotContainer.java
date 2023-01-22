// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DefaultAuto;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.ContainerConstants;

public class RobotContainer {

  // Declare the objects we are going to use! (dController --> driver)
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final XboxController dController = new XboxController(ContainerConstants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    // Will be ran assuming no other commands are using the subsystem.
    m_drivetrain.setDefaultCommand(
      new DefaultDrive(m_drivetrain, dController::getLeftY, dController::getRightY)
    );
  }

  public Command getAutonomousCommand() {
    return new DefaultAuto(m_drivetrain);
  }
}
