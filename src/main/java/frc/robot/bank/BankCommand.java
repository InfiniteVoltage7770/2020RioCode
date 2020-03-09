package frc.robot.bank;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BankCommand extends Command {
    public BankCommand() {
        requires(Robot.bank);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double BeltwayForward = Robot.manipulater.getTriggerAxis(Hand.kLeft);
        double BeltwayReverse = Robot.manipulater.getTriggerAxis(Hand.kRight);
        
        //boolean PressX = Robot.xbox.getXButton();

    //Robot.bank.Bank(PressX);
    Robot.bank.Bank(BeltwayForward,BeltwayReverse);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}