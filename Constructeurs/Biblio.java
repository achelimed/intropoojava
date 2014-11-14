import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
    private String nom;
    private boolean prix;

    public Auteur(String unNom, boolean unPrix) {
        nom = unNom;
        prix = unPrix;
    }

    public String getNom() {
        return nom;
    }

    public boolean getPrix() {
        return prix;
    }
}

class Oeuvre
{
 	// Completer la classe Oeuvre ici
    private String titre;
    private Auteur auteur;
    private String langue;

    public Oeuvre(String unTitre, Auteur unAuteur, String uneLangue) {
        titre = unTitre;
        auteur = unAuteur;
        langue = uneLangue;
    }
    
    public Oeuvre(String unTitre, Auteur unAuteur) {
        this(unTitre, unAuteur, "francais");
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void afficher() {
        System.out.println(titre +", "+ auteur.getNom() +", en "+ langue +" ");
    }

}

// completer les autres classes ici
class Exemplaire {
    private Oeuvre oeuvre;

    public Exemplaire(Oeuvre uneOeuvre) {
        oeuvre = uneOeuvre;
        System.out.println("Nouvel exemplaire -> "+ oeuvre.getTitre() +
            ", "+ oeuvre.getAuteur().getNom() +
            ", en "+ oeuvre.getLangue());
    }

    public Exemplaire(Exemplaire autre) {
        oeuvre = autre.oeuvre;
        System.out.println("Copie d'un exemplaire de -> "+ oeuvre.getTitre() +
            ", "+ oeuvre.getAuteur().getNom() +", en "+ oeuvre.getLangue()); 
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void afficher() {
        System.out.println("Un exemplaire de "+ oeuvre.getTitre() +", "+ oeuvre.getAuteur().getNom() +", en " + oeuvre.getLangue());
    }
}

class Bibliotheque {
    private String nom;
    private ArrayList<Exemplaire> exemplaires;

    public Bibliotheque(String unNom) {
        nom = unNom;
        exemplaires = new ArrayList<Exemplaire>();
        System.out.println("La bibliothèque "+ nom +" est ouverte !");
    }

    public String getNom() {
        return nom;
    }

    public void stocker(Oeuvre uneOeuvre, int n) {
        for (int i = 0; i < n; i++) {
            exemplaires.add(new Exemplaire(uneOeuvre));            
        }
    }

    public void stocker(Oeuvre uneOeuvre) {
        stocker(uneOeuvre, 1);
    }

    public ArrayList<Exemplaire> listerExemplaires(String uneLangue) {
        if (uneLangue.equals("")) {
            return exemplaires;
        }
        
        ArrayList<Exemplaire> result = new ArrayList<Exemplaire>();
        for(Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre().getLangue().equals(uneLangue)) {
                result.add(exemplaire);
            }
        }
        return result;
    }

    public ArrayList<Exemplaire> listerExemplaires() {
        return listerExemplaires("");
    }

    public int compterExemplaires(Oeuvre uneOeuvre) {
        int i = 0;
        for(Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre() == uneOeuvre) {
                i++;
            }
        }
        return i;    
    }

    public void afficherAuteur(boolean avecPrix) {
        for (Exemplaire ex : exemplaires) {
            if (ex.getOeuvre().getAuteur().getPrix() == avecPrix) {
                System.out.println(ex.getOeuvre().getAuteur().getNom());
            }
        }
    }

    public void afficherAuteur() {
        afficherAuteur(true);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

