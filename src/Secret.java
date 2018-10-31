import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Secret {
    File logs =  new File("logs.txt");
    FileOutputStream log = new FileOutputStream(logs);
    static double var =2;
    int check;

    public Secret() throws FileNotFoundException {
    }

    private void checkIsItANaturalNumber(double n) {
        if (n > 1) {
            if (n % var != 0) {
                var++;
                checkIsItANaturalNumber(n);
            } else if (n % var == 0) {
                printIsItNaturalNumber(var, n);
            }
        }
    }

    private void printIsItNaturalNumber(double var, double n) {
        if (var == n) {
            System.out.println(n + " is a simple number.");
            check=1;
        } else {
            System.out.println(n + " is not a simple number.");
            check=0;
        }
    }

    public void BobAndAlice() throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        byte[] strToBytes;
        double p;
        double g;
        double nBob;
        double nAlice;
        char AorB;

        int var = 2;
        do {
            System.out.println("P?");
            p = sc.nextDouble();
            checkIsItANaturalNumber(p);
        }while(check!=1);
        check=0;
        sb.append("P is: ");
        sb.append(p);
        sb.append(System.getProperty("line.separator"));
        do {
            System.out.println("G?");
            g = sc.nextDouble();
            if((g-1)<=0) {
                System.out.println("G must be 1<G<P-1");
                check = 0;
            }else if (g>=(p-1)) {
                        System.out.println("G must be 1<G<P-1");
                        check = 0;

                } else {
                    check = 1;
                }
                if(p%g==0){
                    System.out.println("Modul is bad");
                check=0;
                }
        }while(check!=1);
        sb.append("G is: ");
        sb.append(g);
        sb.append(System.getProperty("line.separator"));
        System.out.println("Bob?");
        nBob = sc.nextDouble();
        sb.append("Bob's number is: ");
        sb.append(nBob);
        sb.append(System.getProperty("line.separator"));
        System.out.println("Alice?");
        nAlice = sc.nextDouble();
        sb.append("Alice's number is: ");
        sb.append(nAlice);
        sb.append(System.getProperty("line.separator"));
        String str = sb.toString();
        strToBytes = str.getBytes();
        log.write(strToBytes);
        AorB='A';
        nAlice = theirSecret(nAlice, p, g, AorB);
        AorB ='B';
        nBob = theirSecret(nBob, p, g, AorB);
        AorB='A';
        theirCommonSecret(nAlice, nBob, p, AorB);
        AorB ='B';
        theirCommonSecret(nBob, nAlice, p, AorB);
    }
    public double theirSecret(double n, double p, double g, char AorB) throws IOException {

        StringBuilder sb = new StringBuilder();
        byte[] strToBytes;
        String str;
        n = (Math.pow(g, n)) % (p);
        switch (AorB) {
            case 'A':
                sb.append("Alice's number after the first operation is: ");
                sb.append(n);
                sb.append(System.getProperty("line.separator"));
                str = sb.toString();
                strToBytes = str.getBytes();
                log.write(strToBytes);
                return n;
            case 'B':
                sb.append("Bob's number after the first operation is: ");
                sb.append(n);
                sb.append(System.getProperty("line.separator"));
                str = sb.toString();
                strToBytes = str.getBytes();
                log.write(strToBytes);
                return n;
        }
        return 0;
    }
        public double theirCommonSecret(double a, double b, double p, char AorB) throws IOException {
            StringBuilder sb = new StringBuilder();
            String str;
            byte[] strToBytes;
            double back;
            switch (AorB) {
                case 'A': back = (Math.pow(b, a)) % (p);
                    sb.append("Alice's number after the second operation is: ");
                    sb.append(back);
                    sb.append(System.getProperty("line.separator"));
                    str = sb.toString();
                    strToBytes = str.getBytes();
                    log.write(strToBytes);
                    return back;
                case 'B': back = (Math.pow(a, b)) % (p);
                    sb.append("Bob's number after the second operation is: ");
                    sb.append(back);
                    sb.append(System.getProperty("line.separator"));
                    str = sb.toString();
                    strToBytes = str.getBytes();
                    log.write(strToBytes);
                    return back;
            }
         return 0;
    }
}
