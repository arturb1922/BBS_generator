

public class Main {

    public static String bitsGenerated = new String();
    private static int p = 139;
    private static int q = 251;
    private static int seed = 26;

    public static String toBits()
    {
        bbs b = new bbs (p,q,seed);

        for (int i = 0; i <20000; ++i) {
            int temp=b.getrandom();
            System.out.println(temp);
            String x="";
            x=Integer.toBinaryString(temp);
            String bit=x.substring(x.length()-1);
            bitsGenerated+= bit;
        }

        return bitsGenerated;
    }

    public static boolean frequencyTest(String bits)
    {
        boolean flag=false;
        int zeros=0;
        int ones=0;

        for(int i=0;i<bits.length();i++)
        {

            if(bits.charAt(i)=='0')
            {
                zeros++;
            }
            if(bits.charAt(i)=='1') {
                ones++;
            }
        }
        System.out.println("Liczba zer w ciagu " + zeros);
        System.out.println("Liczba jedynek w ciagu  " + ones);

        if(zeros>9725 && zeros<10275 && ones>9725 && ones<10275)
        {
            flag=true;
        }
        else
        {
           flag=false;
        }


        return flag;
    }

    public static boolean twoBitsTest(String bits)
    {
        boolean flag=false;
        int zeros=0;
        int ones=0;
        int zeroone=0;
        int onezero=0;

        for(int i=0;i<bits.length()-1;i++)
        {
            String temp= new String();
            temp=temp+ bits.charAt(i)+bits.charAt(i+1);

            if(temp.contains("00"))
            {
                zeros++;
            }
            if(temp.contains("11")) {
                ones++;
            }
            if(temp.contains("01"))
            {
                zeroone++;
            }
            if(temp.contains("10"))
            {
                onezero++;
            }
        }

        System.out.println("Liczba sekwencji 00 w ciagu " + zeros);
        System.out.println("Liczba sekwencji 01 w ciagu " + zeroone);
        System.out.println("Liczba sekwencji 10 w ciagu " + onezero);
        System.out.println("Liczba sekwencji 11 w ciagu " + ones);


        if(zeros-ones>1 || ones-zeros>1 || zeros-zeroone>1 || zeroone-zeros>1 || zeros-onezero>1 || onezero-zeros>1 || ones-zeroone>1 || zeroone-ones>1 || ones-onezero>1 || onezero-ones>1 || zeroone-onezero>1 || onezero-zeroone>1)
        {
            flag=false;
        }
        else
        {
            flag=true;
        }


        return flag;
    }

    public static boolean longSeriesTest(String bits)
    {
        boolean flag=false;
        int max=0;
        String temp=bits.substring(0,1);
        for(int i=1;i<bits.length();i++)
        {

            if(temp.charAt(0)==bits.charAt(i))
            {
                temp=temp+bits.charAt(i);
            }
            if(temp.charAt(0)!=bits.charAt(i))
            {
                if(temp.length()>max){max=temp.length();}
                temp=new String();
                temp=temp+bits.charAt(i);
            }
        }
        System.out.println("Najdluzszy maksymalny podciag wynosi: "+ max);

        if (max>=26)
        {
            flag=false;
        }
        else{
            flag=true;
        }


        return flag;
    }

    public static boolean seriesTest(String bits)
    {
        boolean flag=false;

//        if(frequencyTest(bits)==false)
//        {
//            System.out.println("Ciag nie przeszedl testu czestosci wiec nie moze zostac poddany testowi serii");
//
//        }
//        else {
            int oneLength = 0;
            int twoLength = 0;
            int threeLength = 0;
            int fourLength = 0;
            int fiveLength = 0;
            int sixOrMoreLength = 0;

            int counter = 1;
            String temp = bits.substring(0, 1);
            for (int i = 1; i < bits.length(); i++) {

                if (temp.charAt(0) == bits.charAt(i)) {
                    temp = temp + bits.charAt(i);
                    counter++;
                }
                if (temp.charAt(0) != bits.charAt(i)) {
                    if (counter == 1) {
                        oneLength++;
                        counter = 1;
                    }
                    if (counter == 2) {
                        twoLength++;
                        counter = 1;
                    }
                    if (counter == 3) {
                        threeLength++;
                        counter = 1;
                    }
                    if (counter == 4) {
                        fourLength++;
                        counter = 1;
                    }
                    if (counter == 5) {
                        fiveLength++;
                        counter = 1;
                    }
                    if (counter >= 6) {
                        sixOrMoreLength++;
                        counter = 1;
                    }
                    temp = new String();
                    temp = temp + bits.charAt(i);
                }
            }


            System.out.println("Ciagow jednobitowych jest: " + oneLength);
            System.out.println("Ciagow dwubitowych jest: " + twoLength);
            System.out.println("Ciagow trzybitowych jest: " + threeLength);
            System.out.println("Ciagow czterobitowych jest: " + fourLength);
            System.out.println("Ciagow pieciobitowych jest: " + fiveLength);
            System.out.println("Ciagow szeciobitowych i wiekszych jest: " + sixOrMoreLength);


            if (oneLength > 2315 && oneLength < 2685 && twoLength > 1114 && twoLength < 1386 && threeLength > 527 && threeLength < 723 && fourLength > 240 && fourLength < 384 && fiveLength > 103 && fiveLength < 209 && sixOrMoreLength > 103 && sixOrMoreLength < 209) {
                flag = true;
            } else {
                flag = false;
            }
       // }

        return flag;




    }


    public static void main(String[] args) {

        toBits();
        System.out.println("Wygenerownany ciag bitow");
        System.out.println(bitsGenerated);
        System.out.println();
        System.out.println("Ciag poddany zostanie teraz 4 testom sprawdzajacym jego losowosc");
        System.out.println("1.Test czestosci: ");

        if(frequencyTest(bitsGenerated)==true)
        {
            System.out.println("Ciag przeszedl test czestosci");
        }
        else
        {
            System.out.println("Ciag nie przeszedl testu czestosci");
        }

        System.out.println();
        System.out.println("2.Test dwubitowy");
        if(twoBitsTest(bitsGenerated)==true)
        {
            System.out.println("Ciag przeszedl test dwubitowy");
        }
        else
        {
            System.out.println("Ciag nie przeszedl testu dwubitowego");
        }
        System.out.println();
        System.out.println("3.Test dlugiej serii");


        if(longSeriesTest(bitsGenerated)==true)
        {
            System.out.println("Ciag przeszedl test dlugiej serii");
        }
        else
        {
            System.out.println("Ciag nie przeszedl testu dlugiej serii");
        }
        System.out.println();

        System.out.println("4.Test serii");
        if(seriesTest(bitsGenerated)==true)
        {
            System.out.println("Ciag przeszedl test  serii");
        }
        else
        {
            System.out.println("Ciag nie przeszedl testu  serii");
        }
        System.out.println();

    }
}
