import java.util.*;
import java.io.*;
public class Bitmap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File myFile=new File("bitmap.txt");
        Scanner input=new Scanner(myFile);
        String line="";

        //getting input from file
        while(input.hasNextLine())
        {
            line=input.nextLine();
        }

        //converting string to array
        String[] nums=line.split(",");
        //System.out.println(Arrays.toString(nums));
        //System.out.println(nums.length); number of columns

        //2d array to be displayed
        String[][] dis=new String[8][nums.length];

        //creating 7 arrayLists storing numbers
        ArrayList<Integer> f=new ArrayList<>();
        ArrayList<Integer> se=new ArrayList<>();
        ArrayList<Integer> th=new ArrayList<>();
        ArrayList<Integer> fo=new ArrayList<>();
        ArrayList<Integer> fi=new ArrayList<>();
        ArrayList<Integer> si=new ArrayList<>();
        ArrayList<Integer> sev=new ArrayList<>();
        ArrayList<Integer> ei=new ArrayList<>();

        //converting each string to an integer array
        int[] num=new int[nums.length];
        for(int i=0;i<num.length;i++)
        {
            num[i]=Integer.parseInt(nums[i]);
        }

        //printing integer array
        //System.out.println(Arrays.toString(num));


        ArrayList<String> st=new ArrayList<>(); //arrayList of binary values
        String fin=""; //final string
        int k=1;
        int diff=0;//differences
        for(int t:num)
        {
            //converting each number to binary
            String bin=Integer.toString(t,2);

            //reversing string
            StringBuilder sb=new StringBuilder(bin);
            bin=sb.reverse().toString();

            //adding leading Zeros
            if(bin.length()<9)
            {
                diff = 8 - bin.length();

                for (int a = 0; a < diff; a++)
                {
                    bin = bin.concat("0");
                }
                //System.out.println(bin);
            }


            StringBuilder b=new StringBuilder(bin);
            bin=b.reverse().toString();//reversing string
            //System.out.println(bin);

            f.add(Integer.parseInt(String.valueOf(bin.charAt(0))));
            se.add(Integer.parseInt(String.valueOf(bin.charAt(1))));
            th.add(Integer.parseInt(String.valueOf(bin.charAt(2))));
            fo.add(Integer.parseInt(String.valueOf(bin.charAt(3))));
            fi.add(Integer.parseInt(String.valueOf(bin.charAt(4))));
            si.add(Integer.parseInt(String.valueOf(bin.charAt(5))));
            sev.add(Integer.parseInt(String.valueOf(bin.charAt(6))));
            ei.add(Integer.parseInt(String.valueOf(bin.charAt(7))));

        }
        //System.out.println(fin);

        for(int i=0;i<f.size();i++)
        {
            System.out.print(f.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(se.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(th.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(fo.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(fi.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(si.get(i));
        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(sev.get(i));

        }
        System.out.println();

        for(int i=0;i<f.size();i++)
        {
            System.out.print(ei.get(i));
        }
        System.out.println();

        System.out.println("Done");
    }


}
