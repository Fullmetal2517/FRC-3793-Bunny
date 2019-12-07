package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Ultrasonic;
import util.*;

/**
 * Similar to {@link Motors}, this class stores all of the sensors to make them
 * easier to find.
 * 
 * @author Warren Funk
 *
 */
public class Sensors {
	public static AHRS navX;
	public static void initialize() {
		navX = new AHRS(SPI.Port.kMXP);
	}
}