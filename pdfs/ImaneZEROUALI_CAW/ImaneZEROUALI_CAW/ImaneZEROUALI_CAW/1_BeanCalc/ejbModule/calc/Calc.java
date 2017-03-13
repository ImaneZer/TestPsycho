package calc;

import javax.ejb.Remote;

@Remote 
public interface Calc {
    public double add(double val1, double val2);
    public double mult(double val1, double val2);
}
