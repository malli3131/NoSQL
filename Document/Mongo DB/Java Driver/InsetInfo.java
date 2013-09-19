package malli.mongodb;
import com.mongodb.*;

public final class InsetInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		final String host = "localhost";
		int port = 27017;
		String database = "personInfo";
		String collection = "person";
		ContactInfo ci = new ContactInfo(host, port, database, collection);
		ci.version();
	}

}
