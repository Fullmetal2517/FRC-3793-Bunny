package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Warren Funk
 */
public enum RobotMap {
	// DRIVE MOTORS
	TALON_LEFT(6), 
	TALON_RIGHT(4), 
	VICTOR_LEFT(7), 
	VICTOR_RIGHT(5),
	SHOOTY_BOI(3), //Odds are Victors Evens are Talons 
	STIRRY_BOI(1),
	INTAKE_BOI(2),
	LAUNCHER(0);

	private int pinNum;

	RobotMap(int num) {
		pinNum = num;
	}

	public int getPin() {
		return pinNum;
	}
}
