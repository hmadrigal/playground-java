JDK 8 MOOC: Lesson 1-6

Referencing external variables in Lambda Expressions

Local Variable Capture
Also refer to  'effectively final' local variables from the surrounding scope, which implies:
	- Variables which meet requirement to be effectively final variables. (i.e. assigned once)
	- Closure on values, not variables.
	
'this' on lambda expressions
- First of all 'this' refers to the enclosing object, not the lambda itself.
- 'this' is like a final predefined local. 'this' will refer to the surrounding scope.

NOTE:

class DataProcessor {
	private int currentValue;
	
	public void process() {
		DataSet myData = myFactory.getDataSet();
		myData.forEach ( d -> d.user(currentValue++) );
	}
}

As we have seen the previous code should not allow to modify 'currentValue' multiple times, b
because it won't be effectively final. However the compiler computes it as follows:

myData.forEach ( d -> d.user(this.currentValue++) );

Notice that 'this' is set only once, which makes it effectively final, 
and then thru the 'this' object the field 'currentValue' is being accessed.
Notices that the compiler may insert 'this' where required.

