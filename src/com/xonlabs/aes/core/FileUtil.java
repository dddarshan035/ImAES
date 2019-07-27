package com.xonlabs.aes.core;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static void merge(List<File> filesList, String dest) {
		FileOutputStream fos;
		FileInputStream fis;
		byte[] fileBytes;
		int bytesRead = 0;

		try {
			fos = new FileOutputStream(dest, true);
			for (File file : filesList) {
				fis = new FileInputStream(file);
				fileBytes = new byte[(int) file.length()];
				bytesRead = fis.read(fileBytes, 0, (int) file.length());
				assert (bytesRead == fileBytes.length);
				assert (bytesRead == (int) file.length());
				fos.write(fileBytes);
				fos.flush();
				fileBytes = null;
				fis.close();
				fis = null;
			}
			fos.close();
			fos = null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public static int split(String FILE_NAME) throws IOException {
		File inputFile = new File(FILE_NAME);
		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = (int) inputFile.length();
		int nChunks = 0, read = 0, readLength = fileSize / 5;
		byte[] byteChunkPart;
		try {
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0) {
				if (fileSize <= 5) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				newFileName = FILE_NAME + ".part" + Integer.toString(nChunks - 1);
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
			}
			
			inputStream.close();
			return nChunks-1;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public static void main(String[] args) throws IOException {
		List<File> files = new ArrayList<>();
		files.add(new File("C:\\AES\\data\\sample.txt.part0.enc.dec"));
		files.add(new File("C:\\AES\\data\\sample.txt.part1.enc.dec"));
		files.add(new File("C:\\AES\\data\\sample.txt.part2.enc.dec"));
		files.add(new File("C:\\AES\\data\\sample.txt.part3.enc.dec"));
		files.add(new File("C:\\AES\\data\\sample.txt.part4.enc.dec"));
		files.add(new File("C:\\AES\\data\\sample.txt.part5.enc.dec"));
		merge(files, "C:\\AES\\data\\merged.txt");
	}
}