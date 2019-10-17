package Don;

public enum Etat {
   STOCKE("Stocke"),VENDU("Vendu"),DONNEE("Donne");

   private String s;
   private Etat(String s){
       this.s = s;
   }

    @Override
    public String toString() {
        return s;
    }
}
