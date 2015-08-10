JDK 8 MOOC: Lesson 3-1

Advanced Lambda expression and Stream options

Taking advantage of:
- Reductions
- Finite vs Infinite streams
- Avoid using 'forEach' method
- Using collectors
- Parallel streams
- Debugging streams and lambdas
- Course conclusions



Understanding and Using reductions
For example, try to find the length of the longest line in a given text file by:

Path input = Paths.get("lines.txt");

int longestLineLength = Files.lines(input)
	.mapToInt(String::length)
	.max()
	.getAsInt();

but if the problem changes to: 

 try to find the longest line in a given text file by:
 
 String longest = Files.lines(input)
 	.sort( (x,y) -> y.length() -  x.length())
 	.findFirst()
 	.get();
 	
Both implementations resolve the issue, but load all the lines in memory, this implies
bigger files will consume more resources. This may potentially a problem:
In a traditional scheme, we could do the work serially by:

String longest = "";
while ( (String s = reader.readLine()) != null )
	if (s.length() > longest.length())
		longest = s;

OK, this approach resolves the issue, but it returns to the deficiencies we had in structural paradigm
- no parallel execution (serial work)
- No thread safe since it's sharing variables among the iteration

In Functional programming iterations are done thru recursion, thus an possible options looks like:

String findLongestString (String s, int index, List<String> l) {
	if (index >= l.size())
		return s;
	if (index == l.size() -1){
		if (sl.length() > l.get(index).length()){
			return s;
		}
		return l.get(index);
	}
	
	String s2 =  findLongestString(l.get(index),index+1,l);
	
	if (s.length() > s2.length()) 
		return s;
	return s2;
}

List<String> lines = new ArrayList<>();
while ((String s = reader.readLine())!=null)
	lines.add(s);

String longest = findLongestString("",0,lines);

Even thought now the approach does not have mutable state and it does not have an explicit loop. 
This approach in general it not useful
since it loads all the items in memory.

Normally a solution based on stream follows (filter-map-reduce), but in this case we only take care of the reduce part. 
A reduce function, may fit well in here. 
Reduce uses a binary operator and returns a value which it will be carried as input for the next iteration.

String longestLine = Files.lines(input)
	.reduce ( (x,y) -> {
		if (x.length() > y.length())
			return x;
		return y;
	})
	.get();
	
There is still a better solution based on an specialised form of  'max()', which takes as a
comparator as parameter.

Files.lines(input)
	.max(comparingInt(String::length))
	.get();
	
take into account that 'comparingInt()' is an static method on 'Compartor', e.g.:

Comparator<T> comparingInt(ToIntFunction<? extends T> keyExtractor)

