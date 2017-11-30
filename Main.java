import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Klient klient = new Klient();
        Serwer serwer = new Serwer();
        boolean lacznosc = klient.nawiaz_lacznosc();
        if (lacznosc){
            serwer.nawiaz_lacznosc();
        }
        String str =" ";
        while (!str.equalsIgnoreCase("Q") && !str.equalsIgnoreCase("Q")){
            klient.nadaj_wiadomosc();
            serwer.czekaj_na_dane();
        }
        klient.zamknij_polaczenie();
        serwer.zamknij_polaczenie();
    }
}
