package malli.mongodb;
import com.mongodb.*;

public class DropDatabase {

	/**
	 * @param args
	 * This code is used to Drop databases.
	 */
	public static void main(String[] args) throws Exception {
		//Connect The Mongo Server by using hostname and its Port
		Mongo mongo = new Mongo("localhost", 27017);
		//Choose the database to delete
		DB db = mongo.getDB("stocks");
		db.dropDatabase();
	}
}
