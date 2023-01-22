// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/** Why a command?
 * Well, commands can be useful for many reasons.
 * 
 * Commands can be used for running multiple actions across multiple
 * subsystems.
 * 
 * Commands also have awesome built-in features, such as end/finish
 * methods available for telling an action to stop happening,
 * whether it be manual or when a certain condition is met.
 * 
 * More complex commands such as the Sequential/Parallel Command
 * Groups are useful for running multiple commands one after another
 * or at the same time.
 */

public class DefaultDrive extends CommandBase {

  /** Declaring member variables!
   * The 'm_' in the variable name is to quickly remind programmers 
   * that it is a member variable.
   */
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_leftSpeed;
  private final DoubleSupplier m_rightSpeed;

  // In this case, the constructor is mainly used for getting inputs.
  public DefaultDrive(Drivetrain drivetrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    m_drivetrain = drivetrain;
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    // Add requirements just requires subsystem(s) to run the command.
    addRequirements(m_drivetrain);
  }

  // The 'execute' method is called repeatedly while the command is ran.
  @Override
  public void execute() {
    // Tells the drivetrain subsystem to drive using the given values.
    m_drivetrain.drive(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());
  }

  // The 'end' method is called whenever the command stops running.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0d, 0d);
  }
  
}
