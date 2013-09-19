package malli.mongodb;
import com.mongodb.*;
import java.util.*;

public class DisplayDB {
	private String host = "localhost";
	private int port = 27107;
	private Mongo mongo = null;
	public DisplayDB() throws Exception
	{
		mongo = new Mongo(host, port);
	}
	public void showDatabases() throws Exception
	{
		System.out.println("#####################################");
		System.out.println("#              DATABASES            #");
		System.out.println("#####################################");
		System.out.println("The Mongo DB Version is: "+ mongo.getVersion());
		System.out.println(mongo.getDB("Chinnagudipadu"));
		List<String> dbs = mongo.getDatabaseNames();
		for(String db : dbs)
		{
			System.out.println(db);
		}
		System.out.println("--------------------------------------");
	}
}
