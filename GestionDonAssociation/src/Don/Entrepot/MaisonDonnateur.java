package Don.Entrepot;


import Don.Annexe.Etiqutte;
import Don.Archive.ArchiveEntree;
import Don.Archive.ArchiveSortie;
import Don.Don;
import Personne.Beneficiaire;
import Don.Etat;

import java.io.*;

public class MaisonDonnateur extends Destination {
    private static MaisonDonnateur maisonDonnateur = new MaisonDonnateur();

    private MaisonDonnateur(){

    }

    public static MaisonDonnateur getMaisonDonnateur(){
        return maisonDonnateur;
    }

    public  void donner(int index, Beneficiaire beneficiaire, String dateDeRetrait){

        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();
        Don don = this.getDon(index);

        //on enleve le don de archiveEntree
        archiveEntree.remove(don);

        don.setBeneficiaire(beneficiaire);
        don.setEtat(Etat.DONNEE);
        don.setPlace(ArchiveSortie.getArchiveSortie().toString());
        don.setDateDeRetrait(dateDeRetrait);

        this.remove(index);
        archiveSortie.add(don);
        archiveEntree.add(don);
    }

    public static void rechercherDonEtiquette(Etiqutte typeDeMobilier){
        File file = new File("src/RDPEtiquetteDansMaison.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < maisonDonnateur.getSize(); i++){
                if(maisonDonnateur.getDon(i).getTypeMateriel().getEtiquette() == typeDeMobilier) {
                    System.out.println(maisonDonnateur.getDon(i));
                    writer.write(maisonDonnateur.getDon(i).toString() + "\r\n");
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
        return "MaisonDonnateur";
    }
}
