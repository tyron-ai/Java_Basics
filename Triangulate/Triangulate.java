import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Triangulate {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the filename:");
        //Getting file name
        Scanner fileIn=new Scanner(System.in);
        String fName=fileIn.nextLine();


        File myFile=new File(fName);
        Scanner in=new Scanner(myFile);
        ArrayList<String> sh=new ArrayList<>();
        int height=0;
        int se=7;
        int f=5;
        int fo=4;
        //Storing file contents
        while(in.hasNextLine())
        {
            String s=in.nextLine();
            sh.add(s);
            height++;
        }


        int cols=Integer.parseInt(String.valueOf(sh.get(0).length())) ;//length of columns

        System.out.println("Enter the location:");
        String loc=fileIn.nextLine();
        //getting location and changing to x & y
        int triHeight=0;
        String[] co=loc.split(" ");
        int x=Integer.parseInt(co[0]);
        int y=Integer.parseInt(co[1]);

        //initial x
        int iy=x;

        //getting starting row from arraylist
        String wo=sh.get(y);
        //the character
        char t=wo.charAt(x);

        int xf=x;
        int xb=x;
        //should do while not out of range
        while((xb>0 && y<cols)) //***had xf<cols but unnecessary
        {
            String wo2=sh.get(y);
            if(wo2.charAt(iy)==t)
            {
                if(wo2.charAt(xb)==t && wo2.charAt(xf)==t)
                {
                    triHeight++;
                }
            }
            else {break;}
            xb--;
            xf++;
            y++;
            //special condition for patter at edge
            if(xb==0&& y<height)
            {
                if(y<height) { //***was y<cols-1 is supposed to check height
                    String woo = sh.get(y);//***was y-1 is supposed to check next line after incrementing in line 55
                    if (woo.charAt(xb) == t && woo.charAt(xf) == t)
                    {
                        triHeight++;
                    }
                }
            }
        }
        if(triHeight==0 ||triHeight<2)
        {
            System.out.println("No triangle.");
        }
        else
        {
            System.out.println("The largest triangle has height "+triHeight+".");
        }

    }
}
