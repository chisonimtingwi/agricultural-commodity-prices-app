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

public class CropCategoriesFragment extends Fragment {

    String[] cropCategories = new String[]{"Beans", "Maize", "Rice", "Groundnuts", "Goats"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View cropCategoriesView = inflater.inflate(R.layout.crop_categories_fragment, container, false);
        SmartSwipeRefreshLayout swipeRefreshLayout = (SmartSwipeRefreshLayout) cropCategoriesView.findViewById(R.id.cropCategoriesSmartSwipeRefreshLayout);
        RecyclerView cropCategoriesRecyclerView = (RecyclerView) cropCategoriesView.findViewById(R.id.cropCategoriesRecyclerView);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setScrollingView(cropCategoriesRecyclerView);
        swipeRefreshLayout.setEnabled(false);

        cropCategoriesRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        cropCategoriesRecyclerView,
                        new CropCategoriesFragmentRecyclerItemClickListener()
                )
        );
        swipeRefreshLayout.setRefreshing(true);

        cropCategoriesRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        cropCategoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        cropCategoriesRecyclerView.setAdapter(new CropCategoriesAdapter(getContext(), cropCategories));

        swipeRefreshLayout.setRefreshing(false);


        return cropCategoriesView;
    }

    private class CropCategoriesFragmentRecyclerItemClickListener implements RecyclerItemClickListener.OnItemClickListener {

        @Override
        public void onItemClick(View view, int position) {
            TextView commodityTextView = (TextView) view.findViewById(R.id.cropCategoryTextView);

            Intent intent = new Intent(getActivity(), PricesByCropActivity.class);
            intent.putExtra("commodityName", commodityTextView.getText());
            startActivity(intent);
        }

        @Override
        public void onItemLongClick(View view, int position) {

        }
    }
}
