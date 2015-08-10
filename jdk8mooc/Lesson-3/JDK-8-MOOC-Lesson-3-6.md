JDK 8 MOOC: Lesson 3-6

Debugging Lambdas and Streams

From the developer point of view, lambdas make the code clearer and more easy to understand.
However, is bad for debugging
	- a lot happens in internal libraries
	- There is not possible to set breakpoints
	- Streams operations are merged to improve efficiente (but hides what it is happening)

To find out what it is happening, we can use the peek() method.
e.g.:

List<String> sortedWords = reader.lines()
	.flatMap(line -> Stream.of(line.split(REGEX)))
	.map(String::toLowerCase)
	.distinct()
	.sort( (x,y) -> x.length() - y.length() )
	.collect( Collectors.toList() );
	
	
	
let suppose that something is failing, then we can check by using peek funciton

List<String> sortedWords = reader.lines()
	.peek(System.out::println)
	.flatMap(line -> Stream.of(line.split(REGEX)))
	.map(String::toLowerCase)
	.distinct()
	.sort( (x,y) -> x.length() - y.length() )
	.collect( Collectors.toList() );
	
Setting a breakpoint
	Using no-op lambdas. E.g.:
		List<String> sortedWords = reader.lines()
			.flatMap(line -> Stream.of(line.split(REGEX)))
			.peek(s -> s)					// set the breakpoint in here, this is a no-op lambda
			.map(String::toLowerCase)
			.distinct()
			.sort( (x,y) -> x.length() - y.length() )
			.collect( Collectors.toList() ); 

	The other thing is using method references
		Keep in mind that lambdas:
			- Are complied to invokedynamic call
			- implementation is decided at runtime
			- better chance for optimisation, makes debugging harder
		Thus, the  lambda expression can be replaced by a method:
			- Extract code from a lambda expression into a separated method
			- Replace the lambda with a method reference for the new method
			- Set breakpoints on the statements in the new method
			- Examine program state using debugger
