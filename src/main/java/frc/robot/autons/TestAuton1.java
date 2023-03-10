// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmAngle;
import frc.robot.subsystems.ArmLateral;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TestAuton1 extends SequentialCommandGroup {
  private Drivetrain drivetrain;
  private ArmAngle armAngle;
  private ArmLateral armLateral;
  private Intake intake;
  /** Creates a new TestAuton1. */
  public TestAuton1(Drivetrain drivetrain, Intake intake, ArmAngle armAngle, ArmLateral armLateral) {
    this.armAngle = armAngle;
    this.armLateral = armLateral;
    this.intake = intake;
    this.drivetrain = drivetrain;
    //addRequirements(drivetrain, intake, armAngle, armLateral);
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(() -> drivetrain.drive(0.2, 0, 0, true, true)),
      new SetArmAngle(armAngle, Constants.ArmConstants.PositionConfig.midConeAngle),
      new OpenClaw(intake),
      new ReleaseGP(intake)
    );
  }
}
