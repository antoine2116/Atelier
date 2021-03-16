package fr.epsi.atelier;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class AtelierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("tag", "#################### onCreate ####################"+getClass().getSimpleName());
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("tag","############## finish ################# :"+getClass().getSimpleName());
    }
}