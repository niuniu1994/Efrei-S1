package Don.Entrepot;

import Don.Annexe.Etiqutte;
import Don.Archive.ArchiveEntree;
import Don.Archive.ArchiveSortie;
import Don.Don;
import Personne.Beneficiaire;
import Don.Etat;

import java.io.*;


public class DepotVente extends Destination {

    private int montant;
    static int count=0;
    private int id;

    // id de depotvent augemente automatiquement une fois on cree un nouveau.
    public DepotVente() {
        montant = 1000;
        id = ++count;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void vendre(int index, Beneficiaire beneficiaire, String dateDeRetrait){
        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();
        Don don = this.getDon(index);

        //on enleve le don de archiveEntree
        archiveEntree.remove(don);

        don.setBeneficiaire(beneficiaire);
        don.setEtat(Etat.VENDU);
        don.setDateDeRetrait(dateDeRetrait);
        don.setPlace(ArchiveSortie.getArchiveSortie().toString());
        this.remove(don);
        this.montant += don.getMontant();
        archiveSortie.add(don);

        //on ajout le don avec nouveau etat dans archiveEntree
        archiveEntree.add(don);
    }

    public void rechercherDonParEtiquette(Etiqutte typeDeMobilier){
        File file = new File("src/RDPEtiquetteDansDepotvente" + this.getId() + ".txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < this.getSize(); i++){
                if(this.getDon(i).getTypeMateriel().getEtiquette() == typeDeMobilier) {
                    System.out.println(this.getDon(i));
                    writer.write(this.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "DepotVente" + id;
    }

}
