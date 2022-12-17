// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.PneumaticsCommandType;
import frc.robot.Constants.ShooterCommandType;
import frc.robot.commands.DefaultAuto;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DefaultShoot;
import frc.robot.commands.PneumaticCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.PneumaticArm;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  
  // Creating the subsystem object(s):
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final PneumaticArm m_pneuArm = new PneumaticArm();
  private final Shooter m_shooter = new Shooter();

  // Creating the controller object(s):
  XboxController m_driverController = new XboxController(Constants.InputConstants.driverPort);

  public RobotContainer() {
    // Set up button bindings:
    configureButtonBindings();

    /**
      * Set up the default command for the drivetrain subsystem, which means that if nothing else
      * is using the subsystem, the default command will be automatically scheduled. 
      * 
      * "m_drivercontroller::getLeftY" is a double supplier because the method "getLeftY" of the
      * XboxController class returns a double. "::" is the way to show that you want to use a method
      * for a class. Alternatively, you can use "() -> m_driverController.getLeftY" (lambda notation)
    */
    m_drivetrain.setDefaultCommand(new DefaultDrive(m_drivetrain, m_driverController::getLeftY, m_driverController::getRightY));
  }

  public void configureButtonBindings() {
    // Pneumatic buttons:
    new JoystickButton(m_driverController, XboxController.Button.kRightStick.value)
      .toggleWhenPressed(new PneumaticCommand(m_pneuArm, PneumaticsCommandType.Up), true);
    new JoystickButton(m_driverController, XboxController.Button.kLeftStick.value)
      .toggleWhenPressed(new PneumaticCommand(m_pneuArm, PneumaticsCommandType.Down), true);
    new JoystickButton(m_driverController, XboxController.Button.kX.value)
      .toggleWhenPressed(new PneumaticCommand(m_pneuArm, PneumaticsCommandType.Maintain), true);

    // Shooter buttons:
    new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value)
      .whileHeld(new DefaultShoot(m_shooter, ShooterCommandType.Low));
    new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value)
      .whileHeld(new DefaultShoot(m_shooter, ShooterCommandType.High));
  }

  public Command getAutonomousCommand() {
    return new DefaultAuto();
  }
}
