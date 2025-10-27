package serverPackage;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess extends Thread {
    Socket socket;
    Operations op;

    public ClientProcess(Socket socket, Operations op) {
        this.socket = socket;
        this.op = op;
    }
    public void run() {
        double resultat = 0;
        switch (op.getOp()) {
            case '+': resultat = op.getA() + op.getB(); break;
            case '-': resultat = op.getA() - op.getB(); break;
            case '*': resultat = op.getA() * op.getB(); break;
            case '/':
                if (op.getB() != 0) resultat = op.getA() / op.getB();
                else {
                    System.out.println("division par zéro !");
                    resultat = Double.NaN;
                }
                break;
            default:
                System.out.println("Opérateur invalide !");
        }
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Resultat de l'operation n°+"+ Serveur.getCompteur() + ": "+resultat);
    }
}
