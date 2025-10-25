package serverPackage;

import java.io.Serializable;

public class Operations implements Serializable {
    private double a;
    private double b;
    private char op;

    public Operations(double a, char op, double b) {
        this.a = a;
        this.op = op;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getOp() {
        return op;
    }
}
