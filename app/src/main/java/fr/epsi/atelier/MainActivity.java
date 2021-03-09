package fr.epsi.atelier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AtelierActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonEtudiant1).setOnClickListener(this);
        findViewById(R.id.buttonEtudiant2).setOnClickListener(this);
        findViewById(R.id.buttonEtudiant3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEtudiant1:
                Studentinfo.displayActivity(this,"Louis","Etudiant");
                break;
            case R.id.buttonEtudiant2:
                Studentinfo.displayActivity(this,"Marien","Etudiant");
                break;
            case R.id.buttonEtudiant3:
                Studentinfo.displayActivity(this,"Antoine","Etudiant");
                break;
        }
    }
}




