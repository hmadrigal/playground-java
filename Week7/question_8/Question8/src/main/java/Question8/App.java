package Question8;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	MongoClient c = new MongoClient(new MongoClientURI("mongodb://localhost"));
	DB db = c.getDB("test");
	DBCollection animals = db.getCollection("animals");

	BasicDBObject animal = new BasicDBObject("animal","monkey");

	animals.insert(animal);
	animal.removeField("animal");
	animal.append("animal","cat");
	animals.insert(animal);
	animal.removeField("animal");
	animal.append("animal","lion");
	animals.insert(animal);

    }
}
