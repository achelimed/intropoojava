/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Patient {
	private Double masse = 0.0;
	private Double hauteur = 0.0;

	public void init(Double m, Double h) {
		if (m > 0 && h > 0) {
			masse = m;
			hauteur = h; 
		}
	}

	public void afficher() {
		System.out.printf("Patient : %.1f kg pour %.1f m\n", masse, hauteur);
	}

	public Double poids() {
		return masse;
	}

	public Double taille() {
		return hauteur;
	}

	public Double imc() {
		if (hauteur == 0) { 
			return 0.0;
		}
		return masse / (hauteur * hauteur);
	}
}	

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
