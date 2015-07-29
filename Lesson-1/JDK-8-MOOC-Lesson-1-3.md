JDK 8 MOOC: Lesson 1-3

Lambda Expressions
- They are anonymous functions
- They are strongly type.
- La expression can be used  wherever the type is a functional interface. 
	=> This is because Java is strongly type. This means,
		This is a single abstract method type
		The lambda expression provides implementation of the abstract method.

Functional Interface Definition
(One abstract method in which the lambda expression maps to it.)

- An interface.
- Has only one abstract method. (the interface itself can contain more methods, but only one abstract)
- JDK 8 supports default method
- JDK 8 supports default methods for static class
- @FunctionalInterface is a new annotation for the compiler 
   to check that there is only one abstract method into the interface.
- boolean equals(Object obj); method does not count as abstract method for Comparator interface.
   
Default method is going to be used on old version of Java which provides an implementation 
for the interface.

e.g.
interface FileFilter { bool accept(File x); }
interface ActionListener { void actionPerformed(...); }
interface Callable<T> { T call(); }

Using a lambda expression
Variable assignment
	Callable c = () -> process();
Method parameter
	new Thread( () -> process()).start();
	

