package Don.Annexe.PackageChambre;

import Don.Annexe.Chambre;
import Don.Annexe.Etiqutte;


public class Armoire extends Chambre {
    private int hauteur;
    private int largeur;
    private int longeur;

    public Armoire(int hauteur, int largeur, int longeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longeur = longeur;
        etiqutte = Etiqutte.ARMOIRE;
    }
    @Override
    public String toString() {
        return "Armoire";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
