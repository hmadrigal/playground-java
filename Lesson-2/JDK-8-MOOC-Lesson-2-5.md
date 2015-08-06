# JDK 8 MOOC: Lesson 2-5 #

## Stream Interface: Intermediate Operations ##

Most of the intermediate operations:

- Work an either sequential or parallel stream.
- Accept their behaviour as parameter through lambda expressions. This implies that they're typically stateless.
- Stream may be change between parallel and sequential


## Filtering and Mapping ##
**.distinct()**
Returns an stream without duplicated element in it.

**.filter (Predicate p)**
Returns an stream in which the result of P is true

**.map(Function f)**
Returns an stream based on the result of applying F function

**.mapToInt,.mapToDouble,.mapToLong**

## Maps and FlatMaps ##

### Map ###
 
Normally an operation performs a 1-to-1 mapping by applying a function.
However, there are scenarios where the result of each mapped element may be a new stream. 

### FlatMap ###
Each element of the stream may potentially produce multiple values. (e.g. each input element may produce an stream). The FlatMap method takes all the nested streams and returns only one output stream based on all the elements (and nested elements). 
The FlatMap joins all the new elements into one single output stream. e.g.

    List<String> output = reader
    	.lines()
    	.flapMap(line -> Stream.of(line.split(REGEX))
    	.filter(word -> worl.length() > 0 )
    	.collect(Collectors.toList())


## Restricting the size of a stream ##

### skip(long n) ###
Skips n elements in the input stream

### limit(long n) ###
Returns n elements in the output stream.
		
    String output = bufferedReader
    	.lines()
    	.skip(2)
    	.limit(2)
    	.collect(Collectors.joining())

## Sorting and Unsorting ##

### sorted(Comparator c), sorted() ###
Returns a sorted output stream based on the comparator. version without parameters uses natural order.

### unordered() ###
This does not unorder the collection. 
Instead it hints the context to do not take care of the order of elements, 
this will help to improve operations such as `distinct()` or `groupingBy()`.

## Observing Stream elements ##

### peek (Consumer c) ###

Returns an output stream that it is identical to the input stream. 
Each element is passed to the accept() method of the Consumer.
Consumer does not modify the element (handy for debugging)