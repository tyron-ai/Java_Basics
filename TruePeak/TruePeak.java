import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TruePeak {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the name of the data file:");

        //Read in file
        Scanner in=new Scanner(System.in);
        //File name
        String fi=in.nextLine();
        File myFile=new File(fi);


        //File scanner
        Scanner fin=new Scanner(myFile);
        String a=fin.nextLine();
        System.out.println("Data values: "+a+".");

        //String array
        String[] b=a.split(" ");
        //System.out.println(Arrays.toString(b));
        //int array
        int [] c=new int[b.length];
        int ty=0;
        for (int i=0;i<c.length;i++)
        {
            c[i]=Integer.parseInt(b[i]);
        }

       // System.out.println(Arrays.toString()
        ArrayList<Integer> peaks=new ArrayList<>();
        ArrayList<Integer> troughs=new ArrayList<>();

            String strInd="";

        int xb=0;
        int xf=1;
        if(c.length>2) {
             strInd="0 ";
                //beginning with trough
                if (c[xb] > c[xf])
                {
                    //loop until increment
                        for (int i = 1; i < c.length; i++) {
                            if (c[i] > c[i + 1]) {
                                xb++;
                                xf++;
                                continue;

                            } else {
                                //first trough
                                strInd += i + " ";
                                troughs.add(i);
                                break;
                            }
                        }
                }
                else {
                    //beginning with peak
                    if (c[xb] < c[xf]) {
                        //loop until decrement
                            for (int i = 1; i < c.length; i++) {
                                if (c[i] < c[i + 1]) {
                                    xb++;
                                    xf++;
                                    continue;

                                } else {
                                    //first peak
                                    strInd += i + " ";
                                    peaks.add(i);
                                    break;
                                }

                            }
                    }
                }

                //now add when transition
            for(int v=xf+1;v<c.length;v++)
            {
                if(v+1<c.length)
                {
                    if(c[v-1]>c[v]&&c[v]<c[v+1])
                    {
                        //trough
                        strInd+=v+" ";
                        troughs.add(v);
                    }
                    else if(c[v-1]<c[v]&&c[v]>c[v+1])
                    {
                        //peak
                        strInd+=v+" ";
                        peaks.add(v);
                    }

                }
                else break;

            }
        }
        else
        {
            if(c.length==1)
            {
                strInd="0";
            }
            if(c.length==2)
            {
                strInd="0 1";
            }

            System.out.println("Transition indices: "+strInd+".");
            System.out.println("Enter the true peak margin:");
            int peak=Integer.parseInt(in.nextLine());
            System.out.println("No true peaks.");
            System.out.println("Finished.");
            System.exit(0);

        }
        int l=c.length-1;
        strInd+=l;
        System.out.println("Transition indices: "+strInd+".");
        System.out.println("Enter the true peak margin:");
        int peak=Integer.parseInt(in.nextLine());
        String[] ps=strInd.split(" ");
       //System.out.println(peaks);

        int[] trans=new int[ps.length];
        //converting to int arr
        for (int i=0;i<ps.length;i++)
        {
            trans[i]=Integer.parseInt(ps[i]);
        }


        String f="";
        for (Integer pp:peaks)
        {
            for(int i=0;i<trans.length;i++)
            {
                if(pp==trans[i])
                {
                    int ind=i;

                    //get other indexes
                    int diff1=trans[i]-trans[i-1];
                    int diff2=trans[i+1]-trans[i];

                    if(diff1>=peak&&diff2>=peak)
                    {
                        f+=pp+" ";
                    }
                }
            }
        }
        if(f.length()==0)
        {
            System.out.println("No true peaks.");
            System.out.println("Finished.");
        }
        else {
            f=f.trim();
            System.out.println("True peaks: "+f+".");
            System.out.println("Finished.");
        }


    }
}
