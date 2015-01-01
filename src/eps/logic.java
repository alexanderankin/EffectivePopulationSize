package eps;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;

public class logic {
	public static final int NUMBEROFGENES = 3;
	public static int POPULTIONSIZE = 0; // get from file method

	public static void main(String[] args) throws IOException {
		readCSV();

	}

	public static void readCSV() throws IOException {
		Scanner s;
		s = new Scanner(new File("src/bsData.csv"));
		String[] genes = new String[NUMBEROFGENES];

		for (int i = 0; s.hasNext(); i++) {
			genes[i] = s.nextLine();
		}
		s.close();
	}

}
