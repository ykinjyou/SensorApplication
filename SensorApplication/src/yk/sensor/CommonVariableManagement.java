package yk.sensor;

/**
 * 定数とかSetGetとか
 * @author Yk
 *
 */
public class CommonVariableManagement {
	/** 加速度センサーモード */
	public final static String ACCELEROMETER_SENSOR_MODE = "accelerometersensormode";
	/** 重力度センサーモード */
	public final static String GRAVITY_SENSOR_MODE = "gravitysensormode";
	/** ジャイロスコープセンサーモード */
	public final static String GYROSCOPE_SENSOR_MODE = "gyroscopesensormode";
	/** 直線加速度センサーモード */
	public final static String LINEARACCELERATION_SENSOR_MODE = "linearaccelerationsensormode";
	/** 磁場センサーモード */
	public final static String MAGNETICFIELD_SENSOR_MODE = "magneticfieldsensormode";
	/** 温度センサーモード */
	public final static String TEMPERATURE_SENSOR_MODE = "temperaturesensormode";
	/** 照度センサーモード */
	public final static String LIGHT_SENSOR_MODE = "lightsensormode";
	/** 方位センサーモード */
	public final static String ORIENTATION_SENSOR_MODE = "orientationsensormode";
	/** 近接センサーモード */
	public final static String PROXIMITY_SENSOR_MODE = "proximitysensormode";
	
	/** センサーモード */
	private static String sensorMode;
	
	/**
	 * Setter
	 * @param mode
	 */
	public static void setSensorMode(String mode) {
		sensorMode = mode;
	}
	/**
	 * Getter
	 * @return sensorMode
	 */
	public static String getSensorMode() {
		return sensorMode;
	}
	
}
