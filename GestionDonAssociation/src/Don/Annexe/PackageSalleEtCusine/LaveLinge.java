package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class LaveLinge extends SalleEtCusine {

    private int hauteur;
    private int largeur;
    private int longeur;

    public LaveLinge(int hauteur, int largeur, int longeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longeur = longeur;
        this.etiqutte = Etiqutte.LAVELINGE;
    }
    @Override
    public String toString() {
        return "LaveLinge";
    }

    @Override
    public Etiqutte getEtiquette() {
        return null;
    }
}
