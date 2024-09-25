/**
 * This is a Monomial class.
 */
public class Monomial implements Comparable<Monomial> {
	//initial variables of type Integer coefficient and degree
    private int coefficient;
    private int degree;
    
    //constructor method to initialize variables
    public Monomial(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }
    
    //get coefficient method returns coefficient
    public int getCoefficient() {
        return coefficient;
    }
  //get degree method returns degree
    public int getDegree() {
        return degree;
    }
    //compareTo method will return difference between degree
    public int compareTo(Monomial m) {
        return this.degree - m.degree;
    }
}