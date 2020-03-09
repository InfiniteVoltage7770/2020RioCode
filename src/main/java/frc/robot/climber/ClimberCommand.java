package frc.robot.climber;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ClimberCommand extends Command {
    public ClimberCommand() {
        requires(Robot.climber);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        boolean ActivateBumperLeft = Robot.xbox.getBumper(Hand.kLeft);
        boolean ActivateBumperRight = Robot.xbox.getBumper(Hand.kRight);
        Robot.climber.climber(ActivateBumperLeft, ActivateBumperRight);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}
