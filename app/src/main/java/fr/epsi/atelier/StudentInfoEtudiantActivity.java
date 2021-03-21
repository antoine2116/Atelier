package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentInfoEtudiantActivity extends AtelierActivity {

    private TextView mTextView;

    public static void displayActivity(AtelierActivity activity, String nom, String prenom, String infoEtudiant, String email, String groupe){
        Intent intent = new Intent(activity, StudentInfoEtudiantActivity.class);
        intent.putExtra("Nom",nom);
        intent.putExtra("Prenom",prenom);
        intent.putExtra("InfoEtudiant",infoEtudiant);
        intent.putExtra("Email",email);
        intent.putExtra("Groupe",groupe);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfo);
        String nom = getIntent().getExtras().getString("Nom","");
        String prenom = getIntent().getExtras().getString("Prenom","");
        String infoEtudiant = getIntent().getExtras().getString("InfoEtudiant","");
        String email = getIntent().getExtras().getString("Email","");
        String groupe = getIntent().getExtras().getString("Groupe","");

        setTitle(nom);
        showBack();

        mTextView = (TextView) findViewById(R.id.InfoEtudiant);
        mTextView.setText(infoEtudiant);

        mTextView = (TextView) findViewById(R.id.Nom);
        mTextView.setText(nom);

        mTextView = (TextView) findViewById(R.id.Prenom);
        mTextView.setText(prenom);

        mTextView = (TextView) findViewById(R.id.Email);
        mTextView.setText(email);

        mTextView = (TextView) findViewById(R.id.Groupe);
        mTextView.setText(groupe);

        ImageView imageView = findViewById(R.id.image);
        switch (prenom){
            case "Marien":
                imageView.setImageResource(R.drawable.marien);
                break;
            case "Louis":
                imageView.setImageResource(R.drawable.louis);
                break;
            case "Antoine":
                imageView.setImageResource(R.drawable.antoine);
                break;
        }






    }

}