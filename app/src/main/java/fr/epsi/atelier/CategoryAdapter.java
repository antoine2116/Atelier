package fr.epsi.atelier;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.atelier.models.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    AtelierActivity activity;
    ArrayList<Category> categories;

    public CategoryAdapter(AtelierActivity activity, ArrayList<Category> categories){
        this.activity=activity;
        this.categories =categories;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Button buttonCellCategory;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            buttonCellCategory = view.findViewById(R.id.buttonCellCategory);
        }

        public Button getButtonCellCategory() {
            return buttonCellCategory;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_categories, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Category category = categories.get(position);
        holder.getButtonCellCategory().setText(category.getTitle());
        holder.getButtonCellCategory().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductsListActivity.displayActivity(activity, category.getTitle(), category.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
