package malli.mongodb;
import com.mongodb.*;
import java.util.*;

public class MongoPeople {
	private String host = "";
	private int port;
	private Mongo mongo = null;
	private DB database = null;
	private DBCollection collection = null;
	
	
	public MongoPeople(String host, int port) throws Exception
	{
		this.host = host;
		this.port = port;
		mongo = new Mongo(this.host, this.port);
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void showDatabases() throws Exception
	{
		//Mongo mongo = new Mongo(host, port);
		System.out.println("#####################################");
		System.out.println("#              DATABASES            #");
		System.out.println("#####################################");
		List<String> dbs = mongo.getDatabaseNames();
		for(String db : dbs)
		{
			System.out.println(db);
		}
		System.out.println("--------------------------------------");
	}
	public void connect(String db, String col) throws Exception
	{
		database = mongo.getDB(db);
		collection = database.getCollection(col);
		System.out.println("Now You are using the Collection " + collection + " from Database " + database);
	}
	public void close()
	{
		mongo.close();
	}
}
