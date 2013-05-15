package yk.sensor;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * SENSORACTIVITYclass
 * ここでセンサーにリスナーつけて
 * センサーの値を出力
 * @author Yk
 *
 */
public class SensorActivity extends Activity implements SensorEventListener, OnClickListener {
	
	/** センサーマネージャー */
	private SensorManager sensorManager;
	/** センサーリスト */
	private List<Sensor> sensorList;
	
	/** タイトル */
	private TextView titleText;
	/** ラベル1 */
	private TextView valueLabel1;
	/** ラベル2 */
	private TextView valueLabel2;
	/** ラベル3 */
	private TextView valueLabel3;
	/** センサー値1 */
	private TextView valueText1;
	/** センサー値2 */
	private TextView valueText2;
	/** センサー値3 */
	private TextView valueText3;
	
	/** 戻るボタン */
	private Button back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor);
		
		// Textインスタンス
		titleText = (TextView)findViewById(R.id.titleText);
		valueLabel1 = (TextView)findViewById(R.id.valueLabel1);
		valueLabel2 = (TextView)findViewById(R.id.valueLabel2);
		valueLabel3 = (TextView)findViewById(R.id.valueLabel3);
		valueText1 = (TextView)findViewById(R.id.valueText1);
		valueText2 = (TextView)findViewById(R.id.valueText2);
		valueText3 = (TextView)findViewById(R.id.valueText3);
		
		// Buttonインスタンス&SetListener
		back = (Button)findViewById(R.id.back_button);
		back.setOnClickListener(this);
		
		/*
		 * センサー設定
		 */
		try {
			
			// SensorManagerインスタンス
			sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
			
			// Sensor取得
			if(CommonVariableManagement.ACCELEROMETER_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
				titleText.setText(R.string.ACCELEROMETER);
				valueLabel1.setText(R.string.Xlabel);
				valueLabel2.setText(R.string.Ylabel);
				valueLabel3.setText(R.string.Zlabel);
			}else if(CommonVariableManagement.GRAVITY_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);
				titleText.setText(R.string.GRAVITY);
				valueLabel1.setText(R.string.Xlabel);
				valueLabel2.setText(R.string.Ylabel);
				valueLabel3.setText(R.string.Zlabel);
			}else if(CommonVariableManagement.GYROSCOPE_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
				titleText.setText(R.string.GYROSCOPE);
				valueLabel1.setText(R.string.Xlabel);
				valueLabel2.setText(R.string.Ylabel);
				valueLabel3.setText(R.string.Zlabel);
			}else if(CommonVariableManagement.LINEARACCELERATION_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_LINEAR_ACCELERATION);
				titleText.setText(R.string.LINEARACCELERATION);
				valueLabel1.setText(R.string.Xlabel);
				valueLabel2.setText(R.string.Ylabel);
				valueLabel3.setText(R.string.Zlabel);
			}else if(CommonVariableManagement.MAGNETICFIELD_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
				titleText.setText(R.string.MAGNETICFIELD);
				valueLabel1.setText(R.string.Xlabel);
				valueLabel2.setText(R.string.Ylabel);
				valueLabel3.setText(R.string.Zlabel);
			}else if(CommonVariableManagement.TEMPERATURE_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
				titleText.setText(R.string.TEMPERATURE);
				valueLabel1.setText(R.string.CELSIUSlabel);
				valueLabel2.setVisibility(View.INVISIBLE);
				valueLabel3.setVisibility(View.INVISIBLE);
				valueText2.setVisibility(View.INVISIBLE);
				valueText3.setVisibility(View.INVISIBLE);
			}else if(CommonVariableManagement.LIGHT_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_LIGHT);
				titleText.setText(R.string.LIGHT);
				valueLabel1.setText(R.string.LUXlabel);
				valueLabel2.setVisibility(View.INVISIBLE);
				valueLabel3.setVisibility(View.INVISIBLE);
				valueText2.setVisibility(View.INVISIBLE);
				valueText3.setVisibility(View.INVISIBLE);
			}else if(CommonVariableManagement.ORIENTATION_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
				titleText.setText(R.string.ORIENTATION);
				valueLabel1.setText(R.string.AZIMUTHlabel);
				valueLabel2.setText(R.string.PITCHlabel);
				valueLabel3.setText(R.string.ROLLlabel);
			}else if(CommonVariableManagement.PROXIMITY_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				sensorList = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
				titleText.setText(R.string.PROXIMITY);
				valueLabel1.setText(R.string.DISTANCElabel);
				valueLabel2.setVisibility(View.INVISIBLE);
				valueLabel3.setVisibility(View.INVISIBLE);
				valueText2.setVisibility(View.INVISIBLE);
				valueText3.setVisibility(View.INVISIBLE);
			}
			
			// Sensor搭載判断
			if(sensorList.size() > 0) {
				// SensorListener
				sensorManager.registerListener(
						this, 
						sensorList.get(0), 
						SensorManager.SENSOR_DELAY_NORMAL);
				
			}else{
				Log.d("sensorList", "noSensor");
				valueText1.setText(R.string.NOSENSOR);
				valueText2.setText(R.string.NOSENSOR);
				valueText3.setText(R.string.NOSENSOR);
			}
			
		} catch (Exception e) {
			Log.d("SensorActivity", "error_sensorManager_" + e);
			Toast.makeText(this, "初期化エラー", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		// ポーズの段階でセンサー解除
		try {
			sensorManager.unregisterListener(this);
		} catch (Exception e) {
			Log.d("SensorActivity", "error_sensorManager_" + e);
			Toast.makeText(this, "センサー解除エラー", Toast.LENGTH_SHORT).show();
		}
		
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		return super.onCreateOptionsMenu(menu);
//	}
	
	/*
	 * Sensor精度変更時
	 * (非 Javadoc)
	 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// 不使用
	}
	
	/*
	 * Sensor反応時
	 * (非 Javadoc)
	 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		
		try {
			// センサー値を出力
			if(CommonVariableManagement.ACCELEROMETER_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.GRAVITY_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.GYROSCOPE_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.LINEARACCELERATION_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.MAGNETICFIELD_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.ORIENTATION_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				valueText1.setText("" + event.values[0]);
				valueText2.setText("" + event.values[1]);
				valueText3.setText("" + event.values[2]);
			}else if(CommonVariableManagement.TEMPERATURE_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.LIGHT_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())
					|| CommonVariableManagement.PROXIMITY_SENSOR_MODE.equals(CommonVariableManagement.getSensorMode())) {
				valueText1.setText("" + event.values[0]);
			}
			
		} catch (Exception e) {
			Log.d("SensorActivity", "error_sensorManager_" + e);
			Toast.makeText(this, "センサー出力エラー", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	/*
	 * ClickListener
	 */
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		// 戻るボタン
		case R.id.back_button:
			Intent intent = new Intent(this, Title.class);
			startActivity(intent);
			finish();
			break;
		// デフォルト
		default:
			break;
		}
		
	}

}
