package com.mtingwi.chisoni.zakumunda;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by E.Kachale on 18/01/2017.
 */

public class CropCategoryViewHolder extends RecyclerView.ViewHolder {
    TextView cropCategoryTextView;

    public CropCategoryViewHolder(View view) {
        super(view);

        cropCategoryTextView = (TextView) view.findViewById(R.id.cropCategoryTextView);
    }

    public TextView getCropCategoryTextView() {
        return cropCategoryTextView;
    }

    public void setCropCategoryTextView(CharSequence cropCategory) {
        this.cropCategoryTextView.setText(cropCategory);
    }
}
