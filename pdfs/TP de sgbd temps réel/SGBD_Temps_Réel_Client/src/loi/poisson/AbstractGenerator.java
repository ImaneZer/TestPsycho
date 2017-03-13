package loi.poisson;

import java.util.Random;


/**

 * Superclasse des generateurs aleatoires

 * Gere l'encapsulation des generateurs

 * @author CnCBoy

 */

public abstract class AbstractGenerator implements Generator
{

 /**

 * Generateur utilisé comme fondement

 */

 protected Random rand;

 

 /**

 * Constructeur pour les sous classes

 * @param seed Initialisateur du generateur pseudo-aleatoire

 */

 public AbstractGenerator(){

 rand = new Random();

 }

}
