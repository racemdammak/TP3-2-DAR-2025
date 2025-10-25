package clientPackage;

import serverPackage.Operations;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connecté au serveur.");

            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez le premier nombre : ");
            double a = sc.nextDouble();
            System.out.print("Entrez l'opérateur (+, -, *, /) : ");
            char op = sc.next().charAt(0);
            System.out.print("Entrez le deuxième nombre : ");
            double b = sc.nextDouble();

            Operations operation = new Operations(a, op, b);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(operation);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            double resultat = (double) ois.readObject();
            System.out.println("Résultat reçu : " + resultat);

            oos.close();
            ois.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
