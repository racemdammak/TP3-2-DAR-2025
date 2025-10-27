package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {
    public static int compteur = 0;
    public static synchronized int  getCompteur()
    {
        compteur++;
        return compteur;
    }
    public static void main(String[] args) {

        try (ServerSocket socket = new ServerSocket(1234)) {
            while (true) {
                System.out.println("Serveur en attente d'une connexion ");
                Socket ss = socket.accept();
                System.out.println("Client connecté");

                ObjectInputStream ois = new ObjectInputStream(ss.getInputStream());
                Operations op = (Operations) ois.readObject();
                ClientProcess cp = new ClientProcess(ss, op);
                cp.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
