package malli.mongodb;
import com.mongodb.*;

public class ContactInfo {
private Mongo mongo = null;
private DB db = null;
private DBCollection dbc = null;
public ContactInfo(String host, int port, String db, String col) throws Exception
{
	mongo = new Mongo(host, port);
	this.db = mongo.getDB(db);
	dbc = this.db.getCollection(col);
}
public void version()
{
	System.out.println("The MongoDB Version is: " + mongo.getVersion());
}
}
