package malli.mongodb;
import java.util.List;

import com.mongodb.*;

public class MongoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Mongo mongo = new Mongo("localhost", 27017);
		System.out.println("#####################################");
		System.out.println("#              DATABASES            #");
		System.out.println("#####################################");
		System.out.println("The Mongo DB Version is: "+ mongo.getVersion());
		//System.out.println(mongo.getDB("Chinnagudipadu"));
		List<String> dbs = mongo.getDatabaseNames();
		for(String db : dbs)
		{
			System.out.println(db);
		}
		System.out.println("--------------------------------------");
	}
}
