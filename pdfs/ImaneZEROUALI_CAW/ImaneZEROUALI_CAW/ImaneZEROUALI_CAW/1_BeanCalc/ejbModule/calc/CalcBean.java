package calc;

import javax.ejb.Stateless;

@Stateless 
public class CalcBean implements Calc {

    public double add(double val1, double val2) {
        return val1 + val2;
    }
    public double mult(double val1, double val2) {
        return val1 * val2;
    }
}
