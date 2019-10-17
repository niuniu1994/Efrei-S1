package Don.Archive;


//En génie logiciel, le singleton est un patron de conception (design pattern)
// dont l'objectif est de restreindre l'instanciation d'une classe à un seul objet
public class ArchiveEntree extends Archive {

    // il va appler le constructeur de son pere;
    private static ArchiveEntree archiveEntree = new ArchiveEntree();

    private ArchiveEntree() {
    }

    public static ArchiveEntree getArchiveEntree(){
        return archiveEntree;
    }

    @Override
    public String toString(){
        return "ArchiveEntree";
    }

}
