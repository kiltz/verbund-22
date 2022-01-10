package basic.aufgabe2;

public class KaffeeAutomat {

	public static void main(String[] args) {
		String[] muenzen = {"1 Euro", "50 cent", "20 cent", "10 cent" , "5 cent", "2 cent", "1 cent"};

		try{
			int[] rueckgeld = rueckgeldRechnen(30, 50, "Cent");
			for (int i = 0; i < muenzen.length; i++) {
				if (rueckgeld[i] > 0) System.out.println(String.format("%s-Münze: %d Stück", muenzen[i], rueckgeld[i]));
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	static int[] rueckgeldRechnen(int preis, int summe, String muenze) throws IllegalArgumentException {
		int[] rueckgeld = {0, 0, 0, 0, 0, 0, 0};
		int[] muenzen = {100, 50, 20, 10, 5, 2, 1};
		boolean check = true;

		if (muenze.equalsIgnoreCase("cent")) {
			check = false;
			for (int m = 1; m < muenzen.length; m++) {
				if (summe == muenzen[m]) check = true;
			}
		}

		if (!check || summe > 2 && muenze.equalsIgnoreCase("euro"))
			throw new IllegalArgumentException("Solche Münze existiert nicht!");

		switch (muenze.toLowerCase()) {
			case "euro":
				summe *= 100;
				break;
			case "cent":
				break;
			default:
				throw new IllegalArgumentException("Falshe eingabe!");
		}

		if (summe < preis || preis <= 0) throw new IllegalArgumentException("Summe ist zu klein!");

		summe -= preis;
		int temp;

		for (int i = 0; i < muenze.length()-1; i++) {
			temp = summe/muenzen[i];
			if (temp > 0) {
				rueckgeld[i] += temp;
				summe -= muenzen[i] * temp;
			}
		}
		return rueckgeld;
	}
}
