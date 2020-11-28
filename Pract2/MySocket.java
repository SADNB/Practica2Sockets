import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader; //necessari per utilitzar BufferedReader
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.net.* //proporciona la classe Socket



//Classe equiv a Socket però amb streams de text BufferedReader/PrintWriter
//Socket permet implementar la connexió des de la part del client
public class MySocket extends Socket {

  Socket socket;
  BufferedReader br;
  PrintWriter pw;

  //Haurem de coneixer direccio IP (host) i port de comunicació amb el servidor
  public Socket (String host, int port) {
    //Creem socket i el connectem al port i a la direccio IP especificat
    try {
      this.socket = new Socket(host,port);
    }catch(IOException e) {
      System.out.println(e);
    }


  }


  //Metode escriptura tipus basic amb ajuda de PrintWriter
  public String println(String data) {
    pw.println(data);
    pw.flush();
  }

  //Metode lectura tipus basic amb ajuda de BufferedReader
  public String readLine() {
    String data = null;
    try {
      data = br.readLine();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return data;
  }


  public void close() {
    try {
      socket.close();
      br.close();
      pw.close();
    }catch (IOException e) {
    e.printStackTrace();
  }

  }





}
