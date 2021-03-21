package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentActivity extends AtelierActivity implements View.OnClickListener {

    public static void displayActivity(AtelierActivity activity){
        Intent intent=new Intent(activity,StudentActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        setTitle("Infos");
        showBack();

        findViewById(R.id.buttonEtudiant1).setOnClickListener(this);
        findViewById(R.id.buttonEtudiant2).setOnClickListener(this);
        findViewById(R.id.buttonEtudiant3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEtudiant1:
                StudentInfoEtudiantActivity.displayActivity(this,"Dussoulier","Louis","Nouvel etudiant qui arrive de sur Bordeaux","dussoulier.louis@hotmail.fr","Groupe 1");
                break;
            case R.id.buttonEtudiant2:
                StudentInfoEtudiantActivity.displayActivity(this,"Farge","Marien","Nouvel etudiant qui aime les filles","farge.marien@gmail.com","Groupe 1");
                break;
            case R.id.buttonEtudiant3:
                StudentInfoEtudiantActivity.displayActivity(this,"Robin","Antoine","Etudiant qui aime les humains","robin.antoine@outlook.com","Groupe 1");
                break;
        }
    }
}