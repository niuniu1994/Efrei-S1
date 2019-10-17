package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Refregerateur extends SalleEtCusine {

    private int hauteur;
    private int largeur;
    private int longeur;

    public Refregerateur(int hauteur, int largeur, int longeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longeur = longeur;
        this.etiqutte = Etiqutte.REFREGERATEUR;
    }
    @Override
    public String toString() {
        return "Refregerateur";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
