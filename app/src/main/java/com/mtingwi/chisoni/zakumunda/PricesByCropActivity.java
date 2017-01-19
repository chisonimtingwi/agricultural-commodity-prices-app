package com.mtingwi.chisoni.zakumunda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

public class PricesByCropActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices_by_crop);
        Intent intent = getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        if (intent != null) {
            String commodityName = intent.getStringExtra("commodityName");

            if (getSupportActionBar() != null){
                getSupportActionBar().setTitle(commodityName + " Prices");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            SmartSwipeRefreshLayout swipeRefreshLayout = (SmartSwipeRefreshLayout) findViewById(R.id.allPricesSmartSwipeRefreshLayout);
            RecyclerView cropCategoriesRecyclerView = (RecyclerView) findViewById(R.id.allPricesRecyclerView);

            swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            swipeRefreshLayout.setScrollingView(cropCategoriesRecyclerView);
            swipeRefreshLayout.setEnabled(false);

            cropCategoriesRecyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(
                            this,
                            cropCategoriesRecyclerView,
                            new PricesByCropActivityRecyclerItemClickListener()
                    )
            );
            swipeRefreshLayout.setRefreshing(true);

            cropCategoriesRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

            cropCategoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            cropCategoriesRecyclerView.setAdapter(new AllPricesAdapter(this, CommoditiesList.findByName(commodityName)));

            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private class PricesByCropActivityRecyclerItemClickListener implements RecyclerItemClickListener.OnItemClickListener {

        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onItemLongClick(View view, int position) {

        }
    }
}
