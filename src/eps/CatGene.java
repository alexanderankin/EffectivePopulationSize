package eps;

public class CatGene {
	public int index = 0;

	public String contents = ""; // contents across all cats.
	public String[] cats = new String[logic.POPULTIONSIZE]; // should be -1 i think but time will tell
	public int pCount = 0, qCount = 0;
	public double p = 0, q = 0;
	public int smallHomoGoats = 0, bigHomoGoats = 0, heteroGoats = 0; // freq aa AA Aa
	public double bigF = 0.0;

	public CatGene(int a, String b) {
		index = a;
		contents = b;

		for (int i = 0; i < contents.length(); i++) {
			if (contents.charAt(i) == ',') {
				;
			} else if (Character.isUpperCase(contents.charAt(i))) {
				pCount++;
			}
		}

		cats = contents.split(",");

		for (int j = 0; j < cats.length; j++) {
			if (Character.isUpperCase(cats[j].charAt(0)) && Character.isUpperCase(cats[j].charAt(1))) {
				bigHomoGoats++;
			} else if (Character.isLowerCase(cats[j].charAt(0)) && Character.isLowerCase(cats[j].charAt(1))) {
				smallHomoGoats++;
			} else {
				heteroGoats++;
			}
		}

		qCount = (2 * logic.POPULTIONSIZE) - pCount;
		p = (pCount / (2.0 * logic.POPULTIONSIZE));
		q = (qCount / (2.0 * logic.POPULTIONSIZE));

		bigF = 1 - (heteroGoats) / (logic.POPULTIONSIZE * 2 * p * q);
		System.out.println(bigF);
	}
}