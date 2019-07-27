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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_Improved {

	private static SecretKeySpec secretKey;
	private static byte[] key;

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

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void encryptFile(String filepath, String secret) throws IOException {
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
		File file2 = new File(filepath + ".enc");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
		bw.write(enc);
		bw.close();

	}

	public static void decryptFile(String filepath, String secret) throws IOException {
		File file = new File(filepath);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = "";
		String str = "";
		while ((line = br.readLine()) != null) {
			str += line;

		}
		br.close();
		String dec = decrypt(str, secret);
		File file2 = new File(filepath + ".dec");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
		bw.write(dec);
		bw.close();

	}

	// With Threads
	public static void main(String arg[]) throws IOException {

//		String secret = "ashok@aklc";
//		String filepath = "C:\\AES\\data\\sample.txt";
//		// long st = System.currentTimeMillis();
//		// int n = FileUtil.split("C:\\AES\\data\\sample.txt");
//		List<EncryptionThread> encThreads = new ArrayList<>();
//		List<DecryptionThread> decThreads = new ArrayList<>();
//
//		// Encryption
//		for (int i = 0; i <= n; i++) {
//			EncryptionThread et = new EncryptionThread(filepath + ".part" + i, secret);
//			encThreads.add(et);
//		}
//		try {
//			for (EncryptionThread e : encThreads) {
//				e.t.join();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		long en = System.currentTimeMillis();
//
//		// Decryption
//		// long st = System.currentTimeMillis();
//		// int n = 4;
//		// for (int i = 0; i <= n; i++) {
//		// DecryptionThread dt = new DecryptionThread(filepath + ".part" + i +
//		// ".enc", secret, "C:\\data");
//		// decThreads.add(dt);
//		// }
//		// try {
//		// for (DecryptionThread d : decThreads) {
//		// d.t.join();
//		// }
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//		//
//		// List<File> fileList = new ArrayList<>();
//		// for (int i = 0; i <= n; i++) {
//		// fileList.add(new File(filepath + ".part" + i + ".enc.dec"));
//		// }
//		// FileUtil.merge(fileList, "C:\\data\\merged.txt");
//		long en = System.currentTimeMillis();
//		System.out.println("Time taken .. " + (en - st));

		System.out.println("Done");
	}

}