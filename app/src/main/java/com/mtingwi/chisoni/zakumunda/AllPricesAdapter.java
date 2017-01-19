package com.mtingwi.chisoni.zakumunda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by E.Kachale on 12/9/2016.
 */
public class AllPricesAdapter extends RecyclerView.Adapter<CommodityViewHolder> {

    private List<Commodity> commodities;
    private Context context;


    public AllPricesAdapter(Context context, List<Commodity> commodities) {
        this.context = context;
        this.commodities = commodities;
    }

    @Override
    public CommodityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.commodity_item_holder, parent, false);

        return new CommodityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommodityViewHolder holder, int position) {
        Commodity commodity = commodities.get(position);

        holder.setCommodityTextView(commodity.getName());
        holder.setLocationNameTextView(commodity.getFullLocationName());
        holder.setUnitPriceTextView(commodity.getUnitPrice());
    }

    @Override
    public int getItemCount() {
        int total = 0;

        if (commodities != null) total = commodities.size();
        return total;
    }
}