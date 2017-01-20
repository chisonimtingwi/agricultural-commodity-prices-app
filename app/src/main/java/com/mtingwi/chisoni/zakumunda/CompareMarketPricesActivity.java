package com.mtingwi.chisoni.zakumunda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mikepenz.materialdrawer.Drawer;

public class CompareMarketPricesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Drawer result = null;
    private NavigationDrawerLoader loader;

    private static int FIRST_MARKET_SPINNER = 0;
    private static int SECOND_MARKET_SPINNER = 1;

    private String firstMarketSelection = "";
    private String secondMarketSelection = "";
    private String commoditySelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_market_prices);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Compare Market Prices");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.tabsScrollColor));
        setSupportActionBar(toolbar);

        loader = new NavigationDrawerLoader(this, savedInstanceState, toolbar);
        result = loader.loadNavigationDrawer(NavigationMenuItem.PRICES_BETWEEN_MARKETS.getId());

        Spinner firstMarketSpinner = (Spinner) findViewById(R.id.firstMarketSpinner);
        Spinner secondMarketSpinner = (Spinner) findViewById(R.id.secondMarketSpinner);
        Spinner commoditySpinner = (Spinner) findViewById(R.id.commoditySpinner);
        Button comparePricesButton = (Button) findViewById(R.id.comparePricesButton);

        // market type list
        ArrayAdapter<String> marketDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, MarketsList.all());
        marketDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // commodity type list
        ArrayAdapter<String> commoditiesDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommodityTypeList.all());
        commoditiesDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        firstMarketSpinner.setAdapter(marketDataAdapter);
        firstMarketSpinner.setOnItemSelectedListener(new MarketSpinnerOnItemSelectedListener(FIRST_MARKET_SPINNER));

        secondMarketSpinner.setAdapter(marketDataAdapter);
        secondMarketSpinner.setOnItemSelectedListener(new MarketSpinnerOnItemSelectedListener(SECOND_MARKET_SPINNER));

        commoditySpinner.setAdapter(commoditiesDataAdapter);
        commoditySpinner.setOnItemSelectedListener(new CommoditySpinnerOnItemSelectedListener());

        comparePricesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit() {
        if (firstMarketSelection.trim().equals("")) {
            new DialogBox(this, "The first market is empty. Please select a market!", DialogBox.DialogBoxType.OK_ONLY);
        } else if (secondMarketSelection.trim().equals("")) {
            new DialogBox(this, "The first market is empty. Please select a market!", DialogBox.DialogBoxType.OK_ONLY);
        } else if (commoditySelection.trim().equals("")) {
            new DialogBox(this, "The commodity is empty. Please select a market!", DialogBox.DialogBoxType.OK_ONLY);
        } else if (firstMarketSelection.trim().equals(secondMarketSelection.trim())) {
            new DialogBox(this, "The first market cannot be equal to the second market. Please choose different markets!", DialogBox.DialogBoxType.OK_ONLY);
        } else {
            //Toast.makeText(this, "All good", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MarketPriceComparisonActivity.class);
            intent.putExtra("firstMarketDetails", firstMarketSelection);
            intent.putExtra("secondMarketDetails", secondMarketSelection);
            intent.putExtra("commodityDetails", commoditySelection);

            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        result = loader.loadNavigationDrawer(NavigationMenuItem.PRICES_BETWEEN_MARKETS.getId());
    }

    private class MarketSpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        private int whichSpinner;

        public MarketSpinnerOnItemSelectedListener(int whichSpinner) {
            this.whichSpinner = whichSpinner;
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (whichSpinner == FIRST_MARKET_SPINNER) {
                firstMarketSelection = parent.getItemAtPosition(position).toString();
            } else {
                secondMarketSelection = parent.getItemAtPosition(position).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class CommoditySpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            commoditySelection = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
