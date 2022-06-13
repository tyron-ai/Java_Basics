import java.io.*;
import java.text.*;
import java.util.*;

//This program gets time from users and checks if they are clashing or not
public class Bookings {
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        System.out.println("Enter the number of bookings:");
        System.out.println("Enter the bookings, one per line:");
        Scanner in=new Scanner(System.in);

        int clash=0;
        int numBooks=Integer.parseInt(in.nextLine());

        ArrayList<String> bookings=new ArrayList<>();
        for(int i=0;i<numBooks;i++)
        {
            String book=in.nextLine();
            bookings.add(book);
        }
        // System.out.println(bookings);

        for(int i=0;i<numBooks;i++)
        {
            String cbook=bookings.get(i);
            // System.out.println(cbook);
            String[] cboo=cbook.split(" - ");
            //System.out.println(Arrays.toString(cboo));

            String arr1="";
            String dep1="";

            arr1=cboo[0];
            dep1=cboo[1];

            //System.out.println("Comparison outter "+i+" "+adv(arr1,dep1));
            String time1=adv(arr1,dep1);

            for(int k=i+1;k<numBooks;k++)
            {
                String cbook2=bookings.get(k);
                // System.out.println(cbook);
                String[] cboo2=cbook2.split(" - ");
                //System.out.println(Arrays.toString(cboo));

                String arr2="";
                String dep2="";

                arr2=cboo2[0];
                dep2=cboo2[1];

                //System.out.println("Comparison inner "+k+" "+adv(arr2,dep2));
                String time2=adv(arr2,dep2);

                String[] t1;
                String[] t2;

                t1=time1.split(" ");
                t2=time2.split(" ");

                int arriv1,arriv2,depa1,depa2;

                //System.out.println(Arrays.toString(t1));
                //System.out.println(Arrays.toString(t2));

                arriv1=Integer.parseInt(t1[0]);
                depa1=Integer.parseInt(t1[1]);

                arriv2=Integer.parseInt(t2[0]);
                depa2=Integer.parseInt(t2[1]);

                //checking if in range
                if(numBooks<50)
                {
                    if (arriv1 < arriv2 && arriv2 < depa1 || arriv2 < arriv1 && arriv1 < depa2) //if 2nd time arrival is greater than first arrival but less than departure
                    {
                        clash++;
                    }
                }
                else
                {
                    if (arriv1 < arriv2 && arriv2 <= depa1 || arriv2 <arriv1 && arriv1<=depa2) //if 2nd time arrival is greater than first arrival but less than departure
                    {
                        clash++;
                    }
                }
            }

        }
        if(clash==0)
        {
            System.out.println("Good to go!");
        }
        else
        {
            System.out.println("Let's play Sardines! Number of pairs that clash: " + clash+".");
        }
    }

    //this methods converts time to 24hr notation and returns String
    public static String adv(String arr,String dep ) throws ParseException
    {
        String output="";

        DateFormat dateFormat=new SimpleDateFormat("hh:mm aa");
        DateFormat dateFormat1=new SimpleDateFormat("HHmm");
        Date time=null;
        Date time2=null;


        time =dateFormat.parse(arr);
        time2=dateFormat.parse(dep);

        output=dateFormat1.format(time);
        output+=" "+dateFormat1.format(time2);


        return output;
    }

}
