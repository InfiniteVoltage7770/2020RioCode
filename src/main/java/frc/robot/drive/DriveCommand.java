/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drive;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {
  public DriveCommand() {
    requires(Robot.drive);
  }
  @Override
  protected void execute() {
    double rotate = Robot.xbox.getY(Hand.kLeft);
    double speed = -Robot.xbox.getX(Hand.kRight);

    Robot.drive.drive(speed, rotate);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

