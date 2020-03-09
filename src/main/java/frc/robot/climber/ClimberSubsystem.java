package frc.robot.climber;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class ClimberSubsystem extends Subsystem {
  public static final CANSparkMax climbL = new CANSparkMax(Constants.climberL, CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax climbR = new CANSparkMax(Constants.climberR, CANSparkMax.MotorType.kBrushless);

  public ClimberSubsystem() {
    climbL.follow(climbR);
  }

  /*
  This function determines if the triggers are active, with priority on the left trigger
  if the triggers are active it will set its speed to its constant if not the motors wont
  move
  */
  
  void climber(boolean activateBumperLeft, boolean activateBumperRight) {
    if (activateBumperLeft){
        climbR.set(Constants.climberSpeed);
    } else if (activateBumperRight){
        climbR.set(-Constants.climberSpeed);
    } else if ((!activateBumperRight)&&(!activateBumperLeft)){
        climbR.set(0);
    }
  }
  

  @Override
  public void periodic() {
    }

  @Override
  protected void initDefaultCommand() {
    this.setDefaultCommand (new ClimberCommand());

    }
  
  /*
  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new climberCommand());

  }
  */
}