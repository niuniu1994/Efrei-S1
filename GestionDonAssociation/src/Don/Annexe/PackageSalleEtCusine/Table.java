package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Table extends SalleEtCusine {
    private TableType tt;
    private TableShape ts;
    private int hauteur;
    private int largeur;
    private int longeur;

    public Table(TableType tt,TableShape ts,int longeur, int largeur, int hauteur) {
        this.tt = tt;
        this.ts = ts;
        this.largeur = largeur;
        this.longeur = longeur;
        this.hauteur = hauteur;
        this.etiqutte = Etiqutte.TABLE;
    }

    @Override
    public String toString() {
        return "Cusiniere{" + "Table Type =" + tt + ", Table Shape=" + ts  + '}';
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
