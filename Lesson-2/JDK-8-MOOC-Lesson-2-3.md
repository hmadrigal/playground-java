JDK 8 MOOC: Lesson 2-3
Streams of objects and streams of primitive types.

THE FACT
Java Language is not completely object oriented. Primitive types (such as byte, short, int , long, double, float and char)
aren't objects. Java provides wrappers for the to deal with them as objects.
In later versions of java, conversion from wrapper to primitive and vice versa are handled by the auto-boxing and unboxing features.

THE PROBLEM
The problem raises between sharing that through the pipeline conversions to and from wrappers and primitive may happen, this 
may potentially may imply a lot of work, creating and destroying objects.

int highScore = students.stream()
	.filter ( s -> s.graduationYear() == 2015)
	.map (s -> s.getScore())  // This line creates wrappers for all the int because this is an object stream.
	.max();		// This line will unbox all the int because it is needed to perform the max computation.

THE SOLUTION
Because of this issue, Java provides some specific streams which helps to prevent the extra necessary work when working int the pipeline.
- IntStream	    => stream.mapToInt()
- DoubleStream	=> stream.mapToDouble()
- LongStream	=> stream.mapToLong()

Object Streams
By default everything in the pipeline is an object. For example:

int highScore = students.stream()
	.filter ( s -> s.graduationYear() == 2015)
	.mapToInt (s -> s.getScore())  // This will produce a IntStream which prevent the auto-boxing from happening. 
	.max();			// This won't unbox since the IntStream can provide the value without unboxing.
	
