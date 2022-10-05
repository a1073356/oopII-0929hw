import java.util.*;

class ticketClass implements Runnable{

    static int ticket=10000;
    int tticket;
    Thread t;

    ticketClass(String name){
        tticket=0;
        t= new Thread(this, name);
        t.start();
    }

    public void run(){
        
        while(grabticket()==true){
            tticket++;
        }
        System.out.println(t.getName()+"總共賣出"+tticket+"票");
    }
    synchronized private static boolean grabticket(){
        if(ticket>0){
            ticket--;
            return true;
        }else{
            return false;
        }
    }

}
public class ticket_hw{
    public static void main(String[] args){

        ticketClass tA=new ticketClass("機器A");
        ticketClass tB=new ticketClass("機器B");
        ticketClass tC=new ticketClass("機器C");
        ticketClass tD=new ticketClass("機器D");
        
    }
}
