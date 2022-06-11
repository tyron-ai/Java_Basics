import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Ships {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the name of the ship data file:");
        Scanner fileIn=new Scanner(System.in);
        String fName=fileIn.nextLine();

        File myFile=new File(fName);
        Scanner in=new Scanner(myFile);
        ArrayList<String> sh=new ArrayList<>();

        while(in.hasNextLine())
        {
            String s=in.nextLine();
            sh.add(s);
        }
        //System.out.println(sh);
        //get pairs
        int fi=0;
        int se=1;
        int p=1;
        //DecimalFormat df=new DecimalFormat("0.0");

        //System.out.println(sh.size());
        do{
            String s1=sh.get(fi);
            String s2=sh.get(se);

            String[] sh1=s1.split(" ");
            String[] sh2=s2.split(" ");

            double a1,b1,c1,x1,y1,a2,b2,c2,x2,y2;
            double xi,yi;//intersection points
            double d1,d2;
            double m1,m2,n1,n2;
            a1=Double.parseDouble(sh1[0]);
            b1=Double.parseDouble(sh1[1]);
            c1=Double.parseDouble(sh1[2]);
            x1=Double.parseDouble(sh1[3]);
            y1=Double.parseDouble(sh1[4]);


            a2=Double.parseDouble(sh2[0]);
            b2=Double.parseDouble(sh2[1]);
            c2=Double.parseDouble(sh2[2]);
            x2=Double.parseDouble(sh2[3]);
            y2=Double.parseDouble(sh2[4]);

            xi=((b1*c2)-(b2*c1))/((a1*b2)-(a2*b1));
            yi=((a2*c1)-(a1*c2))/((a1*b2)-(a2*b1));

            m1=xi-x1;
            n1=yi-y1;
            m1=Math.pow(m1,2);
            n1=Math.pow(n1,2);

            d1=Math.sqrt(m1+n1);

            m2=xi-x2;
            n2=yi-y2;
            m2=Math.pow(m2,2);
            n2=Math.pow(n2,2);

            d2=Math.sqrt(m2+n2);

           /* String fd1=df.format(d1).toString();
            String fd2=df.format(d2).toString();
            String fxi=df.format(xi).toString();
            String fyi=df.format(yi).toString();

            d1=Double.parseDouble(fd1);
            d2=Double.parseDouble(fd2);
            xi=Double.parseDouble(fxi);
            yi=Double.parseDouble(fyi);*/

            //double roundOff = Math.round(a * 100.0) / 100.0;
            double td1,td2,txi,tyi;
            td1=Math.round(d1 * 10.0) / 10.0;
            td2=Math.round(d2 * 10.0) / 10.0;
            txi=Math.round(xi * 10.0) / 10.0;
            txi=Math.round(yi * 10.0) / 10.0;

            String o="";
            double d=0;

            if(td1>td2)
            {   d=td1-td2;
                if(d>0.5) {
                    o = "; Ship S2 is nearest.";
                }
                else {o="; Tied.";}
            } else if (td2>td1) {
                d=td2-td1;
                if(d>0.5) {
                    o = "; Ship S1 is nearest.";
                }
                else
                {
                    o="; Tied.";
                }
            }
            else if(td1==td2)
            {
                o="; Tied.";
            }

            System.out.format("Pair "+p+": Intersection point: (%.1f, %.1f); Ship S1's distance is %.1f; Ship S2's distance is %.1f"+o+"\n",xi,yi,d1,d2);

            fi+=2;
            se+=2;
            p++;
            o="";
        }while(fi<sh.size());

        System.out.println("Done");
    }
}
