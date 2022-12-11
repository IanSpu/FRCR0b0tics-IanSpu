// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

    // Constants for input stuff
    public class InputConstants {
        public final static int driverPort = 0; // Which port is being used for the driver controller
    }

    //Constants for the drivetrain
    public class DrivetrainConstants {
        public final static float speedMultiplier = 0.05f; // Limit the motor speed

        // Drive motor IDs:
        public final static int leftMotor1ID = 0;
        public final static int leftMotor2ID = 1;
        public final static int leftMotor3ID = 2;
        public final static int rightMotor1ID = 3;
        public final static int rightMotor2ID = 4;
        public final static int rightMotor3ID = 5;
    }
}
