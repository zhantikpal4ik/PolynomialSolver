/**
 * This is a Polynomial class.
 * it stores monomials and create an ordered linked list of it
 */
public class Polynomial {
	//initial variable polynomial Ordered linked list
	private OrderedLinkedList<Monomial> polynomial;
	//constructor method initializing a variable
	public Polynomial() {
		polynomial = new OrderedLinkedList<>();
	
	}
	//add method inserts new monomial into the polynomial linked list
	public void add(int coefficent, int degree) {
		Monomial newMonomial = new Monomial(coefficent, degree);
		polynomial.insert(newMonomial);
	}
	//derivative method returns derivative of a polynomial
	public Polynomial derivative() {
		//creating a new Polynomial object (Ordered Linked list)
		Polynomial derivative = new Polynomial();
		//for loop is used to find derivative of each monomial in the polynomial and add to the new linked list
		for (int i = 0; i < polynomial.getSize(); i++) {
			Monomial monomial = polynomial.get(i);
			int coef = monomial.getCoefficient() * monomial.getDegree();
			int degree = monomial.getDegree() - 1;
			
			//we add derivative of the monomial to the new linked list only if the degree is equal or greater than zero
			if (degree>= 0) {
				derivative.add(coef,degree);
			}
			
			
		}
		return derivative;
	}
	// eval method returns the result of the polynomial if the x = z
	public double eval(double z) {
		double answer = 0;
		//for loop is used to calculate each monomial and sum them all
		for (int i = 0; i < polynomial.getSize(); i++) {
			Monomial monomial = polynomial.get(i);
			answer += monomial.getCoefficient() * Math.pow(z, monomial.getDegree());
		}
		return answer;
	}
	// toString method returns the polynomial in a string format
	public String toString() {
		//create a new string builder to build a string of a polynomial
		StringBuilder N = new StringBuilder();
		//for loop is used to add each monomial to the string builder in a string format
		for (int i = 0; i < polynomial.getSize(); i++) {
			Monomial monomial = polynomial.get(i);
			int coef = monomial.getCoefficient();
			int degree = monomial.getDegree();
			//if the monomial is the first monomial in the polynomial we don't put - or + sign before the coefficient
			if (i == 0) {
				if (coef >= 0) {
					N.append(coef).append("*x^").append(degree);
				} else {
					int absCoef = Math.abs(coef);
					N.append("-" + absCoef).append("*x^").append(degree + " ");
				}
			} else {
				if (coef >= 0) {
					N.append(" + " + coef ).append("*x^").append(degree);
				} else {
					int absCoef = Math.abs(coef);
					N.append(" - " + absCoef).append("*x^").append(degree);
				}
				
			}
		}
		//we return empty string if the polynomial is empty
		if (N.length() == 0) {
			return "";
		} else {
			String result = N.toString();
			return result;
		}
		
	}
	//solve method returns the root of the polynomial using newton method
	public double solve(double x0, double e, int T) throws SolutionNotFound {
		
		double xP = x0;
		
		for (int i = 0; i < T; i++) {
			double fX = eval(xP);
			Polynomial derivative = derivative();
			double fDX = derivative.eval(xP);
			if (fDX == 0) {
				 throw new SolutionNotFound("divide by zero error");
			}
			//calculations
			double xi = xP - (fX/fDX);
			//if absolute value of difference between previous x and current x is smaller than tolerance return the current x
			if (Math.abs(xi-xP) < e) {
				return xi;
			}
		xP = xi;
			
		}
		
		throw new SolutionNotFound("maximum iteration exceeded");
		
	}
}
