package Don;

import Don.Annexe.Mobilier;
import Don.Archive.ArchiveEntree;
import Don.Archive.ArchiveSortie;
import Don.Entrepot.*;
import Personne.Aderent;
import Personne.Beneficiaire;
import java.util.Scanner;

public class Don {

    private String dateDedeReception;
    private String dateDeRetrait;
    private Mobilier typeMateriel;
    private String reference;
    private String nom;
    private String telephone;
    private String adress;
    private String description;
    private Etat etat;
    private String place;
    private Aderent traiteur;
    private Aderent donnateur;
    private double montant;
    private Beneficiaire beneficiaire;
    private Traitement traitement;

    public Don(String date, Mobilier typeMateriel, String reference, String description, Aderent donnateur) {
        this.dateDedeReception = date;
        this.typeMateriel = typeMateriel;
        this.reference = reference;
        this.nom = donnateur.getNom();
        this.telephone = donnateur.getTelephone();
        this.adress = donnateur.getAdress();
        this.description = description;
        this.donnateur = donnateur;
        dateDeRetrait = null;
        montant = 0;
        traiteur = null;
        beneficiaire = null;
        traitement = null;
        etat = null;

    }

    //fonction pour transferer les dons accept
    public void setDestination(Destination destination, Aderent traiteur) {
            this.traitement = Traitement.ACCPTE;
            if (destination instanceof DepotVente) {
                this.etat = Etat.STOCKE;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrer montant de don,s'il te plait");
                int x = scanner.nextInt();
                this.montant = x;
                if (((DepotVente) destination).getMontant() - x > 0) {
                    ((DepotVente) destination).setMontant(((DepotVente) destination).getMontant() - x);
                } else {
                    System.out.println("ce depot-vente n'a pas assez budget");
                    return;
                }
                this.place = destination.toString();
                this.traiteur = traiteur;
                destination.add(this);
                ArchiveEntree.getArchiveEntree().add(this);
            } else if (destination instanceof Association) {
                this.place = destination.toString();
                this.traiteur = traiteur;
                destination.add(this);
                ArchiveEntree.getArchiveEntree().add(this);
            } else if (destination instanceof GardeMeuble) {
                this.etat = Etat.STOCKE;
                this.place = destination.toString();
                this.traiteur = traiteur;
                destination.add(this);
                ArchiveEntree.getArchiveEntree().add(this);
            } else if (destination instanceof MaisonDonnateur){
                this.place = destination.toString();
                this.traiteur = traiteur;
                destination.add(this);
            }
    }

    //overwrite, c'est pour les dons refuse;
    public void setDestination() {
            this.traitement = Traitement.REFUSEE;
            ArchiveSortie.getArchiveSortie().add(this);
            System.out.println("la fonction ne peut pas traite des dons refuses");
    }

    @Override
    public String toString() {
        return typeMateriel + ";" + reference + ";" + nom + ";" + telephone +
                ";" + adress + ";" + description + ";" + traiteur.getNom() + ";" + etat + ";" + place
               + ";" + montant + ";" + dateDedeReception + ";" + dateDeRetrait;
    }


    public String getDateDedeReception() {
        return dateDedeReception;
    }

    public Mobilier getTypeMateriel() {
        return typeMateriel;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdress() {
        return adress;
    }

    public String getDescription() {
        return description;
    }

    public Etat getEtat() {
        return etat;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public String getPlace() {
        return place;
    }

    public Aderent getDonnateur() {
        return donnateur;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public String getDateDeRetrait() {
        return dateDeRetrait;
    }

    public double getMontant() {
        return montant;
    }

    public Aderent getTraiteur() {
        return traiteur;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public void setDateDeRetrait(String dateDeRetrait) {
        this.dateDeRetrait = dateDeRetrait;
    }
}