/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Servo;

/*/
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

// DigitalInput switchInput = new DigitalInput(0);

public class Robot extends TimedRobot {
  static GenericHID driverController = new XboxController(0);
  static GenericHID operatorController = new XboxController(1);
  public static GenericHID[] controllers = new GenericHID[2];
  private static boolean singleControllerMode = false;
  public static int controllerSelector = 0;
  private static GenericHID Master = null;

  public static final int DRIVER = 0;
  public static final int OPERATOR = 1;

  public boolean shooting = false;

  public int shootingStartTime = 0;
  public int shootTimer = 0;

  public boolean setOnce = false;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    controllers[DRIVER] = driverController;
    controllers[OPERATOR] = operatorController;

    try {
      Motors.initialize();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Sensors.initialize();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    try {
      driveControl();
      shooterControl();
      intakeControl();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }

  private void driveControl() {
    double dif;
    double leftY = controllers[DRIVER].getRawAxis(ControllerMap.leftTrigger)
        - controllers[DRIVER].getRawAxis(ControllerMap.rightTrigger);

    if (Math.abs(leftY) < Settings.BUMPER_DEADZONE)
      dif = 0.0;
    else {
      dif = (leftY / Math.abs(leftY)) * (.4 + (Math.abs(leftY) * .6));
    }
    double lx = controllers[DRIVER].getRawAxis(ControllerMap.leftX);
    double lNum;
    if (Math.abs(lx) > Settings.LSTICK_DEADZONE)
      lNum = controllers[DRIVER].getRawAxis(ControllerMap.leftX);
    else
      lNum = 0;
    if (lNum == 0 && dif == 0)
      Motors.drive.arcadeDrive(0, 0);
    else {
      if (controllers[DRIVER].getRawButton(ControllerMap.A))
        Motors.drive.arcadeDrive(-dif * Settings.SPEED_MULT, lNum);
      else if (controllers[DRIVER].getRawButton(ControllerMap.B)) { // Sicko mode button
        Motors.talonLeft.enableCurrentLimit(false);
        Motors.talonRight.enableCurrentLimit(false);
        Motors.drive.arcadeDrive(-dif * Settings.SPEED_MULT, lNum * Settings.TURN_MULT);
      } else {
        Motors.talonLeft.enableCurrentLimit((true));
        Motors.talonRight.enableCurrentLimit((true));
        Motors.drive.arcadeDrive(-dif * Settings.SPEED_MULT, lNum * Settings.TURN_MULT);
      }
    }
  }

  public void shooterControl() {
    if (controllers[OPERATOR].getRawButton(ControllerMap.A)) {
      if (!setOnce) {
        shootingStartTime = (int) System.currentTimeMillis();
        setOnce = true;
      }

      Motors.shootyBoi.set(1);
      if ((System.currentTimeMillis() - shootingStartTime) > 2000) {
        Motors.stirryBoi.set(1);
      }
    } else {
      setOnce = false;
    }
  }

  public void intakeControl() {
    if (controllers[OPERATOR].getRawButton(ControllerMap.B)) {
      Motors.intakeBoi.set(0);
    } else {
      Motors.intakeBoi.set(1);
    }
  }

}