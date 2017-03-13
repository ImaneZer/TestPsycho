package loi.poisson;

import java.util.ArrayList;

import java.util.List;

public class Loidepoisson extends AbstractGenerator {

 

 /**

 * Param�tre de la loi de poisson

 */

 private double lambdaPoisson;

 

 private ExponentialGenerator exponentialGenerator;

 

 /**

 * Constructeur du g�n�rateur de nombres suivant une loi de poisson

 * @param lambda : parametre de la loi de poisson

 */

 public Loidepoisson(double lambda) {

 super();

 this.lambdaPoisson = lambda;

 this.exponentialGenerator = new ExponentialGenerator(Math.random());

 }

 

 /**

 * G�n�re un nombre al�atoire suivant la loi de Poisson

 * 

 * Cet algorithme g�n�re tout d'abord une liste de nombres aleatoires 

suivant une loi exponentielle 

 * de param�tre l. Lorsque la somme de ces nombre g�n�r�s est sup�rieure � 

la periode T 

 * (calcul�e par : T = parametre lambda de cette loi de poisson / l), 

l'algorithme retourne

 * le nombre N de valeurs g�n�r�es suivant la loi exponentielle. Les valeurs

de N suivent

 * alors la loi de poisson du générateur.

 * 

 */

 public double nextDouble() {

 double t = lambdaPoisson / exponentialGenerator.getLambda();

 List<Double> exponentialValues = new ArrayList<Double>();

 

 while (t >= sum(exponentialValues)) {

 exponentialValues.add(this.exponentialGenerator.nextDouble());

 }

 return exponentialValues.size();

 }

 /**

 * Retourne la probabilit� th�orique (d'apres l'expression de la loi de 

Poisson)

 * d'une valeur x

 * @param x : la valeur dont on souhaite la probabilit�, doit �tre un entier

 */

 public double getTheory(double x) {

 int xEntier = (int) Math.floor(x);

 double value = Math.exp(-1.0 * lambdaPoisson) * Math.pow(lambdaPoisson, 

xEntier) / fact(xEntier);

 return value;

 }

 

 /**

 * Calcul la somme des nombres de la liste donn�e en param�tre.

 * @param list

 * @return la somme

 */

 private double sum(List<Double> list) {

 double sum = 0.0;

 for (Double number : list) {

 sum += number;

 }

 return sum;

 }

 

 /**

 * Calcul la factorielle de x

 * @param x

 * @return la factorielle de x

 */

 private int fact(int x) {

 

 //Cas particulier de 0! FIX

 if (x == 0){

 

 return 1;

 }

 

 int fact = x;

 while (x > 1) {

 x--;

 fact *= x;

 }

 return x;

 }

 public double getMinSupport() {

 // TODO Auto-generated method stub

 return 0;

 }

 public double getMaxSupport() {

 // TODO Auto-generated method stub

 return 50;

 }

}