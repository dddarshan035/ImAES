package com.xonlabs.aes.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class EncryptionThread implements Runnable {

	public Thread t;
	String filepath;
	String secret;
	private static SecretKeySpec secretKey;
	private static byte[] key;
	private String destFolder;

	public EncryptionThread(String filepath, String secret, String destFolder) throws ParseException {
		this.filepath = filepath;
		this.secret = secret;
		this.destFolder = destFolder;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {

			File file = new File(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = "";
			String str = "";

			int i = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (i != 1)
					str += "\n";
				str += line;
			}

			br.close();

			String enc = encrypt(str, secret);
			System.out.println("input file .. " + filepath);
			File file2 = new File(
					destFolder + filepath.substring(filepath.lastIndexOf("\\"), filepath.length()) + ".enc");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
			bw.write(enc);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static void main(String arg[]) {
		String e = encrypt("Hello ashok ", "1234");
		System.out.println(e);

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
