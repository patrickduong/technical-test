package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileUtils {
	public static void clearFolder(String path) throws IOException{
		Files.walk(Paths.get(path))
        .filter(Files::isRegularFile)
        .map(Path::toFile)
        .forEach(File::delete);
	}
	
	public static void executeCommand(String cmd) throws IOException, InterruptedException {
		String line = "";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec("cmd.exe /c "+cmd);
		pr.waitFor();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		while ((line=buffer.readLine())!=null) {
			System.out.println(line);
		}
	}
}
