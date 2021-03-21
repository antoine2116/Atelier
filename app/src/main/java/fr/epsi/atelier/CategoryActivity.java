package fr.epsi.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.atelier.models.Category;

public class CategoryActivity extends AtelierActivity {

    public static void displayActivity(AtelierActivity activity){
        Intent intent=new Intent(activity, CategoryActivity.class);
        activity.startActivity(intent);
    }

    private ArrayList<Category> categorys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        setTitle("Rayons");
        showBack();
        categorys = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categorys);
        recyclerView.setAdapter(categoryAdapter);

        String url = "https://djemam.com/epsi/categories.json";
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Category category = new Category(jsonArray.getJSONObject(i));
                        categorys.add(category);
                    }
                    categoryAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(CategoryActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}
