package com.mtingwi.chisoni.zakumunda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CropCategoriesAdapter extends RecyclerView.Adapter<CropCategoryViewHolder> {
    private Context context;
    private String[] cropCategories;

    public CropCategoriesAdapter(Context context, String[] cropCategories) {
        this.context = context;
        this.cropCategories = cropCategories;
    }

    @Override
    public CropCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.crop_category_item_holder, parent, false);

        return new CropCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CropCategoryViewHolder holder, int position) {
        String cropCategory = cropCategories[position];
        holder.setCropCategoryTextView(cropCategory);
    }

    @Override
    public int getItemCount() {
        int total = 0;

        if (cropCategories != null) total = cropCategories.length;
        return total;
    }
}
