package com.mtingwi.chisoni.zakumunda;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CommodityViewHolder extends RecyclerView.ViewHolder {

    private TextView locationNameTextView;
    private TextView unitPriceTextView;
    private TextView commodityTextView;

    CommodityViewHolder(View v) {
        super(v);

        commodityTextView = (TextView) v.findViewById(R.id.commodityTextView);
        unitPriceTextView = (TextView) v.findViewById(R.id.unitPriceTextView);
        locationNameTextView = (TextView) v.findViewById(R.id.locationNameTextView);
    }

    public TextView getCommodityTextView() {
        return commodityTextView;
    }

    public void setCommodityTextView(CharSequence commodityName) {
        this.commodityTextView.setText(commodityName);
    }

    public TextView getLocationNameTextView() {
        return locationNameTextView;
    }

    public void setLocationNameTextView(CharSequence locationName) {
        this.locationNameTextView.setText(locationName);
    }

    public TextView getUnitPriceTextView() {
        return unitPriceTextView;
    }

    public void setUnitPriceTextView(CharSequence unitPrice) {
        this.unitPriceTextView.setText(unitPrice);
    }
}
