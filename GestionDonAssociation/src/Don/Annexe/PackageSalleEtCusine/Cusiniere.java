package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Cusiniere extends SalleEtCusine {

    private int nombre;
    private int puissance;


    public Cusiniere(int nombre, int puissance){
        this.nombre = nombre;
        this.puissance = puissance;
        this.etiqutte = Etiqutte.CUSINIERE;
    }

    @Override
    public String toString() {
        return "Cusiniere{" + "nombre de plaque =" + nombre + ", puissance =" + puissance + "w" + '}';
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
