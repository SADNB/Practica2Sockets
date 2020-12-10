import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Ignacio Poza i Blanca Ruiz

//Classe a programar com a dos threads concurrents:
//Un llegueix linies teclat i les envia al Server (Input thread)
//L'altre llegueix linies server(enviades per client) i les mostra per pantalla (Output thread)
//readLine del teclat retorna null i tanca l'escriptura del Socket (necessari BufferedReader)

public class Client {

  public static final String SERVER_HOST = "localhost";
  public static final int SERVER_PORT = 5000;

  public static void main(String[] args) throws IOException {
    MySocket socket = new MySocket(SERVER_HOST, SERVER_PORT);
    System.out.println("Socket connectat: " + socket + "\n");

    //Creacio del input thread
    new Thread() {
      //Describim el subproces, que estarà en estat Runnable
      //Fent-ho així no caldra declarar cap thread en concret
      public void run() {
        String liniaInput;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          try {
            //Input thread
            while ((liniaInput = in.readLine()) != null) {
            //escriure linia per socket
              socket.println(liniaInput);
          }
          in.close();
          socket.close(); //Tanquem connexio amb el socket
        }catch(IOException e) {
            System.out.println("No s'ha pogut enviar el missatge correctament\n");
        }
      }
    }.start(); // El mètode start creara els recursos del sistema necessaris per a que el nostre subprocés s'executi i faci la funcio run().
              //Entre els corchetes escrivim el funcionament del thread

    //Creacio del output thread
    new Thread() {
      public void run() {
        //Output thread
        String liniaOutput;
        while ((liniaOutput = socket.readLine()) != null)   //mentres hi ha linia del server (diferent de null)
          //escriure linia per pantalla
          System.out.println(liniaOutput);
      }
    }.start()

}
