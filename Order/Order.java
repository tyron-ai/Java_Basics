import java.util.*;
import java.io.*;
public class Order {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Enter the name of the word lists text file:");
        Scanner input = new Scanner(System.in);
        String fileN = input.nextLine();

        File myFile = new File(fileN);
        Scanner in = new Scanner(myFile);

        //Arraylist storing lines
        ArrayList<String> sent = new ArrayList<>();

        while (in.hasNextLine()) {
            String sentence = in.nextLine();
            sent.add(sentence);
        }

        //System.out.println(sent);
        for (String t : sent)
        {
            //System.out.println(t);
            String[] sentArray = t.split(" ");
            //System.out.println(Arrays.toString(sentArray));

            int seqCounter = 0;
            int max = 0;
            int start = 1;
            int end = 0;
            String dig = "";
            ArrayList<Integer> co = new ArrayList<>();
            String f = "";
            String s = "";
            // System.out.println(sentArray.length);
            for (int i = 0; i < sentArray.length - 1; i++) {
                f = sentArray[i];
                s = sentArray[i + 1];
                //add result to array
                if (s.compareToIgnoreCase(f) > 0) {
                    dig = dig.concat("1");

                } else {
                    dig = dig.concat("0");
                }
            }
            //System.out.println(dig);
            String[] digits = dig.split("0");
            //System.out.println(Arrays.toString(digits));
            // System.out.println("===========================");
            int sum = 1;
            for (int j = 0; j < digits.length; j++) {
                String current = digits[j];
                if (current.length() == 1) {
                    co.add(2);
                } else if (current.length() == 0) {
                    continue;
                } else
                {
                    int seq = 1;
                    String[] cu = current.split("");
                    for (int k = 0; k < cu.length; k++) {

                        int num = Integer.parseInt(cu[k]);
                        seq += num;
                    }
                    //System.out.println(Arrays.toString(cu));
                    co.add(seq);
                }
            }
            //System.out.println(co);//has digits with the lengths
            //we want to look for highest in ArrayList
            int highest = 0;
            int highCounter = 0;

            if (sentArray.length == 2 && s.compareToIgnoreCase(f) < 0)
            {
                System.out.println("Multiple solutions length 1.");
            } else if (co.size() == 0) {
                if(sentArray.length==3)
                {
                    System.out.println("Multiple solutions length 1.");
                }
                else {
                    System.out.println("Longest is 1.");
                }
            } else
            {
                for (Integer v : co)
                {
                    if (v > highest) {
                        highest = v;
                    }
                }

                for (Integer x : co) {
                    if (x == highest) {
                        highCounter++;
                    }
                }

                if (highCounter ==1)
                {
                    System.out.println("Longest is " + highest + ".");

                }
                else
                {
                    System.out.println("Multiple solutions length " + highest + ".");
                }
            }

            //System.out.println("===========================");
            co.clear();
        }
        System.out.println("Done");
    }

}


