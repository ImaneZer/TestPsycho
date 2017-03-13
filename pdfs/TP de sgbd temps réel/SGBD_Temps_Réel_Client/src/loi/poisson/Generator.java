
package loi.poisson;

/**

 * Interface principale d'un generateur al�atoire

 * @author CnCBoy

 */

public interface Generator {

 

 /**

 * Retourne une valeur conforme au generateur al�atoire

 * @return Valeur du generateur entre 0 et 1

 */

 public double nextDouble();

 

 /**

 * Retourne la valeur P((X<=x) de la fonction de repartion

 * @param x seuil

 * @return Probabilite d'avoir une valeur inferieur ou egal � x

 */

 public double getTheory(double x);

 

 /**

 * Retourne la limite inferieure pour l'etude de ce generateur

 * @return 

 */

 public double getMinSupport();

 

 /**

 * Retourne la limite superieure pour l'etude de ce generateur

 * @return 

 */

 public double getMaxSupport();

}

