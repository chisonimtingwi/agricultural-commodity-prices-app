package com.mtingwi.chisoni.zakumunda;

import java.util.Arrays;
import java.util.List;

public class CommodityTypeList {
    private static String[] commodityTypeList = {"", "Beans", "Goats", "Groundnuts", "Maize", "Rice"};

    public static List<String> all() {
        return Arrays.asList(commodityTypeList);
    }
}
