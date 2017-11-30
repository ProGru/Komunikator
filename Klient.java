import java.io.*;
import java.net.*;

public class Klient
{
    public static final int PORT=50007;
    public static final String HOST = "192.168.12.252";
    private BufferedReader klaw;
    private PrintWriter outp;
    private Socket sock;

    public boolean nawiaz_lacznosc() throws IOException {
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);
        klaw=new BufferedReader(new InputStreamReader(System.in));
        outp=new PrintWriter(sock.getOutputStream());

        return true;
    }

    public String nadaj_wiadomosc() throws IOException {
        String str=" ";

        System.out.print("\n<Text:> ");
        str=klaw.readLine();
        outp.println(str);
        outp.flush();
        return str;
    }

    public void zamknij_polaczenie() throws IOException {
        System.out.println("zamykam");
        klaw.close();
        outp.close();
        sock.close();
    }
}
