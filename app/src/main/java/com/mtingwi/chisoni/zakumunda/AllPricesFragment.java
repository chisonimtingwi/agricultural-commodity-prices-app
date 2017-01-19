package com.mtingwi.chisoni.zakumunda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;


public class AllPricesFragment extends Fragment {
    private SmartSwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView allPricesRecyclerView;
    private SimpleSnackBar simpleSnackBar = new SimpleSnackBar();
    private View allPricesView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        allPricesView = inflater.inflate(R.layout.all_prices_fragment, container, false);

        swipeRefreshLayout = (SmartSwipeRefreshLayout) allPricesView.findViewById(R.id.allPricesSmartSwipeRefreshLayout);
        allPricesRecyclerView = (RecyclerView) allPricesView.findViewById(R.id.allPricesRecyclerView);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setScrollingView(allPricesRecyclerView);
        swipeRefreshLayout.setEnabled(false);

        allPricesRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        allPricesRecyclerView,
                        new AllPricesFragmentRecyclerItemClickListener()
                )
        );

        allPricesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        allPricesRecyclerView.setAdapter(null);

        return allPricesView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                getDataFromRemoteServer();
            }
        }, 500);
    }

    private void getDataFromRemoteServer() {
        simpleSnackBar.showDefaultSnackbar(allPricesView, "Loading commodities. Please wait...");
        swipeRefreshLayout.setRefreshing(true);


        allPricesRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        allPricesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        allPricesRecyclerView.setAdapter(new AllPricesAdapter(getContext(), CommoditiesList.all()));

        swipeRefreshLayout.setRefreshing(false);
    }

    private class AllPricesFragmentRecyclerItemClickListener implements RecyclerItemClickListener.OnItemClickListener {

        @Override
        public void onItemClick(View view, int position) {
            TextView commodityTextView = (TextView) view.findViewById(R.id.commodityTextView);
            TextView unitPriceTextView = (TextView) view.findViewById(R.id.unitPriceTextView);
            TextView locationNameTextView = (TextView) view.findViewById(R.id.locationNameTextView);

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    String.format(
                            "%s cost(s) %s at %s.",
                            commodityTextView.getText(),
                            unitPriceTextView.getText(),
                            locationNameTextView.getText()
                    )
            );
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share to"));
        }

        @Override
        public void onItemLongClick(View view, int position) {

        }
    }
}
