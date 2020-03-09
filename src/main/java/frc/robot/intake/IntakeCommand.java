package frc.robot.intake;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class IntakeCommand extends Command {
    public IntakeCommand() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double intakeposition = Robot.manipulater.getY(Hand.kLeft);
        boolean intakeIn = Robot.manipulater.getAButton();
        boolean intakeOut = Robot.manipulater.getBButton();
        Robot.intake.position(intakeposition);
        Robot.intake.intake(intakeIn,intakeOut);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}