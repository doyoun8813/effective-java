package item8.autoclosable;

import java.io.BufferedInputStream;
import java.io.IOException;

public class AutoClosableIsGood implements AutoCloseable {

	private BufferedInputStream inputStream;
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("fail to close " + inputStream);
		}
		
	}

	
}
