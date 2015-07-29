## JDK 8 MOOC: Lesson 1-1 ##

## SUMMARY ##
Java update about Functional Programming in Java, Lambdas and Streams.
The goal is to understand Lambda Expression, how they can use, how to take advantage for normal tasks and data processing.
Moreover, Streams and Lambdas let us take advantage of multi core processors

## LAMBDA EXPRESSIONS ##
Java is 20 yrs old. 
Lambda expression are backed on nterfaces, thus they can be used in places where interfaces were expected. 
Moreover the new package java.util.function.
Understanding the surrounding scope for lambdas.

## WHY? ##
In Java 1.0 threading was handled by java.lang.Thread. The interaction between  thread was governed by for main methods: sleep,interrupt, wait and notify.
Later on, ni Java 1.5 java.util.concurrent was introduced to help out on the interaction between threads, using concepts like locks, mutex, semaphores.
In Java 1.6 the framework for Phasers was introduced, also 
Java 1.7 introduced  Fork/Join support, however it requires some boilerplate code to really take advantage of this features.
More recently Java 1.8 has introduced Lambdas.

## The Problem: External Iteration. ##
A inherited problem of iterating using the current structures is about how to process:
- Iteration is controlled by the code, normally in a serial process
- Not thread safe by default (shared code and variables are not ready for multiple threads)
e.g.

    List<Student> students = ....
    double highestScore = 0.0;
    for (Student s : students) {
    	if (s.getGradYear() == 2011) {
    		if (s.getScore() > highestScore)
    			highestScore = s.getScore();
    	}
    }
    
A more functional approach is based no using anonymous classes and fluent methods.
e.g.

    double highestScore = students
    	.filter ( new Predicate<Student>() {
    		public bool op (Student s) {
    			return s.getGradYear() == 2011;
    		}
    	})
    	.map( new Mapper<Student,Double>() {
    		public Double extract(Student s) {
    			return s.getScore();
    		}
    	})
    	.max();
	
This option abstracts the logic which loops over the data, and it also isolates the variables, making this approach thread safe. 
However by introducing lambdas it can be expressed with more ease since most of the code can be inferred by the compiler based on the context.

    List<Student> students = ...
    double highestScore =  students
    	.filter ( Student s -> s.getGradYear() == 2011 )
    	.map ( Student s -> s.getScore() )
    	.max();
	
This is approach is cleaner since it requires less code, it's less prone to error.
Moreover with lambda expression we can send behaviours as parameters. 