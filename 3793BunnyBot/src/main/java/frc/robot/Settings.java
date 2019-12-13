package frc.robot;

/**
 * Basic settings for the robot. {@code public static final objects} ONLY.
 * Hopefully this reduces magic numbers.
 * @author Warren Funk
 *
 */
public interface Settings {
	public static final double kP = .025;
	public static final double kI = 0.003;
	public static final double kD = 0.25;
	public static final double kF = 0.2;
	public static final double SPEED_MULT = 1.0;
	public static final double TURN_MULT = 0.7;
	public static final float LSTICK_DEADZONE = 0.2f;
	public static final float BUMPER_DEADZONE = 0.02f;
	public static final int TIMER_DELAY = 15;
	public static final int TIMER_LANDING_GEAR_DELAY = 5;
	public static final int OSCILLATION_TIME = 10;
	public static final float INCHES_TO_METERS = .0254f;
	public static final float BLUE = .87f;
	public static final float RED = .61f;
	public static final float YELLOW = .69f; //nice
	public static final float GREEN = .77f;
	public static final float WHITE = .93f;
	public static final float PURPLE = .91f;
	public static final float HOT_PINK = .57f;
	public static final float WAVE_FOREST = -.37f;
	public static final float LIME = .73f;
	public static final float LARSON = -.35f;
	public static final float PARTY = -.43f;
	public static final float SINELON = -0.77f;
	public static final float CONFETTI = -0.87f;
	public static final float BLACK = .99f;
	public static final float PIVOT_SPEED = 0.6f;
	public static final float TARGET_MIN_VOLT = 8.5f;
	public static final int LIDAR_CONFIG_REGISTER = 0; 
	public static final int DISTNCE_REGISTER = 143;
	public static final int LIDAR_AVOCADO_DISTANCE = 6;
}
