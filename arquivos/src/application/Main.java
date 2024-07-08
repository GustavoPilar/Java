package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the folder path: ");
		String strPath = sc.nextLine();
		System.out.print("Enter the file path: ");
		String strPathFile = sc.nextLine();
		File folder = new File(strPath);
		File file = new File(strPathFile);
		File[] folders = folder.listFiles(File::isDirectory);
		// Apenas diretórios e não arquivos
		System.out.println("FOLDERS:");
		for(File f : folders) {
			if(f != null) {
				System.out.println(f);
			}
		}
		
		File[] files = folder.listFiles(File::isFile);
		// Apenas arquivos e não diretorios
		System.out.println("FILES:");
		for(File f : files) {
			System.out.println(f);
		}
		
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		System.out.println("getName: " + file.getName());
		System.out.println("getParent: " + file.getParent());
		System.out.println("getPath: " + file.getPath());
		
		
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		String path = "C:\\fileJava\\out.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			// cria/recria um arquivo com os argumentos passados
			// se eu quiser que ele mantenha o que já esta no arquivo e apenas continue na outra linha
			// basta eu usar um sobrecarga do FileWriter passando o path como o caminho e true --> FileWriter(path, true)
			
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}

}
