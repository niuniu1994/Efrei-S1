package Don.Archive;


import Don.Don;

import java.util.LinkedList;

//pareil comme Destination
public abstract class Archive {

    private LinkedList<Don> linkedList ;

    public Archive() {
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
