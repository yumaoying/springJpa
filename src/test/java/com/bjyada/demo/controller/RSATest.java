package com.bjyada.demo.controller;

import com.bjyada.demo.util.RSA;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by Administrator on 2017/10/18.
 */
public class RSATest {
    @Test
    public void  rsa() {
        RSA rsa=new RSA();
        PrivateKey prikey= null;
        PublicKey pubkey=null;
        try {
            prikey = rsa.getPvkformPfx("F:\\self.pfx","111111");
            pubkey= rsa.getPubKeyFromPfx("F:\\self.pfx","111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("public key = " +  pubkey);
        try {
           String str= RSA.encrypt("123",pubkey);
            System.out.println(str);
            System.out.println( RSA.decrypt(str,prikey));
        } catch (Exception e) {
            e.printStackTrace();
        }

      //  System.out.println("private key = " + prikey);
       // ReadPFX.GetPvkformPfx("F:\\self.pfx","atlas");
    }
}
