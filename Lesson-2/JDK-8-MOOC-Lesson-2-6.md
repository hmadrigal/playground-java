JDK 8 MOOC: Lesson 2-6
Terminal Operators

They're about how to terminate the pipeline operation. It generates an explicit result or side effect.
When the terminal operator is found, then the processing is being performed.
It evaluates what needs to be done and performs decisions such as:
		- Lazy evaluation
		- Merge/fuse operations
		- Eliminate redundant operations
		- Parallel execution


Available Terminal Operations

Matching elements
	.findFirst(Predicate p)
		returns the first element which matches the predicate p. (deterministic)
	.findAny(Predicate p)
		works in the same way was .findFirst but for a parallel stream. (Non deterministic)
	.boolean allMatch(Predicate p)
		return true if all the elements match the predicate p.
	.boolean anyMatch(Predicate p)
		return true if any element match the predicate p.
	.boolean noneMatch(Predicate p)
		returns true if no elements match the predicate p.
		
Collecting results
	.collect(Collector c)
		Performs a mutable reduction on the stream
	.toArray()
		Returns an array containing the elements of the stream.

Numerical Results
	[NOTE 1] Returns an optional since the stream can be empty
	.count() 
		returns the amount of elements in the stream.
	.max(Comparator c) [NOTE 1]
		returns the maximum value of the elements in the Stream. using a comparator c
		
	.min(Comparator c) [NOTE 1]
		returns the minimum value of the elements in the Stream. using a comparator c.
		Returns an optional since the stream can be empty
	.average() [NOTE 1]
		return the arithmetic mean of the stream.
	.sum () [NOTE 1]
		return the sum of the stream elements.
Iteration
	.forEach(Consumer c)
		Performs an action on each element of the stream
	.forEachOrdered(Consumer c)
		Performs an action on each element of the stream, but for parallel stream ensures to keep the order.
		Use cautiously because order may imply imperative style of programming. 
Folding
	.reduce(BinaryOperator accumulator)
		Performs a reduction on the stream using a binary operator. 
		The first operator is the result of the previous evaluation, and second operator is the current element. 
		The result will be carry to the next evaluation on next element.
		Returns an optional.
		There are two overloads:
			- One that takes an initial value (does not return an optional)
			- One that takes an initial value and BiFunction (equivalent to fused map and reduce)
		