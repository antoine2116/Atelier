package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Studentinfo extends AtelierActivity {

    private TextView mTextView;

    public static void displayActivity(AtelierActivity activity,String nom,String title){
        Intent intent = new Intent(activity,Studentinfo.class);
        intent.putExtra("nom",nom);
        intent.putExtra("title",title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfo);

        String nom = getIntent().getExtras().getString("nom","");
        String title = getIntent().getExtras().getString("title","");

        mTextView = (TextView) findViewById(R.id.textInfoEtudiant);
        mTextView.setText(nom);



    }

}