package malli.mongodb;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class CreateDatabase {

	/**
	 * @param args
	 * @throws MongoException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, MongoException  {
		/**
		 * 
		 */
		Mongo m = new Mongo("localhost", 27017);
		DB db = m.getDB("stocks");
		DBCollection col = db.getCollection("bse");
		BasicDBObject bob = new BasicDBObject();
		bob.put("_id", "Nasdaq");
		bob.put("Google", 570);
		bob.put("Yahoo", 101);
		bob.put("New York Times", 213);
		bob.put("Citi Bank", 128);
		col.save(bob);
		System.out.println("The Mongo Database Version: " + m.getVersion());
		List<String> databases = m.getDatabaseNames();
		for(String d: databases)
		{
			System.out.println(d);
		}
		DBCursor cursor = col.find();
		System.out.println("The data from the Collection: " + col.getName());
		while(cursor.hasNext())
		{
			DBObject it = cursor.next();
			Set<String> keys = it.keySet();
			for(String key : keys)
			{
				System.out.println(key);
			}
		}
		cursor.close();
		System.out.println("Total number of Documents are: " + col.count());
		m.close();
	}
}
