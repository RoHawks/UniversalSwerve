// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import universalSwerve.SwerveDrive;
import universalSwerve.SwerveFactory;
import universalSwerve.components.WheelLabel;
import universalSwerve.components.implementations.WheelMode;
import universalSwerve.controls.ISwerveControls;
import universalSwerve.controls.JoystickSwerveControls;
import universalSwerve.hardware.implementations.LampreyWheelAngleReader;
import universalSwerve.utilities.AngleUtilities;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

   private XboxController mMainController;
   private ISwerveControls mSwerveControls;
   private SwerveDrive mSwerveDrive;
   private Compressor mCompressor;
   private DoubleSolenoid mS1 = new DoubleSolenoid(40, PneumaticsModuleType.CTREPCM, 0, 1);
   private DoubleSolenoid mS2 = new DoubleSolenoid(40, PneumaticsModuleType.CTREPCM, 2, 3);
   private DoubleSolenoid mS3 = new DoubleSolenoid(40, PneumaticsModuleType.CTREPCM, 4, 5);
   private DoubleSolenoid mS4 = new DoubleSolenoid(40, PneumaticsModuleType.CTREPCM, 6, 7);
/* 
   private TalonSRX mNE = new TalonSRX(10);
   private TalonSRX mSE = new TalonSRX(1);
   private TalonSRX mSW = new TalonSRX(2);
   private TalonSRX mNW = new TalonSRX(3);
*/
     

  @Override
  public void robotInit() 
  {
    mMainController = new XboxController(0);
    mSwerveControls = new JoystickSwerveControls(mMainController);
    mCompressor = new Compressor(40, PneumaticsModuleType.CTREPCM );
    mCompressor.enableDigital();


    
    mSwerveDrive = SwerveFactory.CreateDedicatedTestChassisSwerve();
    mSwerveDrive.EnableDiagnostics();
    mSwerveDrive.SetWheelMode(WheelLabel.NE, WheelMode.Enabled);
    mSwerveDrive.SetWheelMode(WheelLabel.SE, WheelMode.Enabled);
    mSwerveDrive.SetWheelMode(WheelLabel.SW, WheelMode.Enabled);
    mSwerveDrive.SetWheelMode(WheelLabel.NW, WheelMode.Enabled);
    mSwerveDrive.EnableDiagnostics(WheelLabel.NE);
    mSwerveDrive.EnableDiagnostics(WheelLabel.SE);
    mSwerveDrive.EnableDiagnostics(WheelLabel.SW);
    mSwerveDrive.EnableDiagnostics(WheelLabel.NW);
    

    
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() 
  {
    mS1.set(mMainController.getRightBumper() ? Value.kForward : Value.kReverse);
    mS2.set(mMainController.getRightBumper() ? Value.kForward : Value.kReverse);
    mS3.set(mMainController.getRightBumper() ? Value.kForward : Value.kReverse);
    mS4.set(mMainController.getRightBumper() ? Value.kForward : Value.kReverse);
    
    //mSwerveDrive.Run(mSwerveControls);
    //mSwerveDrive.LogDiagnostics();
    
    /* 
    SmartDashboard.putNumber("NE", mNE.getSelectedSensorPosition());
    SmartDashboard.putNumber("SE", mSE.getSelectedSensorPosition());
    SmartDashboard.putNumber("SW", mSW.getSelectedSensorPosition());
    SmartDashboard.putNumber("NW", mNW.getSelectedSensorPosition());
*/
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
