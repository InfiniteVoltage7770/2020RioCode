/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {
  //Motors
    //DriveMoters
  public static final int kLeftMasterId = 3;
  public static final int kLeftSlaveId = 5;
  public static final int kRightMasterId = 4;
  public static final int KRightSlaveId = 6;
    //ShooterMoters
  public static final int ShotMasterId = 16;
  public static final int ShotSlaveId = 2;
  public static final int ShotElevationId = 1;
    //BankMoters
  public static final int bankTId = 7;
  public static final int bankBId = 15;
    //ClimberMoters
  public static final int climberL = 9;
  public static final int climberR = 8;
    //IntakeMoters
  public static final int intake = 18;
  public static final int intakePositionLeft = 19;
  public static final int intakePositionRight = 17;

  //Controllers
  public static final int kXboxControllerPort = 0;
  public static final int sXboxControllerPort = 1;

  //Speeds
  public static final double ShotSpeed = 1; 
  public static final double BankSpeed = -.4;
  public static final double IntakeSpeed = 0.25;
  public static final double climberSpeed = 0.4;

  //Deadbands
  public static final double DriveDeadband = .3;
  public static final double intakePositionDeadband = .05;
}