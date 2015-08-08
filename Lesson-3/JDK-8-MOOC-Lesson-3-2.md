JDK 8 MOOC: Lesson 3-2
Finite and Infinite Streams

In imperative code, there are scenarios where there is a look not based on counters or 
number of elements, rather than that, they are based on conditions. Once a given condition 
has a given value, then the loop is broken.

It's possible to terminate the Stream when a given condition is met by using:
- findFirst (Predicate p)
- findAny (Predicate p)
These are terminal operators 

Sometimes we need to keep the stream as long as there are elements in the stream. 
In this case 'forEach' function is a better fit, which it will not close the stream.
e.g. a termometer reader

thermalReader.lines()
	.mapToDouble ( s -> parseDouble(s.substring(0,s.length()-1)))
	.map (t -> (( t- 32) * 5 / 9 ))
	.filter (t -> currentTemperature.equals (t))
	.peek( t -> listener.ifPresent( l -> l.temperatureChanged(t)))
	.forEach (t -> currentTemperature.set(T));
	
There is not such as 'break' statement when dealing with streams. 
Instead we can limit it by finding a given element using a predicate.
Infinite streams can be consumed by forEach method without terminating the stream itself.