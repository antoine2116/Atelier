package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AtelierActivity {

    public static void displayActivity(AtelierActivity activity, String url, String name, String description) {
        Intent intent = new Intent(activity, ProductDetailsActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("name", name);
        intent.putExtra("description", description);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        String url = getIntent().getExtras().getString("url","");
        String name = getIntent().getExtras().getString("name","");
        String description = getIntent().getExtras().getString("description","");

        setTitle(name);
        showBack();

        ImageView imageView = findViewById(R.id.imageDetails);
        Picasso.get().load(url).into(imageView);

        TextView textView = findViewById(R.id.textViewProductDescriptionDetails);
        textView.setText(description);
    }
}
