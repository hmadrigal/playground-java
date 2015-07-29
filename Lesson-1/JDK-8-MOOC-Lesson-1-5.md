JDK 8 MOOC: Lesson 1-5

Method References
A method reference let the developer reuse a method as lambda expression.

// Normal lambda expression
FileFilter x = File f -> f.canRead();
// Using method reference
FileFilter x = File::canRead()

The compiler will take a reference to canRead from File instance and expand it, creating 
a similar estructure as it is in the normal lambda expression. 
Since methods can also be referred from:

Static method
	//lambda
	args -> ClassName.staticMethod(args)
	(String s) -> System.out.println(s);
	//Method Ref
	ClassName::staticMethod
	System.out::println
Instance method of an arbitrary type
	//lambda
	(arg0,rest) -> arg0.instanceMedhot(rest)
	(String s, int i) -> s.subString(i)
	//Method Ref
	ClassName::instanceMethod
	String::subString
Instance method of an existing object
	//lambda
	(args) -> expr.instanceMethod(args)
	Axis a -> getLength(a)
	//Method Ref
	expr::instanceMethod
	this::getLength
	
Constructor References
The same concept as method references, but for the constructor. 

	// using lambda expression
	Factory<List<String>> f = () -> return new ArrayList<String>();
	// using constructor refernce
	Factory<List<String>> f = ArrayList<String>::new;
	
