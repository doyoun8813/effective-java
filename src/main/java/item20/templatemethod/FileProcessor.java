package item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {

	private String path;
	
	public FileProcessor(String path) {
		this.path = path;
	}
	
	// ���ø� �޼���
	public final int process() {
		try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
			int result = 0;
			String line = null;
			while((line = reader.readLine()) != null ) {
				result = getResult(result, Integer.parseInt(line));
			}
			return result;
		} catch (IOException e) {
			throw new IllegalArgumentException(path + "�� �ش��ϴ� ������ �����ϴ�.", e);
		}
	}
	
	// ���� Ŭ������ Ȯ���� �� �ְ� ���� �޼���
	protected abstract int getResult(int result, int number);
	
}
