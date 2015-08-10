JDK 8 MOOC: Lesson 3-3

Avoiding the use of 'forEach' method.

In imperative programming we are used to:
- explicit states for looping
- keep the state by using variables.

For example, to sum up a set of transactions, we could:

List<Transactions> transactions = ...
LongAdder transacionalTotal = new LongAdded(); // New class for fast read/writes in streams
transactions.stream()
	.forEach(t -> transactionalTotal.add(t.getValue()));
long total = transactionalTotal.sum();

The previous code is wrong, since transactionalTotal is modifying the state, which it is against
funcional paradigm. A more correct functional approach is:

List<Transactions> transactions = ... 
long total = transactions.stream()
	.mapToLong(t -> t.getValue())
	.sum();

For each can be used when the state should not modified, for example we would like to print
the name of the clients. 

transactions.stream()
	.forEach( t -> t.printClientName());
