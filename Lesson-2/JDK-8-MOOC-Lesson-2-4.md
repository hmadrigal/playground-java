# JDK 8 MOOC: Lesson 2-4 #

## Stream Sources ##

- There are 95 methods in 23 classes that return a Stream.
- 71 methods in 15 classes can be used as practical Stream sources.

### Collection Interface ###
**.stream()**
Provides a sequential stream of elements in the collection.

**parallelStream()**
Provides a parallel stream of elements in the collection. *Uses fork-join framework for implementation.*

### Array Class ###
**stream() // Static method**
Provides a sequential stream.  There are overloads for specific types: double, int, long and Object

### File class ###
**find (Path, BiPredicate, FileVisitOption)**
Return a Stream of File references that matches the BiPredicate

**list(Path)**
Return a Stream of the entries from a given directory

**lines(Path)**
Return a Stream of strings that are the lines read from the given file

**walk(Path,FileVisitOption)**
Return a Stream of File references walking from a given path.

**Random, ThreadLocalRandom, SplittablRandom (Classes)**
There version for ints(), doubles(), longs(). There are finite or infinite versions with or without a seed.

### JarFile / ZipFile ###
**stream()** Returns a File stream of the contest of the compressed archive.

### BufferedReader ###
**lines()** Return a stream of string that are the lines read from the input.
Pattern

**splitAsStream()**
Returns a stream  of string of matches of a pattern (like split but retuning a stream instead of an array)

### CharSequence ###
**chars()** 
An stream of the char values of the string.

**codePoints()**

### BitSet ###
**stream()**
All the different bits of the bit stream

## Stream Static Methods (Stream => IntStream, DoubleStream, LongStream) ##

**.concat(Stream,Stream)**
Concatenates two given streams and returns an empty stream.

**.empty()**
returns an empty stream

**.of (T... values)**
returns an stream of a set of values

**.range(int,int) . rangeClosed(int,int)**
returns from a initial number and an end value.

**.generate(IntSupplier), iterate(int,IntUnaryOperator)**
produces a infinite stream created by a single supplier.

**.iterate()** 
uses a seed for the interation

*
Notice that only collection class can create parallel stream directly.*