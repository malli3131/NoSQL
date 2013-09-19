package malli.mongodb;

//import com.mongodb.*;

public class People {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String host = "localhost";
		int port = 27017;
		MongoPeople mp = new MongoPeople(host, port);
		mp.showDatabases();
		mp.connect("chinnagudipadu", "people");
		mp.close();
	}
}
