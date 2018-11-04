

public class Main {

    public static String bitsGenerated = new String();
    private static int p = 11;
    private static int q = 19;
    private static int seed = 3;

    public static String toBits()
    {
        bbs b = new bbs (p,q,seed);

        for (int i = 0; i <20000; ++i) {
            int temp=b.getrandom();
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

        if(zeros-ones>1 || ones-zeros>1)
        {
            flag=false;
        }
        else
        {
           flag=true;
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
        System.out.println("Liczba sekwencji 10 w ciagu" + onezero);
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

        if(frequencyTest(bits)==false)
        {
            System.out.println("Ciag nie przeszedl testu czestosci wiec nie moze zostac poddany testowi serii");
        }
        int n=bits.length();

        int zeros=0;
        int ones=0;

        for(int i=0;i<bits.length();i++)
        {
            if(bits.charAt(i)=='1') {
                ones++;
            }
        }

        double pi =n/ones;

        for(int i=0;i<bits.length();i++)
        {

        }


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
