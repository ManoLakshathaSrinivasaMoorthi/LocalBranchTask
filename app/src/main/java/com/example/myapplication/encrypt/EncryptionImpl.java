package com.example.myapplication.encrypt;

import com.example.myapplication.cryptomodel.Utils;
import com.example.myapplication.interfaces.CryptoMethods;

public class EncryptionImpl implements CryptoMethods {
    @Override
    public String encrypt(String body) throws Exception {
        return Utils.encrypt(body);
    }

    @Override
    public String decrypt(String data) {
        return null;
    }
}
