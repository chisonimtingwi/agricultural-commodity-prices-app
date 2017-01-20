package com.mtingwi.chisoni.zakumunda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MarketPriceComparisonActivity extends AppCompatActivity {
    List<Commodity> marketPrices;
    String firstMarketDetails;
    String secondMarketDetails;
    String commodityDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_price_comparison);

        Intent intent = getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        if (intent != null) {
            firstMarketDetails = intent.getStringExtra("firstMarketDetails");
            secondMarketDetails = intent.getStringExtra("secondMarketDetails");
            commodityDetails = intent.getStringExtra("commodityDetails");

            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            extractMarketData();

            SmartSwipeRefreshLayout swipeRefreshLayout = (SmartSwipeRefreshLayout) findViewById(R.id.marketPricesSmartSwipeRefreshLayout);
            RecyclerView cropCategoriesRecyclerView = (RecyclerView) findViewById(R.id.marketPricesRecyclerView);

            swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            swipeRefreshLayout.setScrollingView(cropCategoriesRecyclerView);
            swipeRefreshLayout.setEnabled(false);

            swipeRefreshLayout.setRefreshing(true);

            cropCategoriesRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

            cropCategoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            cropCategoriesRecyclerView.setAdapter(new AllPricesAdapter(this, marketPrices));

            swipeRefreshLayout.setRefreshing(false);

        }
    }

    private void extractMarketData() {
        Commodity commodity;

        marketPrices = new ArrayList<>();


        String firstMarketPrice = CommoditiesList.firstHighestPriceByMarketNameAndCommodity(
                (firstMarketDetails.split(",")[0]).trim(), (firstMarketDetails.split(",")[1]).trim(), commodityDetails.trim()
        );

        String secondMarketPrice = CommoditiesList.firstHighestPriceByMarketNameAndCommodity(
                (secondMarketDetails.split(",")[0]).trim(), (secondMarketDetails.split(",")[1]).trim(), commodityDetails.trim()
        );

        commodity = new Commodity();
        commodity.setMarketName((firstMarketDetails.split(",")[0]).trim());
        commodity.setDistrict((firstMarketDetails.split(",")[1]).trim());
        commodity.setUnitPrice(firstMarketPrice.trim());
        commodity.setName(commodityDetails.trim());

        marketPrices.add(commodity);

        commodity = new Commodity();
        commodity.setMarketName((secondMarketDetails.split(",")[0]).trim());
        commodity.setDistrict((secondMarketDetails.split(",")[1]).trim());
        commodity.setUnitPrice(secondMarketPrice.trim());
        commodity.setName(commodityDetails.trim());

        marketPrices.add(commodity);
    }
}
