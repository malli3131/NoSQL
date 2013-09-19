package malli.mongodb;

public class DBInfo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		DisplayDB display = new DisplayDB();
		display.showDatabases();
	}

}
