package com.mtingwi.chisoni.zakumunda;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;

public enum NavigationMenuItem {

    HOME(R.string.home_menu_item, FontAwesome.Icon.faw_home),
    PRICES_BETWEEN_MARKETS(R.string.prices_between_markets, FontAwesome.Icon.faw_exchange),
    ABOUT(R.string.about_menu_item, R.drawable.ic_blank_menu);

    private int text;
    private FontAwesome.Icon icon = null;
    private int imageIcon = 0;

    NavigationMenuItem(int text, FontAwesome.Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    NavigationMenuItem(int text, int ic_blank_menu) {
        this.text = text;
        this.imageIcon = ic_blank_menu;
    }

    public FontAwesome.Icon getIcon() {
        return icon;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public int getText() {
        return text;
    }

    public int getId() {
        return ordinal() * 1000;
    }
}