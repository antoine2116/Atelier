package fr.epsi.atelier;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends AtelierActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                HomeActivity.displayActivity(SplashActivity.this);
                finish();
            }
        }, 2000);
    }
}
