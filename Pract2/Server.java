import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Hem decidit utilitzar el ConcurrentHashMap per poder guardar els clients
que es connectin al nostre server. Hem optat per aquest tipus de Map perquè
després d'estar investigant les diferents posibilitats, hem arribat a la
conclusió que es el més eficient i elegant de tots.
*/

public class Server {
  private static final int SERVER_PORT = 5000;
  static ConcurrentHashMap<String, Handler> list_of_clients = new ConcurrentHashMap<String,Handler>();

  public static void main(String[] args) {
    System.out.println("Server initialized, waiting for clients...");
    Executors manager = Executors.newFixedThreadPool(50); //Utilizarem un Executors per tal de jugar amb els threads de la manera més simple i eficient, ja que així no calen bucles de threads.
    try(MyServerSocket myss = new MyServerSocket(SERVER_PORT)){
      while(true){
        manager.execute(new Handler(myss.accept()))
      }
    }
  }
  //Implementem un handler per facilitar la gestió dels threads
  public static class Handler implements Runnable{
    private final MySocket mysck;
    public BufferedReader in;
    public PrintWriter out;
    private String client_name;

    public Handler(MySocket sck){
      this.mysck=sck;
      this.in=new BufferedReader(new InputStreamReader(this.mysck.getInputStream()));
      this.out=new PrintWriter(new OutputStreamWriter(this.mysck.getOutputStream()));
  }
  @Override
  public void run(){
    try(this.mysck){
      while(true){
        try{
          this.client_name=this.in.readLine();
          this.out.flush();
        }catch(IOException e){
          System.out.println(e);
        }
        if(list_of_clients.containsKey(this.client_name)){
          this.out.println("User already connected");
          this.out.flush();
        }
        else{
          list_of_clients.put(this.client_name,this);
          this.out.println(client_name + " connected");
          this.out.flush();
          break;
        }
      }
      while(true){}
    }
  }


}
