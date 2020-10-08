/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-08
 * Time:10:41
 **/
public class TestDemo {
public static Node getInterSection(Node headA,Node headB){
    Node pl = headA;
    Node ps = headB;
    int lengthA = 0;
    int lengthB= 0;
    while(pl != null){
        lengthA++;
        pl = pl.getNext();
    }
    while (ps != null){
        lengthB++;
        ps = ps.getNext();
    }
    pl = headA;
    ps = headB;
    int ret = lengthA-lengthB;
    if (ret < 0){
        pl = headB;
        ps = headA;
        ret = lengthB-lengthA;
    }

    while(ret > 0){
        pl = pl.getNext();
        ret--;
    }
    while (ps != pl && pl != null && ps != null){
        pl = pl.getNext();
        ps = ps.getNext();
    }
    if (pl == ps && pl != null){
        return ps;
    }
    return null;
}


    public static void main(String[] args) {

    }
}
