JDK 8 MOOC: Lesson 1-2

Lambda Expression

A lambda expression represents a method, but it's not associated to a class. 
Because of this it's called anonymous function.
A lambda expression is created by using the lambda operator: ->
at the lest side it's listed the parameters, and at the right side the lambda body.
e.g.

(parameters) -> { lambda-body }
please note:
- if there is only one parameter, the parenthesis are optional.
- if there is only one expression/statement in the lambda body, then the braces are optional
- Based on the context where the lambda expression is placed, 
  the parameter types and return type can be inferred.
e.g.
() -> System.out.println("Hello")
x -> x + 10
(int x, int y) -> { return x + y ; }
...

Lambda Expressions
	- are simple to write
	- they are still strongly type, but uses less code because of the type inference.