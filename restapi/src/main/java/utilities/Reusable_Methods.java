package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reusable_Methods 
{
	public static String convertRawJsonToString(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
