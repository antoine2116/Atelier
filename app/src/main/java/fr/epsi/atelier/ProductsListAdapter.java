package fr.epsi.atelier;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.atelier.models.ProductList;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    AtelierActivity activity;
    ArrayList<ProductList> productLists;

    public ProductsListAdapter(AtelierActivity activity, ArrayList<ProductList> productLists) {
        this.activity = activity;
        this.productLists = productLists;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewProductName;
        private final TextView textViewProductDescription;
        private final ImageView imageViewProduct;
        private final View layoutCellProductList;

        public ViewHolder(View view) {
            super(view);
            textViewProductName = view.findViewById(R.id.textViewProductName);
            textViewProductDescription = view.findViewById(R.id.textViewProductDescription);
            imageViewProduct = view.findViewById(R.id.imageViewProduct);
            layoutCellProductList = view.findViewById(R.id.layoutCellProductList);
        }

        public TextView getTextViewProductName() { return textViewProductName; }

        public TextView getTextViewProductDescription() { return textViewProductDescription; }

        public ImageView getImageViewProduct() { return imageViewProduct; }

        public View getLayoutCellProductList() { return layoutCellProductList; }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_products_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProductList productList = productLists.get(position);
        holder.getTextViewProductName().setText(productList.getName());
        holder.getTextViewProductDescription().setText(productList.getDescription());
        Picasso.get().load(productList.getPictureUrl()).into(holder.getImageViewProduct());
        holder.getLayoutCellProductList().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailsActivity.displayActivity(activity, productList.getPictureUrl(), productList.getName(), productList.getDescription());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }
}
