package fr.epsi.atelier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    AtelierActivity activity;
    ArrayList<Category> categorys;

    public CategoryAdapter(AtelierActivity activity, ArrayList<Category> categories){
        this.activity=activity;
        this.categorys=categories;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final View layoutCellCategorys;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = view.findViewById(R.id.textViewName);
            layoutCellCategorys = view.findViewById(R.id.layoutCellCategories);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public View getLayoutCellStudent() {
            return layoutCellCategorys;
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
        final Category student=categorys.get(position);
        holder.getTextViewName().setText(student.getTitle());
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }
}
