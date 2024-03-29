package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;

/**
 * A nice list of all the motors on the robot to be referenced in the
 * appropriate place
 * 
 * @author Warren Funk
 *
 */
public class Motors {

	// ----------------------------- Driving Motors -----------------------------

	public static WPI_TalonSRX talonLeft;
	public static WPI_TalonSRX talonRight;
	public static WPI_VictorSPX victorLeft;
	public static WPI_VictorSPX victorRight;
	public static WPI_VictorSPX armEndMotor;
	private static SpeedControllerGroup left;
	private static SpeedControllerGroup right;
	public static DifferentialDrive drive;

	// ------------------------------ Other Motors ------------------------------

	public static WPI_VictorSPX shootyBoi;
	public static WPI_VictorSPX stirryBoi;
	public static WPI_TalonSRX intakeBoi;
	public static Servo launcher;

	/**
	 * initializes all of the motors using the pins as specified in {@link RobotMap}
	 */
	public static void initialize() {
		// ----------------------------- Driving Motors -----------------------------

		talonLeft = new WPI_TalonSRX(RobotMap.TALON_LEFT.getPin());
		talonRight = new WPI_TalonSRX(RobotMap.TALON_RIGHT.getPin());
		talonLeft.configPeakCurrentLimit(0);
		talonRight.configPeakCurrentLimit(0);
		talonLeft.configContinuousCurrentLimit(40);
		talonRight.configContinuousCurrentLimit(40);
		talonLeft.enableCurrentLimit(true);
		talonRight.enableCurrentLimit(true);
		victorLeft = new WPI_VictorSPX(RobotMap.VICTOR_LEFT.getPin());
		victorRight = new WPI_VictorSPX(RobotMap.VICTOR_RIGHT.getPin());
		left = new SpeedControllerGroup(talonLeft, victorLeft);
		right = new SpeedControllerGroup(talonRight, victorRight);
		drive = new DifferentialDrive(left, right);
		drive.setDeadband(0);

		// ------------------------------ Other Motors ------------------------------

		// blinkin = new Spark(RobotMap.BLINKIN.getPin());

		shootyBoi = new WPI_VictorSPX(RobotMap.SHOOTY_BOI.getPin());
		stirryBoi = new WPI_VictorSPX(RobotMap.STIRRY_BOI.getPin());
		intakeBoi = new WPI_TalonSRX(RobotMap.INTAKE_BOI.getPin());
		launcher = new Servo(RobotMap.LAUNCHER.getPin());
	}
}
