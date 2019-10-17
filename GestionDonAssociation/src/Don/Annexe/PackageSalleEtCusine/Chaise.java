package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Chaise extends SalleEtCusine {

    public Chaise(Etiqutte etiqutte) {
        this.etiqutte = Etiqutte.CHAISE;
    }

    @Override
    public String toString() {
        return "Chaise";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
