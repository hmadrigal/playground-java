JDK 8 MOOC: Lesson 2-5

Stream Interface: Intermediate Operations

MOst of the intermediate operations:
- Work an either sequential or parallel stream.
- Accept their behaviour as parameter through lambda expressions. This implies that they're typically stateless.
- Stream may be change between parallel and sequential


Filtering and Mapping
.distinct()
	Return an stream without duplicated element in it.
.filter (Predicate p)
	Returns an stream in which the result of P is true
.map(Function f)
	Return an stream based on the result of applying F function
.mapToInt,.mapToDouble,.mapToLong

Maps and FlatMaps
Map normally an operation performs a 1-to-1 mapping by applying a function.
FlatMap
	Each element of the stream may potentially produce multiple values. (e.g. each input element may produce an stream). 
	The FlatMap joins all the new elements into one single output stream. e.g.

List<String> output = reader
	.lines()
	.flapMap(line -> Stream.of(line.split(REGEX))
	.filter(word -> worl.length() > 0 )
	.collect(Collectors.toList())


Restricting the size of a stream
	.skip(long n)
		Skips n elements in the input stream
	.limit(long n)
		returns n elements in the output stream.
		
String output = bufferedReader
	.lines()
	.skip(2)
	.limit(2)
	.collect(Collectors.joining())

Sorting and Unsorting
	.sorted(Comparator c), sorted()
		returns a sorted output stream based on the comparator. version without parameters uses natural order.
	.unordered()
		this does not unorder the collection. 
		Instead it hints the context to do not take care of the order of elements, 
		this will help to improve operations such as distinct() or groupingBy().

Observing Stream elements
	.peek (Consumer c)
		return an output stream that it is identical to the input stream. 
		Each element is passed to the accept() method of the Consumer.
		Consumer does not modify the element (handy for debugging)