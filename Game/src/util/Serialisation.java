package util;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialisation {
	
	// pas d'instance de gson 
	// attention à la responsabilité de chacune des méthodes
	
	
	public static void ecrire (String toWrite,String file) {
		
		
		try(PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
			pw.write(toWrite);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String lire(String file) {
		byte[] in =null;
		
		try {
			in=Files.readAllBytes(Paths.get(file));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new String(in,StandardCharsets.UTF_8);
	}
	
}
