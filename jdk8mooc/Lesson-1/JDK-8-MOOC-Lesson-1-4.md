# JDK 8 MOOC: Lesson 1-4 #

## New interfaces in: java.util.function package ##

This new package adds general purpose functional interfaces.
They're used heavily in Java class libraries. 

### Consumer<T> ###
An operation which takes a single value and consumes it. It does not return any value.
There is a variation called BiConsumer<T,U> which takes two values as input. 
e.g.:
String s -> System.out.println(s)

**Default methods:**
- andThen : for composing

### Supplier ###
Does not take a parameter and it returns a value. 
e.g.:
() -> createLogMessage()

### Function<T,R> ###
Take one argument, does something and returns a result. Also there is a BiFunction<T,U,R>
e.g.:

String s -> s.getName()

**Default methods:**
- compose : 
- andThen : for composing

### UnaryOperator<T> ###
Specific type of function where the returned value is as the same type of the inputted parameter.
e.g.:

### T apply (T a) ###
String s -> s.toLowerCase()

### BinaryOperator<T> ###
T apply(T a, T b)

(String x, String y) ->  x.length() > y.length() ? x : y 

### Predicate (or BiPredicate) ###
A function which always returns a boolean.
 
**Default methods:**
- and()      
- or()
- negate()
- isEqual()

