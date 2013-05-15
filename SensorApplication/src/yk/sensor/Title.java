package yk.sensor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * TITLEclass
 * タイトルクラス一番はじめのアクティビティ
 * ここでセンサーの振り分けを選択
 * @author Yk
 *
 */
public class Title extends Activity implements OnClickListener {
	
	/** 加速度センサーボタン */
	private Button accelerometerButton;
	/** 重力度センサーボタン */
	private Button gravityButton;
	/** ジャイロスコープセンサーボタン */
	private Button gyroscopeButton;
	/** 直線加速度センサーボタン */
	private Button linearaccelerationButton;
	/** 磁場センサーボタン */
	private Button magneticfieldButton;
	/** 温度センサーボタン */
	private Button temperatureButton;
	/** 照度センサーボタン */
	private Button lightButton;
	/** 方位センサーボタン */
	private Button orientationButton;
	/** 近接センサーボタン */
	private Button proximityButton;
	/** EXITボタン */
	private Button exitButton;
	
	/** アクティビティ切替用インテント */
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
		
		// ボタン読み込み
		accelerometerButton = (Button)findViewById(R.id.accelerometerbutton);
		gravityButton = (Button)findViewById(R.id.gravitybutton);
		gyroscopeButton = (Button)findViewById(R.id.gyroscopebutton);
		linearaccelerationButton = (Button)findViewById(R.id.linearaccelerationbutton);
		magneticfieldButton = (Button)findViewById(R.id.magneticfieldbutton);
		temperatureButton = (Button)findViewById(R.id.temperaturebutton);
		lightButton = (Button)findViewById(R.id.lightbutton);
		orientationButton = (Button)findViewById(R.id.orientationbutton);
		proximityButton = (Button)findViewById(R.id.proximitybutton);
		exitButton = (Button)findViewById(R.id.exitbutton);
		
		// ボタンセットリスナー
		accelerometerButton.setOnClickListener(this);
		gravityButton.setOnClickListener(this);
		gyroscopeButton.setOnClickListener(this);
		linearaccelerationButton.setOnClickListener(this);
		magneticfieldButton.setOnClickListener(this);
		temperatureButton.setOnClickListener(this);
		lightButton.setOnClickListener(this);
		orientationButton.setOnClickListener(this);
		proximityButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.title, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		// 加速度ボタン
		case R.id.accelerometerbutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.ACCELEROMETER_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 重力度ボタン
		case R.id.gravitybutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.GRAVITY_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// ジャイロスコープボタン
		case R.id.gyroscopebutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.GYROSCOPE_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 直線加速度ボタン
		case R.id.linearaccelerationbutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.LINEARACCELERATION_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 磁場ボタン
		case R.id.magneticfieldbutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.MAGNETICFIELD_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 温度ボタン
		case R.id.temperaturebutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.TEMPERATURE_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 照度ボタン
		case R.id.lightbutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.LIGHT_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 方位ボタン
		case R.id.orientationbutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.ORIENTATION_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// 近接ボタン
		case R.id.proximitybutton:
			CommonVariableManagement.setSensorMode(CommonVariableManagement.PROXIMITY_SENSOR_MODE);
			intent = new Intent(this, SensorActivity.class);
			startActivity(intent);
			finish();
			break;
		// EXITボタン
		case R.id.exitbutton:
			finish();
			break;
		// デフォルト
		default:
			break;
		}
		
	}

}
