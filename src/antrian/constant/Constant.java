/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.constant;

/**
 *
 * @author ZuhdanNur
 */
public final class Constant {
    public static final String TABLE_TELLER = "teller";
    public static final String TABLE_SERVICE = "service";
    static final int codeLenght = 4;
    
    public static final String listTable[] = {TABLE_TELLER,TABLE_SERVICE};
    
    public static String generateKode(int number , String N) {
        int lenght = String.valueOf(number).length();
        String kode = N;
        for(int i = 0; i < (codeLenght - lenght); i++) {
            kode += "0";
        }
        return kode+number;
    }
}
