package practice2;

import java.io.Serializable;

public class Answer implements Serializable {
    private Double a;
    private Double b;
    private boolean error;
    public boolean getError() {
        return error;
    }
    public void setError(boolean error) {
        this.error = error;
    }
    public Double getA() {return a;}
    public void setA(Double a) {this.a = a;}
    public Double getB() {return b;}
    public void setB(Double b) {this.b = b;}
    @Override
    public String toString() {
        if (error){
            return "Уравнение не имеет корней";
        }
        if (a == null && b == null){
            return "Уравнение имеет бесконечное число корней";
        }
        if (b == null){
            return "Корень уравнения равен " + a;
        }
        return "Корни уравнения равны " + a + " и "  + b;
    }
}
