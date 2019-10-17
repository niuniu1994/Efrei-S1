package Don.Archive;

//En génie logiciel, le singleton est un patron de conception (design pattern)
// dont l'objectif est de restreindre l'instanciation d'une classe à un seul objet
public class ArchiveSortie extends Archive {

    private static ArchiveSortie archiveSortie= new ArchiveSortie();

    private ArchiveSortie() {
    }

    public static ArchiveSortie getArchiveSortie(){
        return archiveSortie;
    }

    @Override
    public String toString(){
        return "ArchiveSortie";
    }
}
