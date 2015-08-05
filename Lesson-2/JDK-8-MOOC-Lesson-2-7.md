JDK 8 MOOC: Lesson 2-7

The Optional Class (only for Java8)
There are scenarios when producing elements for the stream can hold null values. 
If the code is not ready for handling null values, then NullPointerExceptions may be thrown.

e.g.
// This code is not validating possible null values, and it's exposed to NullPointerExceptions.
String direction = gpsData.getPosition().getLatitude().getDirection();

e.g.
// This code validates possible null values, but it's a lot of code which repeat itself
String direction = "UNKNOWN";
if (gpsData!=null) {
	Position p = gpsData.getPosition();
	if (p!=null) {
		Latidude latitude = p.getLatitude();
		if (latitude != null) {
			direction = latitude.getDirection();
		}
	}
}

Optional<T> is a container for an object reference. It can be like an stream of 0 or 1 elements.
Preventing NullPointerExceptions when possible, for example:

=> .ifPresent()
// old
if (x != null) {
	print(x);
}

// new
opt.ifPresent(x -> print(X));
opt.ifPresent(this::print);

=> .filter()
// old 
if (x != null && x.contains("a")) {
	print(x);
}
// new 
opt
	.filter(x -> x.contains("a"))
	.ifPresent(this::print);
=> .map()
// old
if (x != null) {
	String t = x.trim();
	if (t.length() > 0) {
		print(t);
	}
}
// new 
opt
	.map(String::trim)
	.filter(t -> t.length() > 0)
	.ifPresent(this::print);

=> .flatMap()
// Old
public String findSimilar(String s);
// New
Optional<String> tryFindSimilar(String s)
// --- Now suppose that we perform --
Optional<Optional<String>> bad = opt.map(this::tryFindSimilar);	// This will return a Optional wrapped into an Optional, which it's bad.
Optional<String> similar = opt.flatMap(this::tryFindSimilar);	// flatMap will flat the nested streams into one single output stream.

Lets see the final GPS Code example:

class GPSData {
	public Optional<Position> getPosition() { ... }
}
class Position {
	public Optional<Latitude> getLatitude() { ... }
}
class Latitude {
	public String getDirection() { ... }
}

String direction = Optional
	.ofNullable(gpsData)				// Creates a Optional wrapper from a object reference 
	.flatMap(GPSData::getPosition)      // FlatMap is used because getPosition returns an Optional (Stream)
	.flatMap(Position::getLatitude)     // FlatMap is used because getLatitude returns an Optional (Stream)
	.map(Latitude::getDirection)        // Gets the direction of the each given latitude.
	.orElse("none");                    // If none is available, then "none" text is returned
	