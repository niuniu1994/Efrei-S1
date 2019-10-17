package Don.Annexe.PackageChambre;

import Don.Annexe.Chambre;
import Don.Annexe.Etiqutte;

public class Chevet extends Chambre {

    public Chevet() {
       this.etiqutte = Etiqutte.CHEVET;
    }

    @Override
    public String toString() {
        return "Chevet";
    }

    @Override
    public Etiqutte getEtiquette() {
        return etiqutte;
    }
}