package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AtelierActivity implements View.OnClickListener{

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.buttonEtudiant).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEtudiant:
                StudentActivity.displayActivity(this);
                break;
           // case R.id.buttonEtudiant2:
               // Studentinfo.displayActivity(this,"Marien","Etudiant");
               // break;

        }
    }
}
