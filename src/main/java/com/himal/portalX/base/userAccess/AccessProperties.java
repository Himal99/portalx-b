package com.himal.portalX.base.userAccess;

import java.util.Random;

/**
 * @author Himal Rai on 2/6/2022
 */
public class AccessProperties {

    public static String TOKEN(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        sb.append("PORTAL-X:");
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
