package JUnitDemo;

import java.io.Serializable;

public class Caluclator implements Serializable {
    int id=1212;
    String password="sharukh";
    public Caluclator(){}

    public Caluclator(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public float div(int a, int b) {
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public String toString() {
        return "Caluclator{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
