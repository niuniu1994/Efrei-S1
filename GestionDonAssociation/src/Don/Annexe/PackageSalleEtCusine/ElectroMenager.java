package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class ElectroMenager extends SalleEtCusine {

    private int hauteur;
    private int largeur;
    private int longeur;

    public ElectroMenager(int hauteur, int largeur, int longeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longeur = longeur;
        this.etiqutte = Etiqutte.ELECTROMENAGER;
    }
    @Override
    public String toString() {
        return "ElectroMenager";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
