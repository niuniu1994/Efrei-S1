package Don.Annexe.PackageSalleEtCusine;

import Don.Annexe.Etiqutte;
import Don.Annexe.SalleEtCusine;

public class Couvert extends SalleEtCusine {

    public Couvert(Etiqutte etiqutte) {
        this.etiqutte = Etiqutte.COUVERT;
    }

    @Override
    public String toString() {
        return "Couvert";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}
