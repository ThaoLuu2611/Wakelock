package thao.com.wakelock;

import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private PowerManager powerManager;
    private PowerManager.WakeLock wakeLock;
    private int field = 0x00000020;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(field, getLocalClassName());
    }
    public void onWakeLockClick(View v){
        Log.d("thaomoc","button 1");
        if(!wakeLock.isHeld()) {
            wakeLock.acquire();
            Log.d("thaomoc","button1 get wwake");
        }
    }
    public void onReleaseWakeLockClick(View v){
        Log.d("thaomoc","button 2");
        if(wakeLock.isHeld()) {
            wakeLock.release();
            Log.d("thaomoc","button 2 release");
        }
    }
}
