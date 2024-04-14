package LinkedList;
class Link{
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd){
        iData = id ;
        dData = dd ;
        next = null;
    }
    public void displayLink(){
        System.out.print(STR."{\{iData}, \{dData}} ");    }
}
class LinkList{
    private Link first;
    public LinkList(){
        first = null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertFirst(int id, double dd){
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
        Link temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp;                // return deleted link
    }
    public Link deleteLast(){
        if (first == null) {
            // List is empty, nothing to delete
            return null;
        } else if (first.next == null) {
            // List has only one node, delete it
            Link deletedNode = first;
            first = null;
            return deletedNode;
        } else {
        Link current = first;
            while( current.next.next!= null){
                current = current.next;
            }
        Link temp = current.next;
        current.next = null;
        return temp;

        }
    }
    public void displayList()
    {
        System.out.print("List (first-->last): \n");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println(" ");
    }
    public Link find(int key){
        Link current = first;
        while(current.iData != key){
            if(current.next == null){
                return null;
            }else current = current.next;
        }
        return current;
    }
    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.iData != key){
            if(current.next == null){
                return null;
            }else {
                previous = current;
                current = current.next;
            }
        } if(current == first){
            first = first.next;
        } else previous.next = current.next;
        return current;
    }
}

class LinkedList2App {
    public static void main(String[] args){
        LinkList linkList = new LinkList();
        linkList.insertFirst(22,2.99);
        linkList.insertFirst(44,4.99);
        linkList.insertFirst(66,6.99);
        linkList.insertFirst(88,8.99);

        linkList.displayList();

        Link f = linkList.find(44);
        if( f!=null) System.out.println(STR."Found link with key \{f.iData}");
        else System.out.println("Can't fink link");

        Link d = linkList.delete(66);
        if( d!=null) System.out.println(STR."Deleted link with key \{d.iData}");
        else System.out.println("Can't delete link");

        linkList.displayList();

    }
}
public class LinkedListApp {

    public static void main(String[] args){
        LinkList theList = new LinkList();  // make new list
        theList.insertFirst(22, 2.99);      // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();              // display list
        while( !theList.isEmpty() )         // until it’s empty,
        {
            Link aLink = theList.deleteFirst();   // delete link
            System.out.print("Deleted ");         // display it
            aLink.displayLink();
            System.out.println(" ");
        }
        theList.displayList();              // display list
    }
}
