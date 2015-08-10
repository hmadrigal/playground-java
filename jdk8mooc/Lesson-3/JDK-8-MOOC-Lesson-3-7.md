JDK 8 MOOC: Lesson 3-7

Course Conclusions

Lambda Expressions
	- Give a simpel way for express behaviour which can be pass to methods as variables.
	- They can be used in a place where a variable is used.
	- They are backed on funcional interface.

Stream API
	- A way to have a pipeline of operations to process collection of data.
	- Java 8 provides many sources not only the collection API
	- They can be parallel or sequential. 
	- The stream pipeline has: Source, Intermediate operations, and terminal operations.
	- Terminal operations often return an 'Optional'

Lambdas And Streams
Now with Lambdas and Stram API bring support to functional style programming to Java 8.
- Need to think in functional rather than imperative
- Thi how to approach problem using recursion (rather than explicit loops, avoiding forEach)
- Streams can be infinite 
- Remember, parallel stream always involve more work, thus not always will be the faster