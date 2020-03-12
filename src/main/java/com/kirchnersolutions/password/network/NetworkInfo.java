package com.kirchnersolutions.password.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetworkInfo {

    public void menu(Scanner input) {
        System.out.println("Network Info");
        System.out.println("1. Get Network Info");
        System.out.println("2. Resolve Hostname");
        System.out.println("0. Exit");
        String in = input.next();
        if(in.contains("1")){
            try{
                String[] info = networkInfo();
                System.out.println("Your IP: " + info[0]);
                System.out.println("Your Host Name: " + info[1]);
            }catch (UnknownHostException e){
                System.out.println("An error has happened");
            }
        }else if(in.contains("2")){
            System.out.println("Host name ?");
            try{
                System.out.println("IP = " + hostNameResolver(input.next()));
            }catch (UnknownHostException e){
                System.out.println("An error has happened");
                e.printStackTrace();
            }
        }else{
            //End session and exit to main menu
        }
    }

    public String[] networkInfo() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String[] info = new String[2];
        info[0] = ip.toString();
        info[1] = ip.getHostName();
        return info;
    }

    public final static String hostNameResolver(String hostName) throws UnknownHostException {
        return InetAddress.getByName(hostName).toString();
    }

}
