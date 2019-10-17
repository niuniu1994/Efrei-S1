package Don;

import Don.Annexe.Etiqutte;
import Don.Annexe.PackageSalleEtCusine.*;
import Don.Archive.*;
import Don.Entrepot.Association;
import Don.Entrepot.DepotVente;
import Don.Entrepot.GardeMeuble;
import Personne.*;
import Recherche.Recherche;
import Statistique.Statisque;

import java.text.ParseException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws ParseException {

        //test pour etablier des dons et entrepots
        ArrayList<Beneficiaire> listB = new ArrayList<>();
        ArrayList<Aderent> listA = new ArrayList<>();
        ArrayList<Don> listD = new ArrayList<Don>();
        DepotVente depotVente = new DepotVente();
        DepotVente depotVente1 = new DepotVente();
        GardeMeuble gardeMeuble = GardeMeuble.getGardeMeuble();
        Beneficiaire.fileOperation("src/Beneficiaires.txt", listB);
        Aderent.fileOperation("src/Adherents.txt", listA);

        Don x = new Don("09/09/2019", new Cusiniere(3,2000), "cusiniere", "not bad",listA.get(3));
        Don x1 = new Don("09/09/2019", new Cusiniere(3,300), "cusiniere", "not bad",listA.get(3));
        Don x3 = new Don("09/09/2019", new Cusiniere(3,1000), "cusiniere", "not bad",listA.get(3));
        Don x4 = new Don("09/09/2019", new Cusiniere(3,6600), "cusiniere", "not bad",listA.get(3));
        Don x5 = new Don("09/09/2019", new Cusiniere(3,2500), "cusiniere", "not bad",listA.get(3));


        x.setDestination(depotVente,listA.get(2));
        x1.setDestination(depotVente1,listA.get(2));
        x3.setDestination(depotVente1,listA.get(2));
        x4.setDestination(gardeMeuble,listA.get(3));
        x5.setDestination(Association.getAssociation(),listA.get(3));

        //test de fonction rechecherDonParEtiquette
        depotVente1.rechercherDonParEtiquette(Etiqutte.CUSINIERE);
        System.out.println("\n");

        // test de fonction rechecherDepotVent
        Recherche.RPDepotVente(depotVente1);

        // test pour fonction Vendre et donner
        gardeMeuble.donner(0,listB.get(1),"12/10/2019");
        depotVente1.vendre(0,listB.get(2),"20/10/2019");

        for(int i = 0; i < gardeMeuble.getSize(); i++){
            System.out.println(gardeMeuble.getDon(i).getEtat());
        }

        System.out.println("\n");

        for(int i = 0; i < ArchiveSortie.getArchiveSortie().getSize(); i++){
            System.out.println(ArchiveSortie.getArchiveSortie().getDon(i).getEtat());
        }
        System.out.println("\n");

        //test pour statisque
        System.out.println(Statisque.moyenneAgeBeneficiaires(listB));

    }
}
