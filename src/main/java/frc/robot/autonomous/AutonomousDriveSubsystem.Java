package frc.robot.autonomous;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutonomousDriveSubsystem extends Subsystem {
  double RobotsRotationalCurcomfranse = 1.91511488; //This is from the middel to the wheels
  double DistanceFromTarget = 3; //distance off of the line the vehicle will aim for

  public AutonomousDriveSubsystem() {
   
  }

  void AutoDrive(double DistanceFromTargetSideWall){
        DistanceFromTargetSideWall = (DistanceFromTargetSideWall*0.3048)-2.736;//converts feet to meters
        DistanceFromTargetSideWallApsoluteValue = Math.abs(DistanceFromTargetSideWall);
        
        double DistanceRequired = Math.sqrt(Math.pow(DistanceFromTarget, 2)+Math.pow(DistanceFromTargetSideWallApsoluteValue,2));
        NavX.zeroYaw();
        double angle1 = Math.acos(DistanceFromTargetSideWall/DistanceRequired);
        double angle2 = 180-Math.acos(DistanceFromTargetSideWall/DistanceRequired);
        double step = 1;
        
        while ((NavX.getAngle()!=angle1)&&(step==1)){
            if (NavX.getAngle()<angle1){

            } else if (Navx.getAngle()>angle2){

            } 
        }

        step = 2;

    }
  }

  /*
  void Bank(Boolean Roll) {
    if(Roll == true){
        bankB.set(Constants.BankSpeed);
        }
        else{bankB.set(0);}
  }
  */

  @Override
  public void periodic() {
  }

  @Override
  protected void initDefaultCommand() {
    this.setDefaultCommand(new AutonomousCommand());

  }

}
