import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;
import java.text.*;
public class Oddities {
    public static void main(String[] args) throws FileNotFoundException,ParseException {
        System.out.println("Enter the name of the text file of dates:");
        Scanner input=new Scanner(System.in);
        String fileN=input.nextLine();

        File myFile= new File(fileN);
        Scanner in=new Scanner(myFile);

        ArrayList<String> dtes=new ArrayList<>();//ArrayList storing dates

        while (in.hasNextLine())
        {
            String into=in.nextLine();
            dtes.add(into);
        }
        //System.out.println(dtes);
        for(String da:dtes)
        {
            String og=da;
            String[] oD=og.split("/");
            int Oday=Integer.parseInt(oD[0]);
            int Omonth=Integer.parseInt(oD[1]);
            int Oyear=Integer.parseInt(oD[2]);
            String[] evD=da.split("/");
            //System.out.println(Arrays.toString(evD));

            //now we want to make the date odd
            //make day odd
            int day=Integer.parseInt(evD[0]);
            int month=Integer.parseInt(evD[1]);
            int year=Integer.parseInt(evD[2]);
            int changY=0;
            int changM=0;
            int changD=0;
            do {
                if(year%2==0)
                {
                    year++;
                }
                else
                {
                    break;
                }
                changY++;
            }while(year%2==0);
            year=year;
            if(day==30 && month==9)
            {
                day=1;
                month=11;
            }
            if(day==30 && month>10)
            {
                day=1;
                month=1;
                if(year%2==1)
                {
                    year=year+2;
                }
            }
            if(changY>0)
            {
                month=1;
                changM++;
            }
            else
                do
                {
                    if(month%2==0)
                    {
                        month++;
                    } else if (month==12)
                    {
                        month=1;
                        break;
                    } else
                    {
                        break;
                    }
                    changM++;
                }
                while(month%2==0);
            month=month;
            //System.out.println("odd "+month+"/"+year);


            if(changM>0)
            {
                day=1;
                changD++;
            }
            do {
                if(day%2==0)
                {
                    day++;
                }
                else
                {
                    break;
                }
                changD++;
            }while(day%2==0);
            day = day;
            String nd=day+"/"+month+"/"+year;
            //System.out.println("Original date: "+og+"\n"+"New Date: "+nd);

            //compare period between dates;
            SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
            int days=0;
            LocalDate past=LocalDate.of(Oyear,Omonth,Oday);
            LocalDate now=LocalDate.of(year,month,day);
            //System.out.println(ChronoUnit.DAYS.between(past,now)+" days");
            days=Integer.parseInt(String.valueOf(ChronoUnit.DAYS.between(past,now)));
            //System.out.println(days);

            if(days==0)
            {
                System.out.println("The date "+og+" has all odd digits.");
            }
            else if (days==1){
                System.out.println("The first date after " +og +" with all odd digits is "+ nd +" which is 1 day later.");
            }
            else
            {
                System.out.println("The first date after " +og +" with all odd digits is "+ nd +" which is "+days+" days later.");
            }

        }
        System.out.println("Done");
    }
}
