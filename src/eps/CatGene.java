package eps;

public class CatGene {
	public int index = 0;

	public String contents = ""; // contents across all cats.
	public int pCount = 0, qCount = 0;
	public double p = 0, q = 0;
	public int smallHomoGoats = 0, bigHomoGoats = 0, heteroGoats = 0;
	public String[] cats = new String[logic.POPULTIONSIZE - 1]; // should be -1 i think but time will tell

	public CatGene(int a, String b) {
		index = a;
		contents = b + " ";
		for (int i = 0; i < contents.length(); i++) {
			if (contents.charAt(i) == ',')
				;
			else if (Character.isUpperCase(contents.charAt(i))) {
				pCount++;
			}
		}
		qCount = (2 * logic.POPULTIONSIZE) - pCount;
		p = (pCount / 2.0 * logic.POPULTIONSIZE);
		q = (qCount / 2.0 * logic.POPULTIONSIZE);
		switch (contents.length() % 3) {
		case 0:
			for (int j = 0; j < contents.length() / 3 - 1; j++) {
				cats[j] = contents.substring((j * 3), (j * 3) + 2);
			}
			break;
		case 1:
		default:
			System.out.println("Error reading csv file, cant find genes amidst commas. ");
			System.exit(0);
			break;
		}
		for (int k = 0; k < cats.length; k++) {
			if (Character.isUpperCase(cats[k].charAt(0)) && Character.isUpperCase(cats[k].charAt(1))){
				bigHomoGoats++;
			} else if (Character.isLowerCase(cats[k].charAt(0)) && Character.isLowerCase(cats[k].charAt(1))){
				smallHomoGoats++;
			} else {
				heteroGoats++;
			}
		}
		
	}

}
