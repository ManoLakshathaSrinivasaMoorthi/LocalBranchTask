package com.example.myapplication.encrypt;

import com.example.myapplication.cryptomodel.Utils;
import com.example.myapplication.interfaces.CryptoMethods;

public class DecryptionImplement implements CryptoMethods {
    @Override
    public String encrypt(String body) {
        return null;
    }

    @Override
    public String decrypt(String data) throws Exception {
        return Utils.decrypt(data);
    }
}
