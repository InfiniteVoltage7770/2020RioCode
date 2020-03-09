package frc.robot.intake;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

//import com.ctre.phoenix.motorcontrol.DemandType;

public class IntakeSubsystem extends Subsystem {

  public static final VictorSPX intakePositionL = new VictorSPX(Constants.intakePositionLeft);
  public static final VictorSPX intakePositionR = new VictorSPX(Constants.intakePositionRight);
  public static final VictorSPX intake = new VictorSPX(Constants.intake);

  public IntakeSubsystem() {
    intakePositionL.setInverted(true);
    intakePositionL.follow(intakePositionR);
    //climbL.follow(climbR);
    intakePositionL.setNeutralMode(NeutralMode.Brake);
    intakePositionR.setNeutralMode(NeutralMode.Brake);
  }

  /*
  This function moves the intake arm up and down, there is a deadband
  so that small motion doesnt effect it, and a revearse to that in case
  we want to exellerate the arm faster, the if and else if statments on
  lines 32, 33, 38, & 39 are unessesary since they only control the speed
  increase and not the base speed.
  */ 
  
  void position(double intakePosition){
   if (intakePosition>=(1-Constants.intakePositionDeadband)){ 
      intakePositionR.set(ControlMode.PercentOutput, -(Constants.IntakeSpeed*2));
    } else if (intakePosition>Constants.intakePositionDeadband){
      intakePositionR.set(ControlMode.PercentOutput, -Constants.IntakeSpeed);
    } else if (intakePosition<=-(1-Constants.intakePositionDeadband)){ 
      intakePositionR.set(ControlMode.PercentOutput, (Constants.IntakeSpeed*2));
    } else if (intakePosition<-Constants.intakePositionDeadband){
      intakePositionR.set(ControlMode.PercentOutput, Constants.IntakeSpeed);
    }
    if ((intakePosition<Constants.intakePositionDeadband)&&(intakePosition>-Constants.intakePositionDeadband)){
      intakePositionR.set(ControlMode.PercentOutput, 0);
    }
  }

/*
 This function checks to see if the button assighned to activate the
 intake is being pressed, and if it is it will set the speed to a 
 constant.
*/ 
  void intake(boolean intakeActive,boolean intakeReverse){
    if (intakeActive){
      intake.set(ControlMode.PercentOutput, -0.5);
    } else if (intakeReverse){
        intake.set(ControlMode.PercentOutput, 0.5);
    } else {
      intake.set(ControlMode.PercentOutput, 0);
    }
  }

  @Override
  public void periodic() {
    }

  @Override
  protected void initDefaultCommand() {
    this.setDefaultCommand (new IntakeCommand());

    }
}