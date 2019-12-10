package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Prueba {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Código Postal Zitácuaro.txt");
		try(Scanner input = new Scanner(file)) {
			while(input.hasNextLine()) {
				JOptionPane.showMessageDialog(null, input.nextLine());
			}
		}
	}
}