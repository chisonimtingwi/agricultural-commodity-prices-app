package com.mtingwi.chisoni.zakumunda;


import java.util.HashMap;

public class Commodity {
    private String name;
    private String unitPrice;
    private String marketName;
    private CommodityType commodityType;
    private String district;
    private double unitPriceValue = 0.0;
    private HashMap<CommodityType, Integer> icons;

    public CommodityType getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityType commodityType) {
        this.commodityType = commodityType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMarketName() {
        return marketName;
    }

    public String getFullLocationName() {
        return String.format("%s, %s", getMarketName(), getDistrict());
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPriceValue() {
        return unitPriceValue;
    }

    public void setUnitPriceValue(double unitPriceValue) {
        this.unitPriceValue = unitPriceValue;
    }

    public int getCommodityIconImageView() {
        icons = new HashMap<>();

        icons.put(CommodityType.BEANS, R.drawable.beans);
        icons.put(CommodityType.GOAT, R.drawable.goat);
        icons.put(CommodityType.GROUNDNUTS, R.drawable.groundnuts);
        icons.put(CommodityType.MAIZE, R.drawable.maize);
        icons.put(CommodityType.RICE, R.drawable.rice);

        return icons.get(this.getCommodityType());
    }
}
