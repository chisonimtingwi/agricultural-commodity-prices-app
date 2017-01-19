package com.mtingwi.chisoni.zakumunda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CommoditiesList {
    private static List<Commodity> commodities;

    public static List<Commodity> all() {
        commodities = new ArrayList<>();

        for (Object[] item : list) {

            Commodity commodity = new Commodity();
            commodity.setName((String) item[0]);
            commodity.setMarketName((String) item[1]);
            commodity.setDistrict((String) item[2]);
            commodity.setUnitPrice((String) item[3]);
            commodity.setCommodityType((CommodityType) item[4]);

            commodities.add(commodity);
        }

        return commodities;
    }


    public static List<Commodity> findByName(String nameToSearch) {
        commodities = new ArrayList<>();

        for (Object[] item : list) {
            String commodityName = (String) item[0];
            // if they are not the same skip them
            if (!commodityName.toLowerCase().equals(nameToSearch.toLowerCase())) continue;

            Commodity commodity = new Commodity();
            commodity.setName((String) item[0]);
            commodity.setMarketName((String) item[1]);
            commodity.setDistrict((String) item[2]);
            commodity.setUnitPrice((String) item[3]);
            commodity.setUnitPriceValue(Double.parseDouble(((String) item[3]).split("/")[0]));
            commodity.setCommodityType((CommodityType) item[4]);

            commodities.add(commodity);
        }

        Collections.shuffle(commodities, new Random(System.nanoTime()));

        return commodities;
    }

    public static String firstHighestPriceByMarketNameAndCommodity(String marketNameToSearch, String districtToSearch, String commodityToSearch) {

        boolean found = false;
        Double marketPriceValue = 0.0;
        String marketPrice = "Price Not Available";

        List<Commodity> commoditiesList = CommoditiesList.all();

        for (Commodity commodity : commoditiesList) {

            // skip unnecessary districts
            if (!commodity.getDistrict().toLowerCase().equals(districtToSearch.toLowerCase())) {
                continue;
            }
            // skip unnecessary markets
            if (!commodity.getMarketName().toLowerCase().equals(marketNameToSearch.toLowerCase())) {
                continue;
            }

            // skip unnecessary commodities
            if (!commodity.getName().toLowerCase().equals(commodityToSearch.toLowerCase())) {
                continue;
            }

            if (!found) {
                marketPrice = commodity.getUnitPrice();
                found = true;
            }

            if (marketPriceValue < commodity.getUnitPriceValue()) {
                marketPrice = commodity.getUnitPrice();
            }
        }

        return marketPrice;
    }

    private static Object[][] list = new Object[][]{
            {"Groundnuts", "Lobi", "Dedza", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Mbayani", "Blantyre", "280.00/Kg", CommodityType.MAIZE},
            {"Beans", "Jenda", "Mzimba", "500.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Chitipa Boma", "Chitipa", "450.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Mbayani", "Blantyre", "290.00/Kg", CommodityType.MAIZE},
            {"Rice", "Msika Nkhata Bay", "Nkhata Bay", "450.00/Kg", CommodityType.RICE},
            {"Rice", "Ifumbo", "Karonga", "0.00/Kg", CommodityType.RICE},
            {"Maize", "Mbayani", "Blantyre", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Bwengu", "Rumphi", "10000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Msika Waukulu", "Blantyre", "1000.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Msika Mzuzu", "Mzimba", "0.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Chinsapo", "Lilongwe", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Chitakale", "Mulanje", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Mayani ", "Dedza", "12000.00/Each", CommodityType.GOAT},
            {"Maize", "Malomo", "Ntchisi", "200.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Chitipa Boma", "Chitipa", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Malomo", "Ntchisi", "13000.00/Each", CommodityType.GOAT},
            {"Maize", "Lobi", "Dedza", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Ifumbo", "Karonga", "529.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Limbe", "Blantyre", "800.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Lobi", "Dedza", "400.00/Kg", CommodityType.RICE},
            {"Rice", "Jali", "Zomba", "0.00/Kg", CommodityType.RICE},
            {"Rice", "Mphatsa", "Phalombe", "580.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Kasungu Boma", "Kasungu", "500.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Malomo", "Ntchisi", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Nkhotakota Boma", "Nkhotakota", "0.00/Each", CommodityType.GOAT},
            {"Goats", "Chiradzulu Boma", "Chiradzulu", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Lizulu", "Ntcheu", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Goliati", "Thyolo", "0.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Ntonda", "Ntcheu", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Mayani ", "Dedza", "0.00/Kg", CommodityType.RICE},
            {"Rice", "Nkhotakota Boma", "Nkhotakota", "0.00/Kg", CommodityType.RICE},
            {"Beans", "Chitipa Boma", "Chitipa", "550.00/Kg", CommodityType.BEANS},
            {"Goats", "Malindi", "Mangochi", "15000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Mitundu", "Lilongwe", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Mphepozinayi", "Ntcheu", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Mulanje Boma", "Mulanje", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Msika Wa Mchinji", "Mchinji", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Lobi", "Dedza", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Mulanje Boma", "Mulanje", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Msika Mzuzu", "Mzimba", "700.00/Kg", CommodityType.BEANS},
            {"Beans", "Mulanje Boma", "Mulanje", "850.00/Kg", CommodityType.BEANS},
            {"Maize", "Karonga Boma", "Karonga", "0.00/Tin", CommodityType.MAIZE},
            {"Rice", "Uliwa", "Karonga", "650.00/Kg", CommodityType.RICE},
            {"Maize", "Nkando", "Mulanje", "150.00/Kg", CommodityType.MAIZE},
            {"Maize", "Mtunthama", "Kasungu", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Msika Nkhata Bay", "Nkhata Bay", "0.00/Kg", CommodityType.BEANS},
            {"Beans", "Area 24", "Lilongwe", "650.00/Kg", CommodityType.BEANS},
            {"Maize", "Mbulumbudzu", "Chiradzulu", "150.00/Kg", CommodityType.MAIZE},
            {"Rice", "Chinamwali", "Zomba", "0.00/Kg", CommodityType.RICE},
            {"Rice", "Mayani ", "Dedza", "700.00/Kg", CommodityType.RICE},
            {"Maize", "Area 24", "Lilongwe", "150.00/Kg", CommodityType.MAIZE},
            {"Beans", "Msika Waukulu", "Blantyre", "1000.00/Kg", CommodityType.BEANS},
            {"Goats", "Kasungu Boma", "Kasungu", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Chitipa Boma", "Chitipa", "0.00/Kg", CommodityType.MAIZE},
            {"Maize", "Chezi", "Dowa", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Msika Mzuzu", "Mzimba", "600.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Mayani ", "Dedza", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Malindi", "Mangochi", "300.00/Kg", CommodityType.MAIZE},
            {"Maize", "Malindi", "Mangochi", "0.00/Kg", CommodityType.MAIZE},
            {"Maize", "Ntonda", "Ntcheu", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Chitakale", "Mulanje", "0.00/Kg", CommodityType.BEANS},
            {"Rice", "Magomero", "Dedza", "670.00/Kg", CommodityType.RICE},
            {"Beans", "Limbe", "Blantyre", "0.00/Kg", CommodityType.BEANS},
            {"Beans", "Ntchisi Boma", "Ntchisi", "400.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Kasungu Boma", "Kasungu", "650.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Chiradzulu Boma", "Chiradzulu", "8000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Nkhotakota Boma", "Nkhotakota", "2500.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Kasungu Boma", "Kasungu", "200.00/Kg", CommodityType.MAIZE},
            {"Maize", "Nsundwe", "Lilongwe", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Mulanje Boma", "Mulanje", "900.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Chitakale", "Mulanje", "800.00/Kg", CommodityType.BEANS},
            {"Beans", "Lunzu", "Blantyre", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Chimbiya", "Dedza", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Mayani ", "Dedza", "450.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Lunzu", "Blantyre", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Lizulu", "Ntcheu", "150.00/Kg", CommodityType.MAIZE},
            {"Goats", "Kasungu Boma", "Kasungu", "15000.00/Each", CommodityType.GOAT},
            {"Maize", "Bembeke", "Dedza", "220.00/Kg", CommodityType.MAIZE},
            {"Rice", "Chitipa Boma", "Chitipa", "450.00/Kg", CommodityType.RICE},
            {"Beans", "Mulanje Boma", "Mulanje", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Nsundwe", "Lilongwe", "220.00/Kg", CommodityType.MAIZE},
            {"Goats", "Livinzu", "Chikwawa", "10000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Chitipa Boma", "Chitipa", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Mitondo", "Chikwawa", "10000.00/Each", CommodityType.GOAT},
            {"Beans", "Kasungu Boma", "Kasungu", "300.00/Kg", CommodityType.BEANS},
            {"Rice", "Chikweo", "Machinga", "600.00/Kg", CommodityType.RICE},
            {"Rice", "Msika Nkhata Bay", "Nkhata Bay", "0.00/Kg", CommodityType.RICE},
            {"Maize", "Chitipa Boma", "Chitipa", "650.00/Tin", CommodityType.MAIZE},
            {"Goats", "Malindi", "Mangochi", "0.00/Each", CommodityType.GOAT},
            {"Beans", "Magomero", "Dedza", "0.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Mayani ", "Dedza", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Lunzu", "Blantyre", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Bwengu", "Rumphi", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Makiyoni", "Salima", "0.00/Each", CommodityType.GOAT},
            {"Goats", "Mdeka", "Blantyre", "0.00/Each", CommodityType.GOAT},
            {"Rice", "Lilongwe Main", "Lilongwe", "620.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Ifumbo", "Karonga", "550.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Chinsapo", "Lilongwe", "750.00/Basin", CommodityType.MAIZE},
            {"Goats", "Magomero", "Dedza", "0.00/Each", CommodityType.GOAT},
            {"Goats", "Chinthembwe", "Ntchisi", "10000.00/Each", CommodityType.GOAT},
            {"Goats", "Malomo", "Ntchisi", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Lobi", "Dedza", "200.00/Kg", CommodityType.MAIZE},
            {"Maize", "Mphepozinayi", "Ntcheu", "200.00/Kg", CommodityType.MAIZE},
            {"Maize", "Karonga Boma", "Karonga", "0.00/Kg", CommodityType.MAIZE},
            {"Maize", "Mdeka", "Blantyre", "160.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Bwengu", "Rumphi", "3500.00/Tin", CommodityType.GROUNDNUTS},
            {"Beans", "Ntchisi Boma", "Ntchisi", "0.00/Kg", CommodityType.BEANS},
            {"Goats", "Bwengu", "Rumphi", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Msika Nkhata Bay", "Nkhata Bay", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Mulanje Boma", "Mulanje", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Lunzu", "Blantyre", "900.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Mitundu", "Lilongwe", "650.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Msika Wa Mchinji", "Mchinji", "600.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Chinsapo", "Lilongwe", "0.00/Kg", CommodityType.BEANS},
            {"Rice", "Karonga Boma", "Karonga", "7500.00/Tin", CommodityType.RICE},
            {"Rice", "Jali", "Zomba", "580.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Area 24", "Lilongwe", "900.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Msika Mzuzu", "Mzimba", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Mphatsa", "Phalombe", "0.00/Kg", CommodityType.RICE},
            {"Maize", "Mulanje Boma", "Mulanje", "250.00/Kg", CommodityType.MAIZE},
            {"Maize", "Chimbiya", "Dedza", "155.00/Kg", CommodityType.MAIZE},
            {"Maize", "Makiyoni", "Salima", "220.00/Kg", CommodityType.MAIZE},
            {"Rice", "Nkhotakota Boma", "Nkhotakota", "750.00/Kg", CommodityType.RICE},
            {"Maize", "Nkhotakota Boma", "Nkhotakota", "240.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Bwengu", "Rumphi", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Chinthembwe", "Ntchisi", "0.00/Each", CommodityType.GOAT},
            {"Rice", "Chilinga", "Phalombe", "580.00/Kg", CommodityType.RICE},
            {"Rice", "Malomo", "Ntchisi", "0.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Limbe", "Blantyre", "800.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Lunzu", "Blantyre", "17000.00/Each", CommodityType.GOAT},
            {"Maize", "Makiyoni", "Salima", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Marka", "Nsanje", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Mayani ", "Dedza", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Ifumbo", "Karonga", "0.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Mitundu", "Lilongwe", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Ntonda", "Ntcheu", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Ntonda", "Ntcheu", "140.00/Kg", CommodityType.MAIZE},
            {"Goats", "Ntchisi Boma", "Ntchisi", "16000.00/Each", CommodityType.GOAT},
            {"Maize", "Msika Nkhata Bay", "Nkhata Bay", "170.00/Kg", CommodityType.MAIZE},
            {"Rice", "Chitakale", "Mulanje", "700.00/Kg", CommodityType.RICE},
            {"Goats", "Chimbiya", "Dedza", "9000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Nsundwe", "Lilongwe", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Chimbiya", "Dedza", "0.00/Kg", CommodityType.BEANS},
            {"Rice", "Limbe", "Blantyre", "700.00/Kg", CommodityType.RICE},
            {"Goats", "Kasungu Boma", "Kasungu", "18000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Ifumbo", "Karonga", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Karonga Boma", "Karonga", "10000.00/Tin", CommodityType.RICE},
            {"Groundnuts", "Chitakale", "Mulanje", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Bwengu", "Rumphi", "0.00/Tin", CommodityType.GROUNDNUTS},
            {"Beans", "Chitipa Boma", "Chitipa", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Karonga Boma", "Karonga", "2500.00/Tin", CommodityType.MAIZE},
            {"Groundnuts", "Msika Waukulu", "Blantyre", "800.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Magomero", "Dedza", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Chinsapo", "Lilongwe", "800.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Nkhotakota Boma", "Nkhotakota", "550.00/Kg", CommodityType.RICE},
            {"Beans", "Kasungu Boma", "Kasungu", "0.00/Kg", CommodityType.BEANS},
            {"Rice", "Lunzu", "Blantyre", "0.00/Kg", CommodityType.RICE},
            {"Beans", "Nkhotakota Boma", "Nkhotakota", "800.00/Kg", CommodityType.BEANS},
            {"Maize", "Kasungu Boma", "Kasungu", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Ifumbo", "Karonga", "0.00/Each", CommodityType.GOAT},
            {"Rice", "Malomo", "Ntchisi", "650.00/Kg", CommodityType.RICE},
            {"Rice", "Chitakale", "Mulanje", "0.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Lunzu", "Blantyre", "900.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Chezi", "Dowa", "200.00/Kg", CommodityType.MAIZE},
            {"Goats", "Ntchisi Boma", "Ntchisi", "0.00/Each]", CommodityType.GOAT},
            {"Goats", "Goliati", "Thyolo", "15000.00/Each", CommodityType.GOAT},
            {"Rice", "Lobi", "Dedza", "0.00/Kg", CommodityType.RICE},
            {"Rice", "Lunzu", "Blantyre", "700.00/Kg", CommodityType.RICE},
            {"Rice", "Ifumbo", "Karonga", "510.00/Kg", CommodityType.RICE},
            {"Goats", "Nkhotakota Boma", "Nkhotakota", "15000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Chitakale", "Mulanje", "900.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Chinthembwe", "Ntchisi", "170.00/Kg", CommodityType.MAIZE},
            {"Rice", "Magomero", "Dedza", "0.00/Kg", CommodityType.RICE},
            {"Goats", "Marka", "Nsanje", "8000.00/Each", CommodityType.GOAT},
            {"Beans", "Msika Nkhata Bay", "Nkhata Bay", "670.00/Kg", CommodityType.BEANS},
            {"Groundnuts", "Ntonda", "Ntcheu", "700.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Kasungu Boma", "Kasungu", "650.00/Kg", CommodityType.BEANS},
            {"Goats", "Chikweo", "Machinga", "0.00/Each", CommodityType.GOAT},
            {"Goats", "Mdeka", "Blantyre", "9000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Nsundwe", "Lilongwe", "580.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Kasungu Boma", "Kasungu", "700.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Msika Wa Mchinji", "Mchinji", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Chitakale", "Mulanje", "245.00/Kg", CommodityType.MAIZE},
            {"Maize", "Mdeka", "Blantyre", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Area 24", "Lilongwe", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Chinthembwe", "Ntchisi", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Limbe", "Blantyre", "700.00/Kg", CommodityType.BEANS},
            {"Goats", "Jenda", "Mzimba", "15000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Msika Mzuzu", "Mzimba", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Kasungu Boma", "Kasungu", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Msika Waukulu", "Blantyre", "1000.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Kasungu Boma", "Kasungu", "0.00/Kg", CommodityType.RICE},
            {"Beans", "Chimbiya", "Dedza", "700.00/Kg", CommodityType.BEANS},
            {"Goats", "Ngabu", "Chikwawa", "8000.00/Each", CommodityType.GOAT},
            {"Goats", "Ifumbo", "Karonga", "16950.00/Each", CommodityType.GOAT},
            {"Goats", "Ntchisi Boma", "Ntchisi", "0.00/Each", CommodityType.GOAT},
            {"Rice", "Chinamwali", "Zomba", "700.00/Kg", CommodityType.RICE},
            {"Goats", "Chikweo", "Machinga", "12000.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Mayani ", "Dedza", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Groundnuts", "Bwengu", "Rumphi", "3500.00/Tin", CommodityType.GROUNDNUTS},
            {"Maize", "Mayani ", "Dedza", "180.00/Kg", CommodityType.MAIZE},
            {"Beans", "Nkhotakota Boma", "Nkhotakota", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Chinsapo", "Lilongwe", "0.00/Basin", CommodityType.MAIZE},
            {"Maize", "Lilongwe Main", "Lilongwe", "0.00/Kg", CommodityType.MAIZE},
            {"Goats", "Magomero", "Dedza", "12000.00/Each", CommodityType.GOAT},
            {"Maize", "Nkhotakota Boma", "Nkhotakota", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Area 24", "Lilongwe", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Nkhotakota Boma", "Nkhotakota", "20000.00/Each", CommodityType.GOAT},
            {"Goats", "Jenda", "Mzimba", "0.00/Each", CommodityType.GOAT},
            {"Maize", "Ifumbo", "Karonga", "0.00/Kg", CommodityType.MAIZE},
            {"Rice", "Uliwa", "Karonga", "0.00/Kg", CommodityType.RICE},
            {"Rice", "Chitipa Boma", "Chitipa", "0.00/Kg", CommodityType.RICE},
            {"Maize", "Bembeke", "Dedza", "0.00/Kg", CommodityType.MAIZE},
            {"Beans", "Chinsapo", "Lilongwe", "650.00/Kg", CommodityType.BEANS},
            {"Maize", "Nkando", "Mulanje", "0.00/Kg", CommodityType.MAIZE},
            {"Maize", "Kasungu Boma", "Kasungu", "260.00/Kg", CommodityType.MAIZE},
            {"Goats", "Chimbiya", "Dedza", "0.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Nkhotakota Boma", "Nkhotakota", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Area 24", "Lilongwe", "0.00/Kg", CommodityType.MAIZE},
            {"Rice", "Chikweo", "Machinga", "0.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Malindi", "Mangochi", "700.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Nsanama", "Machinga", "0.00/Kg", CommodityType.RICE},
            {"Groundnuts", "Lobi", "Dedza", "400.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Bwengu", "Rumphi", "180.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Chitakale", "Mulanje", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Beans", "Jenda", "Mzimba", "0.00/Kg", CommodityType.BEANS},
            {"Maize", "Mtunthama", "Kasungu", "220.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Nkhotakota Boma", "Nkhotakota", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Ngabu", "Chikwawa", "0.00/Each", CommodityType.GOAT},
            {"Groundnuts", "Ifumbo", "Karonga", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Maize", "Lilongwe Main", "Lilongwe", "230.00/Kg", CommodityType.MAIZE},
            {"Rice", "Nsanama", "Machinga", "580.00/Kg", CommodityType.RICE},
            {"Rice", "Chilinga", "Phalombe", "0.00/Kg", CommodityType.RICE},
            {"Maize", "Mbulumbudzu", "Chiradzulu", "0.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Kasungu Boma", "Kasungu", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Rice", "Karonga Boma", "Karonga", "0.00/Tin", CommodityType.RICE},
            {"Maize", "Magomero", "Dedza", "200.00/Kg", CommodityType.MAIZE},
            {"Maize", "Ifumbo", "Karonga", "176.00/Kg", CommodityType.MAIZE},
            {"Groundnuts", "Malindi", "Mangochi", "0.00/Kg", CommodityType.GROUNDNUTS},
            {"Goats", "Makiyoni", "Salima", "10000.00/Each", CommodityType.GOAT},
            {"Beans", "Lunzu", "Blantyre", "700.00/Kg", CommodityType.BEANS},
            {"Rice", "Jali", "Zomba", "600.00/Kg", CommodityType.RICE},
            {"Beans", "Magomero", "Dedza", "650.00/Kg", CommodityType.BEANS}
    };
}
