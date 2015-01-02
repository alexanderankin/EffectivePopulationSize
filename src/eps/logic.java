package eps;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class logic {
	public static final int NUMBEROFGENES = 3; // must change in THIS file
	public static int POPULTIONSIZE = 0; // get from file method

	public static String[] genes = new String[NUMBEROFGENES];

	public static void main(String[] args) throws IOException {
		readCSV();
		createGenes();
	}

	public static void readCSV() throws IOException {
		Scanner s;
		s = new Scanner(new File("src/bsData.csv"));

		for (int i = 0; s.hasNext(); i++) {
			genes[i] = s.nextLine();
		}
		POPULTIONSIZE = (genes[0].length() / 3) + 1; //is 11
		s.close();
	}

	public static void createGenes() {
		List<CatGene> catgenes = new ArrayList<CatGene>();
		int j = 0;
		while (j < NUMBEROFGENES) {
			catgenes.add(new CatGene(j, genes[j]));
			j++;
		}
	}
}
