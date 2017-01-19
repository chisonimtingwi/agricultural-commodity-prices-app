package com.mtingwi.chisoni.zakumunda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MarketsList {
    private static String[] marketsList = new String[]{
            "", "Area 24, Lilongwe", "Bembeke, Dedza", "Bwengu, Rumphi",
            "Chezi, Dowa", "Chikweo, Machinga", "Chilinga, Phalombe",
            "Chimbiya, Dedza", "Chinamwali, Zomba", "Chinsapo, Lilongwe",
            "Chinthembwe, Ntchisi", "Chiradzulu Boma, Chiradzulu",
            "Chitakale, Mulanje", "Chitipa Boma, Chitipa", "Goliati, Thyolo",
            "Ifumbo, Karonga", "Jali, Zomba", "Jenda, Mzimba",
            "Karonga Boma, Karonga", "Kasungu Boma, Kasungu",
            "Lilongwe Main, Lilongwe", "Limbe, Blantyre", "Livinzu, Chikwawa",
            "Lizulu, Ntcheu", "Lobi, Dedza", "Lunzu, Blantyre", "Magomero, Dedza",
            "Makiyoni, Salima", "Malindi, Mangochi", "Malomo, Ntchisi",
            "Marka, Nsanje", "Mayani , Dedza", "Mbayani, Blantyre",
            "Mbulumbudzu, Chiradzulu", "Mdeka, Blantyre", "Mitondo, Chikwawa",
            "Mitundu, Lilongwe", "Mphatsa, Phalombe", "Mphepozinayi, Ntcheu",
            "Msika Mzuzu, Mzimba", "Msika Nkhata Bay, Nkhata Bay",
            "Msika Wa Mchinji, Mchinji", "Msika Waukulu, Blantyre", "Mtunthama, Kasungu",
            "Mulanje Boma, Mulanje", "Ngabu, Chikwawa", "Nkando, Mulanje",
            "Nkhotakota Boma, Nkhotakota", "Nsanama, Machinga", "Nsundwe, Lilongwe",
            "Ntchisi Boma, Ntchisi", "Ntonda, Ntcheu", "Uliwa, Karonga"
    };

    public static List<String> all() {
        return Arrays.asList(marketsList);
    }
}
