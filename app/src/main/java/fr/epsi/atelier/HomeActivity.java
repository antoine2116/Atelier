package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends MainActivity {

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
