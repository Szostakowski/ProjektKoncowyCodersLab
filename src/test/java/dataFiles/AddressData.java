package dataFiles;

import java.util.Arrays;
import java.util.List;

public class AddressData {

    int chose = 2;

    static List<String> address = Arrays.asList
            ("DC Street 22", "Aleja Gwiazd 100", "Super Hero avenue 5", "Ulica Sezamkowa 10", "Goblińska 15");
    String getAddress(){
        return address.get(chose);
    }


    static List<String> city = Arrays.asList
            ("Shire", "Gotham City", "Pcin Dolny", "Przemysl (sie)", "Srodziemiedzin");
    String getCity(){
        return city.get(chose);
    }


    static List<String> zipCode = Arrays.asList
            ("01-000", "20-222", "00-666", "69-999", "33-777");
    String getZipCode(){
        return zipCode.get(chose);
    }

}
