JDK 8 MOOC: Lesson 3-5

Parallel Stram (And When not to use them)

Collection let us create streams:
- stream()
- parallelStream()

This is the only way to create a parallelStream directly. However a serial stream can be 
converted to parallel or viceversa by:
parallel()
sequential()

Keep in mind that the whole stream is either sequential or parallel, thus calling
concat() with a sequential and a parallel stream will produce a parallel stream.

Parallel streams are implemented using fork-join framework. 
By default the number of threads is based on the number of processors reported by the OS.
It can be modified by:

System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "32767"); // Max 

Keep in mind that:
'Parallel streams always need more work to process, but they might finish it more quickly'

Considerations on Parallels streams

A non-deterministic behaviour for parallel streams, will get elements in any order. 
While the deterministic will get elements in the same order each time.

	findAny() is non-deterministic for parallel streams. 
	findFirst() is deterministic for parallel streams. 

	forEach() is non-deterministic for parallel streams
	forEachOrdered() is deterministic for parallel streams

When to use parallel streams
- Think about the data structure which it is going to be the input of the stream
	e.g.
	ArayList: GOOD
	HashSet, TreeSet: OK
	LinkedList: BAD
- Think about the operations  which are going to be performed.
	e.g.
	filter() and map() are excellent (because of non-mutable state)
	sorted() and distinct() do not decompose well because of their dependency with the all data.
- Think about the size of the data to be processed.
	e.g.
	N: Size of the dataset
	Q: Cost per element thought the Stream pipeline
	NxQ: Total cost of the pipeline operations.
	The bigger the NxQ is the better a parallel stream will perform
	It is easier to know N than Q, but Q can be estimated.
	If in doubt, profile.

Do not assume that parallel stream will return a result faster, there are many thing envolved. 