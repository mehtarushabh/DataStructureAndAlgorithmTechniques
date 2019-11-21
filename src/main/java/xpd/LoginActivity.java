package xpd;
/*
 * @author: Rushabh Mehta
 * */

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity {
	String server;

	LoginActivity(String server) {
		this.server = server;
	}


	public void preLOgin() {
		HttpURLConnection connection;
		try {
			URL url = new URL(server + "/XPDOffice");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
