package com.example.myapplication.interfaces;

public interface CryptoMethods {
    String encrypt(String body) throws Exception;

    String decrypt(String data) throws Exception;
}
