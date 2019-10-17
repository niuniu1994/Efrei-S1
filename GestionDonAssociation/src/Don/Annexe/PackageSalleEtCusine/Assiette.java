package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Assiette extends SalleEtCusine {

    public Assiette(Etiqutte etiqutte) {
        this.etiqutte = Etiqutte.ASSIETTE;
    }

    @Override
    public String toString() {
        return "Assiette";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
