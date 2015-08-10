# JDK 8 MOOC: Lesson 2-6 #

## Terminal Operators ##

They're about how to terminate the pipeline operation. It generates an explicit result or side effect.
When the terminal operator is found, then the processing is being performed.
It evaluates what needs to be done and performs decisions such as:

- Lazy evaluation
- Merge/fuse operations
- Eliminate redundant operations
- Parallel execution


## Available Terminal Operations ##

### Matching elements ###

#### findFirst(Predicate p) ####

Returns the first element which matches the predicate p. (deterministic)

#### findAny(Predicate p) ####
Works in the same way was .findFirst but for a parallel stream. (Non deterministic)

#### boolean allMatch(Predicate p) ####
Returns true if all the elements match the predicate p.

#### boolean anyMatch(Predicate p) ####
Returns true if any element match the predicate p.

#### boolean noneMatch(Predicate p) ####
Returns true if no elements match the predicate p.
		
### Collecting results ###

#### collect(Collector c) ####
Performs a mutable reduction on the stream

#### toArray() ####
Returns an array containing the elements of the stream.

### Numerical Results ###
**[1]** Returns an optional since the stream can be empty

#### count() ####
Returns the amount of elements in the stream.

#### max(Comparator c) [1] ####
Returns the maximum value of the elements in the Stream. using a comparator c
		
#### min(Comparator c) [1] ####
Returns the minimum value of the elements in the Stream. using a comparator c.

#### average() [1] ####
Returns the arithmetic mean of the stream.

#### sum () [1] ####
Returns the sum of the stream elements.

### Iteration ###
#### forEach(Consumer c) ####
Performs an action on each element of the stream

#### forEachOrdered(Consumer c) ####
Performs an action on each element of the stream, but for parallel stream ensures to keep the order.*Use cautiously because order may imply imperative style of programming.*
 
### Folding ###

#### reduce(BinaryOperator accumulator) ####
Performs a reduction on the stream using a binary operator. 
The first operator is the result of the previous evaluation, and second operator is the current element.
 
The result will be carry to the next evaluation on next element.
Returns an optional.

There are two overloads:

- One that takes an initial value (does not return an optional)
- One that takes an initial value and BiFunction (equivalent to fused map and reduce)