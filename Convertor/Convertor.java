import java.util.*;

public class Convertor {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        HashMap<Integer,String> hours=new HashMap<>();
        //Adding hours to hashmap
        hours.put(1,"one");
        hours.put(2,"two");
        hours.put(3,"three");
        hours.put(4,"four");
        hours.put(5,"five");
        hours.put(6,"six");
        hours.put(7,"seven");
        hours.put(8,"eight");
        hours.put(9,"nine");
        hours.put(10,"ten");
        hours.put(11,"eleven");
        hours.put(12,"twelve");
        hours.put(13,"one");

        //Adding minutes to hashmap
        HashMap<Integer,String> minutes=new HashMap<>();
        minutes.put(00,"o'clock");
        minutes.put(05,"five past");
        minutes.put(10,"ten past");
        minutes.put(15,"quarter past");
        minutes.put(20,"twenty past");
        minutes.put(25,"twenty five past");
        minutes.put(30,"half past");
        minutes.put(35,"twenty five to");
        minutes.put(40,"twenty to");
        minutes.put(45,"quarter to");
        minutes.put(50,"ten to");
        minutes.put(55,"five to");

        String inputT="";


        do
        {
            System.out.println("Enter a time or 'quit':");
            String q="quit";
            inputT=input.nextLine();

            if(inputT.equalsIgnoreCase("quit"))
            {
                System.out.println("Done");
                break;
            }
            String[] time=inputT.split(":");//Turning time into array
            String h=time[0];//hours
            String m=time[1];//minutes

            int hrs=Integer.parseInt(h);
            int mins=Integer.parseInt(m);
            //either greater than 30 or less

            if (mins<31)
            {
                //time is always past
                if(mins==00)//o'clock scenario
                {
                    String out=hours.get(hrs);
                    out+=" "+minutes.get(00);
                    System.out.println(out);
                }
                else if(mins%5==0)
                {
                    String out=minutes.get(mins);
                    out+=" "+hours.get(hrs);
                    System.out.println(out);
                }
                else //the about scenario
                {
                    int rem=mins%5;
                    if(rem>2)//next set of mins
                    {
                        mins=mins-rem;
                        mins=mins+5;

                        String out=minutes.get(mins);
                        out+=" "+hours.get(hrs);
                        System.out.println("about "+out);

                    }
                    else if (rem<3)
                    {
                        mins=mins-rem;

                        if(mins==0)
                        {
                            String out=hours.get(hrs);
                            out+=" "+minutes.get(mins);
                            System.out.println("about "+out);
                        }
                        else {
                            String out = minutes.get(mins);
                            out += " " + hours.get(hrs);
                            System.out.println("about " + out);
                        }

                    }
                }
            }
            else
            {
                //time is to the next hour
                if(mins%5==0)
                {
                    String out=minutes.get(mins);
                    out+=" "+hours.get(hrs+1);
                    System.out.println(out);
                }
                else if (mins>55) {
                    String out=hours.get(hrs+1);
                    out+=" "+minutes.get(00);
                    System.out.println("about "+out);
                }
                else//the about scenario
                {
                    int rem=mins%5;
                    if(rem>2)//next set of mins
                    {
                        mins=mins-rem;
                        mins=mins+5;
                        if(mins==0)
                        {
                            String out=hours.get(hrs+1);
                            out+=" "+minutes.get(00);
                            System.out.println("about "+out);
                        }
                        else
                        {
                            String out = minutes.get(mins);
                            out += " " + hours.get(hrs+1);
                            System.out.println("about " + out);
                        }
                    }
                    else if (rem<3) {
                        mins = mins - rem;
                        if (mins == 30) {
                            String out = minutes.get(mins);
                            out += " " + hours.get(hrs);
                            System.out.println("about " + out);
                        } else {
                            String out = minutes.get(mins);
                            out += " " + hours.get(hrs + 1);
                            System.out.println("about " + out);
                        }
                    }
                }
            }

        } while (true);
    }

}

