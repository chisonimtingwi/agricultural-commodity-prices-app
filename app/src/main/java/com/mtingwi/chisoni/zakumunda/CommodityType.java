package com.mtingwi.chisoni.zakumunda;


enum CommodityType {

    BEANS, GOAT, GROUNDNUTS, MAIZE, RICE;

    private static CommodityType[] items = null;

    public static CommodityType fromInt(int i) {
        if (CommodityType.items == null) {
            CommodityType.items = CommodityType.values();
        }

        return CommodityType.items[i];
    }
}
