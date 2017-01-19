package com.mtingwi.chisoni.zakumunda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class NavigationDrawerLoader {
    private Context context;
    private Bundle savedInstanceState;
    private Toolbar toolbar;
    private Drawer result;

    public NavigationDrawerLoader(Context context, Bundle savedInstanceState, Toolbar toolbar) {
        this.context = context;
        this.savedInstanceState = savedInstanceState;
        this.toolbar = toolbar;
    }

    private PrimaryDrawerItem getPrimaryDrawerItem(NavigationMenuItem menuItem, boolean selectedItem) {
        PrimaryDrawerItem item;

        if (null != menuItem.getIcon()) {
            item = new PrimaryDrawerItem().withName(menuItem.getText()).withIcon(menuItem.getIcon()).withIdentifier(menuItem.getId());
        } else if ((menuItem.getImageIcon() != 0)) {
            item = new PrimaryDrawerItem().withName(menuItem.getText()).withIcon(menuItem.getImageIcon()).withIdentifier(menuItem.getId());
        } else {
            item = new PrimaryDrawerItem().withName(menuItem.getText()).withIdentifier(menuItem.getId());
        }

        item.withSetSelected(selectedItem);
        item.withSelectedTextColorRes(R.color.colorPrimary);
        return item;
    }

    private void getMainMenuItemClicked(IDrawerItem drawerItem) {

        if (drawerItem != null) {
            Intent intent = null;
            if (drawerItem.getIdentifier() == NavigationMenuItem.HOME.getId()) {
                intent = new Intent(context, MainActivity.class);
            } else if (drawerItem.getIdentifier() == NavigationMenuItem.PRICES_BETWEEN_MARKETS.getId()) {
                intent = new Intent(context, CompareMarketPricesActivity.class);
            }
            else if (drawerItem.getIdentifier() == NavigationMenuItem.ABOUT.getId()) {
                intent = new Intent(context, AboutActivity.class);
            }

            if (intent != null) {
                context.startActivity(intent);
                //((Activity) context).overridePendingTransition(R.transition.activity_fade_in, R.transition.activity_fade_out);
            }
        }

    }

    public Drawer loadNavigationDrawer(long parentSelectedItem, long selectedItem) {
        constructMenu(parentSelectedItem);
        result.setSelection(selectedItem, false);
        return result;
    }

    public Drawer loadNavigationDrawer(long selectedItem) {
        constructMenu(selectedItem);
        result.setSelection(selectedItem, false);

        return result;
    }

    private void constructMenu(long selectedItem) {
        PrimaryDrawerItem home = getPrimaryDrawerItem(NavigationMenuItem.HOME, (selectedItem == NavigationMenuItem.HOME.getId()));
        PrimaryDrawerItem pricesBetweenMarkets = getPrimaryDrawerItem(NavigationMenuItem.PRICES_BETWEEN_MARKETS, (selectedItem == NavigationMenuItem.PRICES_BETWEEN_MARKETS.getId()));
        PrimaryDrawerItem about = getPrimaryDrawerItem(NavigationMenuItem.ABOUT, (selectedItem == NavigationMenuItem.ABOUT.getId()));

        result = new DrawerBuilder((Activity) context)
                .withRootView(R.id.navigation_drawer_container)
                .withToolbar(toolbar)
                .withDisplayBelowStatusBar(false)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        home,
                        pricesBetweenMarkets,
                        new DividerDrawerItem(),
                        about
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        getMainMenuItemClicked(drawerItem);
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();

    }
}