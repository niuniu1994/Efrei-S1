package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Vaisselle extends SalleEtCusine {

    private int nombre;

    public Vaisselle(int nombre){
        this.nombre = nombre;
        this.etiqutte = Etiqutte.VAISEELE;
    }

    @Override
    public String toString() {
        return "Vaiselle Nombre: " + nombre;
    }

    public int getNombre() {
        return nombre;
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
