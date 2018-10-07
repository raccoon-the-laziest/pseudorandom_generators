package lab1;

import java.util.ArrayList;

public class Volfram extends Generator{
    private int state;
    Volfram(int state)
    {
        this.state=state;
        this.type="bit";
    }
    int getNewBit()
    {
        int x=state&1;
        state=leftShift(state)^(state|rightShift(state));
       // System.out.println(x);
        return x;
    }
    int rightShift(int n)
    {
        int bit=n&1;
        n=n>>>1;
        n=n|(bit<<31);
        return n;
    }
    int leftShift(int n)
    {
        //System.out.println("n" +Integer.toBinaryString(n));
       int bit=(n&0b10000000000000000000000000000000)>>>31;
    //    System.out.println("bit"+bit);
       n=n<<1;
       n=n|bit;
     //   System.out.println("n" +Integer.toBinaryString(n));

        return n;
    }
    @Override
    ArrayList<Integer> generate(){
        System.out.println("Volfram");
        for (int i = 0; i <Nbit ; i++)
        {
            int temp=getNewBit();
           // System.out.println(temp);
            keeper.add(temp);
            addElement(temp,keeperMap);
        //    System.out.println(temp+" ");
        }
        return keeper;
    }
}
