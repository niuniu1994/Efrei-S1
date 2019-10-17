package Don.Entrepot;

//ce class la est en fait une "Linkedlist" qui est utilise pour stocke les object de type don;
//c-t-d on stocke tout les object don dans les Node et on les lie comme une chaine;

import Don.Don;

import java.util.LinkedList;

public abstract class Destination {

    private LinkedList<Don> linkedList ;

    public Destination() {
        linkedList = new LinkedList<Don>();
    }

    public int getSize(){
        return linkedList.size();
    }

    public Boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void add(Don don){
        linkedList.add(don);
    }

    public Don getDon(int index){
        return linkedList.get(index);
    }

    public void setDonParIndex(Don don,int index){
        linkedList.set(index, don);
    }

    public Don getDon(Don don){
        return linkedList.get(linkedList.indexOf(don));
    }

    public boolean ContainsDon(Don don){
        return linkedList.contains(don);
    }

    public Don remove(int index){
        return linkedList.remove(index);
    }

    public Don remove(Don don){
        return linkedList.remove(linkedList.indexOf(don));
    }
}
