
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author umariana
 */
public class X {

    public static void main(String[] xxxx) {
        Date d1=new GregorianCalendar(20, 12, 2017).getTime();
        Date d2=new GregorianCalendar(19, 12, 2017).getTime();

        System.out.println(""+d1.compareTo(d2));
        System.out.println(""+d2.compareTo(d2));
        System.out.println(""+d2.compareTo(d1));

    }
}
