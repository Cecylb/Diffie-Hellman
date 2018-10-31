import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class DiffieHellman{

    public static void main (String args[]) throws IOException {
        Secret secret = new Secret();
        secret.BobAndAlice();
    }


}

