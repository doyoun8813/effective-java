package item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {

	private String path;
	
	public FileProcessor(String path) {
		this.path = path;
	}
	
	// 템플릿 메서드
	public final int process() {
		try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
			int result = 0;
			String line = null;
			while((line = reader.readLine()) != null ) {
				result = getResult(result, Integer.parseInt(line));
			}
			return result;
		} catch (IOException e) {
			throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
		}
	}
	
	// 서브 클래스가 확장할 수 있게 만든 메서드
	protected abstract int getResult(int result, int number);
	
}
