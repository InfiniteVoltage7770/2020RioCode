/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.shooter;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
//import frc.robot.Robot;
//import frc.robot.bank.BankSubsystem;

public class ShooterSubsystem extends Subsystem {
  public static final CANSparkMax ShotMaster = new CANSparkMax(Constants.ShotMasterId,
      CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax ShotSlave = new CANSparkMax(Constants.ShotSlaveId, CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax Elevate = new CANSparkMax(Constants.ShotElevationId, CANSparkMax.MotorType.kBrushed);
 // private final Timer ShotDelay = new Timer();

  public ShooterSubsystem() {
    ShotSlave.follow(ShotMaster, true);
  }

void Shooter(Boolean Shoot,Boolean reverse, Double Elevation) {
  double DDband = 0;
 /* if (Math.abs(Elevation)<.01)
  {
    Elevation = DDband;
    Elevate.set(Elevation);
  } else {Elevate.set(Elevation);} */
  Elevate.set(Elevation);
  
  if(Shoot){
  ShotMaster.set(Constants.ShotSpeed);
  } else if (reverse){
    ShotMaster.set(-(Constants.ShotSpeed/5));
  } else {ShotMaster.set(0);}
}

@Override
public void periodic() {
}

@Override
protected void initDefaultCommand() {
  this.setDefaultCommand(new ShootCommand());
  
}

}
