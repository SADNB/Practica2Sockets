import java.io.*;
import java.io.IOException;




//Classe equiv a ServerSocket pero que encapsuli excepcions
//ServerSocket permetra manipular la conexio des de la part del servidor
public class MyServerSocket extends ServerSocket {

  MySocket socket;

  try {
    this.socket = new Socket(host,port);

  }catch(IOException e) {
    System.out.println(e);
  }



}
