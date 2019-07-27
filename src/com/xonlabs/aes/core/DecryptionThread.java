package com.xonlabs.aes.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DecryptionThread implements Runnable {

	public Thread t;
	String filepath;
	String secret;
	private static SecretKeySpec secretKey;
	private static byte[] key;
	private String res_folder;

	public DecryptionThread(String filepath, String secret, String res_folder) throws ParseException {
		this.res_folder = res_folder;
		this.filepath = filepath;
		this.secret = secret;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			File file = new File(filepath);
			System.out.println("File path .. " + filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = "";
			String str = "";
			while ((line = br.readLine()) != null) {
				str += line;

			}
			br.close();
			String dec = decrypt(str, secret);
			File file2 = new File(
					res_folder + "\\" + filepath.substring(filepath.lastIndexOf("\\"), filepath.length()) + ".dec");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
			bw.write(dec);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) throws IOException {
		// File file = new File("C:\\data2\\sample.txt.part0.enc");
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream(file)));
		// String line = "";
		// String str = "";
		// while ((line = br.readLine()) != null) {
		// str += line;
		//
		// }1234
		// br.close();
		//
		// System.out.println(decrypt(str, ""));
		System.out.println(decrypt(
				"q5IDiloDTMGJpJZaJO2tpTddbgXc8APn7bAekUpmi1jil0xLEflXrQ+n1xqpev39fiaLp2HJRdt+sX9sS4UQ43D0Dgg2CT1MUI2KV0ip6nr2t4V1rgGV3U+AkYqq8Lry",
				"1234"));
	}

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			System.out.println("Secret key .. " + secret);
			System.out.println("String todecrypt .. " + strToDecrypt);
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
