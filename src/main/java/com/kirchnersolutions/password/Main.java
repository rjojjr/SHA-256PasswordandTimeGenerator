package com.kirchnersolutions.password;

import com.kirchnersolutions.password.network.NetworkInfo;
import com.kirchnersolutions.utilities.ByteTools;
import com.kirchnersolutions.utilities.CryptTools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static final String VERSION = "1.0.01a";
    public static final String BUILD = "100101";
    public static NetworkInfo netInfo = new NetworkInfo();

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String option;
        while(true){
            System.out.println("Password and Time Generator");
            System.out.println("Version: " + VERSION);
            System.out.println("Build: " + BUILD);
            System.out.println("1. Create Password");
            System.out.println("2. Get Current Time");
            System.out.println("3. Network");
            System.out.println("exit. End Program");
            option = in.next();
            if(option.toLowerCase().equals("exit")){
                System.out.println("Exiting program...");
                System.exit(0);
            }else if(option.equals("1")){
                System.out.println("Enter passphrase");
                String passphrase = in.next();
                System.out.println("Password:");
                System.out.println(CryptTools.generateEncodedSHA256Password(passphrase));
                System.out.println("Enter c to continue");
                option = in.next();
            }else if(option.equals("3")){
                netInfo.menu(in);
            }else{
                System.out.println("Current Time: " + System.currentTimeMillis());
                System.out.println("Enter c to continue");
                option = in.next();
            }
        }
    }

}
