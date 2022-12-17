// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

    // Constants for input stuff:
    public class InputConstants {
        // Port # for the driver controller:
        public final static int driverPort = 0;
    }

    //Constants for the drivetrain subsystem:
    public class DrivetrainConstants {
        // Limit the motor speed:
        public final static float speedMultiplier = 0.4f;

        // Drive motor IDs:
        public final static int leftMotor1ID = 0;
        public final static int leftMotor2ID = 1;
        public final static int leftMotor3ID = 2;
        public final static int rightMotor1ID = 3;
        public final static int rightMotor2ID = 4;
        public final static int rightMotor3ID = 5;
    }

    // Constants for pneumatic subsystems:
    public class PneumaticsConstants {
        // Channels for the PCM:
        public final static int forward = 1;
        public final static int reverse = 0;
    }
    // Different commands for controlling a pneumatic arm:
    public enum PneumaticsCommandType {Up, Down, Maintain}
}
