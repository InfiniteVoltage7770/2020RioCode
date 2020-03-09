/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
//import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import java.lang.Math;
//import com.revrobotics.ControlType;
//import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;

public class DriveSubsystem extends Subsystem 
{
  private static final CANSparkMax leftMaster = new CANSparkMax(Constants.kLeftMasterId,
      CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax leftSlave = new CANSparkMax(Constants.kLeftSlaveId,
      CANSparkMax.MotorType.kBrushless);
      SpeedControllerGroup m_left = new SpeedControllerGroup(leftMaster, leftSlave);
  private static final CANSparkMax rightMaster = new CANSparkMax(Constants.kRightMasterId,
      CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax rightSlave = new CANSparkMax(Constants.KRightSlaveId,
      CANSparkMax.MotorType.kBrushless);
      SpeedControllerGroup m_right = new SpeedControllerGroup(rightMaster, rightSlave);
  private DifferentialDrive drive = new DifferentialDrive(m_left, m_right); 

  public DriveSubsystem() 
  {
    m_left.setInverted(true);
  }

  public void drive(double speed, double rotate) {
    double DDband = 0;
    if (Math.abs(speed)<Constants.DriveDeadband && Math.abs(rotate)<Constants.DriveDeadband)
    {
      speed = DDband;
      drive.arcadeDrive(speed, rotate);
    } 
    else if (Math.abs(speed)<Constants.DriveDeadband || Math.abs(rotate)<Constants.DriveDeadband)
    {    
     if (Math.abs(speed)<Constants.DriveDeadband) 
      {
       speed = DDband;
       drive.arcadeDrive(speed, rotate);
      }
       else {drive.arcadeDrive(speed, rotate);}
       if (Math.abs(rotate)<Constants.DriveDeadband) 
      {
        rotate = DDband; 
        drive.arcadeDrive(speed, rotate);
      } 
        else {drive.arcadeDrive(speed, rotate);}
    } else {drive.arcadeDrive(speed, rotate);}
  }
  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}