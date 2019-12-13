package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Similar to {@link Motors}, this class stores all of the sensors to make them
 * easier to find.
 * 
 * @author Warren Funk
 *
 */
public class Sensors {
	public static Encoder encoder;
	public static AHRS navX;
	public static void initialize() {
		navX = new AHRS(SPI.Port.kMXP);
		encoder = new Encoder(1,2);
		//encoder.setDistancePerPulse(1d/8192d);
	}
}