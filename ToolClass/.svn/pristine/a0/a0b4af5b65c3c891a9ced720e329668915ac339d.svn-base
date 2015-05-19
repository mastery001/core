package tool.mastery.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
	
	public static void close(InputStream is) {
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				is = null;
			}
		}
	}
	
	public static void close(OutputStream os) {
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				os = null;
			}
		}
	}
}
