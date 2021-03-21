package fr.epsi.atelier;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.atelier.models.ProductList;

public class ProductsListActivity extends AtelierActivity {

    private ArrayList<ProductList> productLists;

    public static void displayActivity(AtelierActivity activity, String title, String url) {
        Intent intent = new Intent(activity, ProductsListActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        productLists = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProductsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductsListAdapter productsListAdapter = new ProductsListAdapter(this, productLists);
        recyclerView.setAdapter(productsListAdapter);
        String title = getIntent().getExtras().getString("title","");
        setTitle(title);
        showBack();

        String url = getIntent().getExtras().getString("url","");
        Log.d("tag","##############  ################# :"+ url);

        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ProductList productList = new ProductList(jsonArray.getJSONObject(i));
                        productLists.add(productList);
                    }
                    productsListAdapter.notifyDataSetChanged();
                }
                catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProductsListActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}