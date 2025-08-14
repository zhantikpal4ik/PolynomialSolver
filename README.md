# Polynomial (Java) — Ordered Linked List + Newton Solver
A small Java library + tests that implement:
- An ordered singly linked list (generic)
- A polynomial built from monomials stored in that list
- Utilities to evaluate, differentiate, and solve P(x)=0 via Newton’s method
- Lightweight unit-style tests in Test.java
## Contents
- Monomial.java — (coefficient, degree) + Comparable by degree (descending)
- Node.java — generic singly linked-list node
- OrderedLinkedList.java — sorted insert, index-based get, size
- Polynomial.java — add monomials, toString, eval(z), derivative(), solve(x0, e, T)
- SolutionNotFound.java — custom exception for Newton failures
- Test.java — five sanity tests for the list behavior
## How it works
- Ordering: OrderedLinkedList<T extends Comparable<T>> keeps items sorted based on compareTo. For Monomial, compareTo is this.degree - m.degree, so higher degree comes first.

- Evaluation: eval(z) computes Σ (coef * z^degree).

- Derivative: term-wise derivative a*x^n → (a*n)*x^(n-1); ignores negative exponents.

- Root finding: solve(x0, e, T) uses Newton’s method:
```
x_{k+1} = x_k - f(x_k)/f'(x_k)

```
Stops when |x_{k+1} - x_k| < e, or throws SolutionNotFound if
derivative hits zero or max iterations are exceeded.
## Build & Run
Requires Java 8+.
```
# Compile all sources
javac *.java

# Run tests
java Test
```
Expected console output format:
```
OLL Test 01 passed
OLL Test 02 passed
OLL Test 03 passed
OLL Test 04 passed
OLL Test 05 passed
```
## Quick usage
```
// Build P(x) = 3x^3 - 2x + 5
Polynomial p = new Polynomial();
p.add(3, 3);   // 3*x^3
p.add(-2, 1);  // -2*x^1
p.add(5, 0);   // +5

System.out.println(p.toString());     // e.g., "3*x^3 - 2*x^1 + 5*x^0"
System.out.println(p.eval(2));        // evaluate at x=2

Polynomial dp = p.derivative();       // 9*x^2 - 2*x^0
System.out.println(dp.toString());

try {
    double root = p.solve(/*x0=*/1.0, /*epsilon=*/1e-6, /*maxIter=*/100);
    System.out.println("Root ≈ " + root);
} catch (SolutionNotFound e) {
    System.out.println("No solution: " + e.getMessage());
}
```
## API Overview
class Monomial implements Comparable<Monomial>

- Monomial(int coefficient, int degree)

- int getCoefficient()

- int getDegree()

- int compareTo(Monomial m) — by degree (descending)

class OrderedLinkedList<T extends Comparable<T>>

- void insert(T data) — inserts in sorted order (O(n))

- T get(int index) — O(n)

- int getSize()

class Polynomial

- void add(int coefficient, int degree) — inserts monomial (keeps order)

- Polynomial derivative() — formal derivative

- double eval(double z) — evaluate at z

- double solve(double x0, double e, int T) — Newton’s method

- String toString() — human-readable form

class SolutionNotFound extends Exception

- Thrown when Newton’s method cannot proceed:

  - Derivative is zero at an iteration (division by zero)

  - Max iterations exceeded without convergence






