package utils;

/**
 * Created by Xavier on 01/02/2016.
 */
public class ExceptionMailer {
    public static void send(Throwable e){
        System.out.println("Sending email containing exception " + e);
    }
}
