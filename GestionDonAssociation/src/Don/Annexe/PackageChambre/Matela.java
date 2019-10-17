package Don.Annexe.PackageChambre;

import Don.Annexe.Chambre;
import Don.Annexe.Etiqutte;

public class Matela extends Chambre{
    private int largeur;
    private int longeur;
    private int hauteur;

    public Matela(int hauteur, int largeur, int longeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longeur = longeur;
        etiqutte = Etiqutte.MATELA;
    }

    @Override
    public String toString() {
        return "Matela";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
