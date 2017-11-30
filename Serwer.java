import java.io.*;
import java.net.*;

public class Serwer
{
    public static final int PORT=50008;
    private Socket sock;
    private ServerSocket serv;
    private BufferedReader inp;

    public boolean nawiaz_lacznosc() throws IOException {
        serv=new ServerSocket(PORT);
        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: "+serv);
        sock=serv.accept();
        System.out.println("Jest polaczenie: "+sock);
        inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));

        return true;


    }

    public void zamknij_polaczenie() throws  IOException {
        System.out.println("zamykam");
        inp.close();
        sock.close();
        serv.close();
    }

    public void czekaj_na_dane() throws IOException {
        String str = "";
        str=inp.readLine();
        System.out.println("<Nadeszlo:> " + str);

    }
}