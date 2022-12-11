// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DefaultAuto;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  
  // Initialize the subsystems:
  private final Drivetrain m_drivetrain = new Drivetrain();

  // Set up the controller:
  XboxController m_driverController = new XboxController(Constants.InputConstants.driverPort);

  public RobotContainer() {
    // Set up DefaultDrive command as default to always run so it always looks for inputs to drive with.
    // We use the whole "() -> #" because of double supplier reasons (i think) (why use double supplier?) (it's dumb)
    m_drivetrain.setDefaultCommand(new DefaultDrive(m_drivetrain, () -> m_driverController.getLeftY(), () -> m_driverController.getRightY()));
  }

  public Command getAutonomousCommand() {
    return new DefaultAuto();
  }
}
