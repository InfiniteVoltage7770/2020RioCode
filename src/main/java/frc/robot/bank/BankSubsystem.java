
package frc.robot.bank;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class BankSubsystem extends Subsystem {
  public static final CANSparkMax bankT = new CANSparkMax(Constants.bankTId,
  CANSparkMax.MotorType.kBrushless);
  private static final CANSparkMax bankB = new CANSparkMax(Constants.bankBId,
  CANSparkMax.MotorType.kBrushless);
 
  public BankSubsystem() {
   bankT.follow(bankB);
  }

  void Bank(double RollForward, double RollBackward){
      if (RollForward!=0){
        bankB.set(Constants.BankSpeed);
    } else if (RollBackward!=0){
      bankB.set(-Constants.BankSpeed);
    } else if ((RollBackward==0)&&(RollForward==0)){
      bankB.set(0);
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
    this.setDefaultCommand(new BankCommand());

  }

}

