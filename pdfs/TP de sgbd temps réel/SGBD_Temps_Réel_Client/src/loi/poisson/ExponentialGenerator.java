
package loi.poisson;

public class ExponentialGenerator extends AbstractGenerator {

 

 private double lambda;

 

 public ExponentialGenerator(double lambda) {

 super();

 this.lambda = lambda;

 }

 public double nextDouble() {

 double y = rand.nextDouble();

 return (-1.0 / lambda) * Math.log(1.0 - y);

 }

 // @Override

 public double getTheory(double x) {

 return 1.0 - Math.exp(-1 * lambda * x);

 }

 

 public double getLambda() {

 return this.lambda;

 }

 // @Override

 public double getMinSupport() {

 // TODO Auto-generated method stub

 return 0;

 }

 // @Override

 public double getMaxSupport() {

 // TODO Auto-generated method stub

 return 5;

 }

}
