import java.util.*;
import java.io.*;

public class Check
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Enter the name of the cards file:");
        Scanner l=new Scanner(System.in);
        String ty=l.nextLine();
        File myFile=new File(ty);
        Scanner in=new Scanner(myFile);
        ArrayList<String> card=new ArrayList<>();


        while(in.hasNextLine())
        {
            String line=in.nextLine();
            card.add(line);
        }
        //System.out.println(card);

        for(String t:card)
        {
            System.out.println("Processing: "+t);
            String[] cards=t.split(" ");
            //System.out.println(Arrays.toString(cards));
            String card1=cards[0];
            String card2=cards[1];
            String card3=cards[2];

            if(card1.equalsIgnoreCase(card2)&&card1.equalsIgnoreCase(card3))
            {

                System.out.println("Valid");
            }
            else if(((card1.equalsIgnoreCase(card2)&&card1.equalsIgnoreCase(card3))!=true))
            {

                String[] diff=card1.split(",");
                //System.out.println(Arrays.toString(diff));
                String f=diff[0];
                String s=diff[1];
                String th=diff[2];

                int count=0;
                //Should all be false
                boolean fir=card2.contains(f);
                boolean sec=card2.contains(s);//
                boolean thi=card2.contains(th);//
                boolean fo=card3.contains(f);//
                boolean fiv=card3.contains(s);//
                boolean si=card3.contains(th);//



                String[] diff2=card2.split(",");
                //System.out.println(Arrays.toString(diff));
                String f2=diff2[0];
                String s2=diff2[1];
                String th2=diff2[2];
                boolean se=card3.contains(f2);//
                boolean ei=card3.contains(s2);//
                boolean ni=card3.contains(th2);//
                //==sec==thi==fo==fiv==si==se==ei==ni)
                if(fir==false)
                {
                    count++;
                }
                if(sec==false)
                {
                    count++;
                }
                if(thi==false)
                {
                    count++;
                }
                if(fo==false)
                {
                    count++;
                }
                if(fiv==false)
                {
                    count++;
                }
                if(si==false)
                {
                    count++;
                }
                if(se==false)
                {
                    count++;
                }
                if(ei==false)
                {
                    count++;
                }
                if(ni==false)
                {
                    count++;
                }


                if(count==9)
                {
                    System.out.println("Valid");
                }
                else
                {System.out.println("Invalid");}

                count=0;


            }
        }
        System.out.println("Done");
    }
}
