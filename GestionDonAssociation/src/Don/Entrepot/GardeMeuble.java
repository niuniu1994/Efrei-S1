package Don.Entrepot;

import Don.Annexe.Etiqutte;
import Don.Archive.ArchiveEntree;
import Don.Archive.ArchiveSortie;
import Don.Don;
import Personne.Beneficiaire;
import Don.Etat;

import java.io.*;

public class GardeMeuble extends Destination {

    private static GardeMeuble gardeMeuble = new GardeMeuble();

    private  GardeMeuble(){
    }

    public static GardeMeuble getGardeMeuble(){
        return gardeMeuble;
    }

    public void donner(int index,Beneficiaire beneficiaire, String dateDeRetrait){
        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();

        Don don = getDon(index);
        //on enleve le don de archiveEntree
        archiveEntree.remove(don);


        don.setBeneficiaire(beneficiaire);
        don.setEtat(Etat.DONNEE);
        don.setPlace(ArchiveSortie.getArchiveSortie().toString());
        don.setDateDeRetrait(dateDeRetrait);

        this.remove(index);
        archiveSortie.add(don);
    }

    public static void rechercherDonParEtiquette(Etiqutte typeDeMobilier){
        File file = new File("src/RDPEtiquetteDansGardeMeuble.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < gardeMeuble.getSize(); i++){
                if(gardeMeuble.getDon(i).getTypeMateriel().getEtiquette() == typeDeMobilier) {
                    System.out.println(gardeMeuble.getDon(i));
                    writer.write(gardeMeuble.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "GardeMeuble";
    }
}
