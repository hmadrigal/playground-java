JDK 8 MOOC: Lesson 1-7

Useful New methods in JDK 8 That can use Lambdas

Iterable.forEach(Consumer c)
e.g.
	List<string> myList = ...
	myList.forEach( s -> System.out.println(s));

Collection.removeIf(Predicate p)
e.g.
	List<string> myList = ...
	myList.removeIf( s -> s.length() == 0 );

List.replaceAll(UnaryOperator o)
	List<string> myList = ...
	myList.replaceAll(s -> s.toUpperCase() );

List.sort(Comparator c) // meant to replace Collections.sort(List l, Comparator c)
	List<String> myList = ...
	myList.sort( (x,y) -> x.length() - y.length() )

logger class has been modified to accept lambdas as parameters in order to invoke
the methods when needed rather than always being called and send the values as parameters.
 