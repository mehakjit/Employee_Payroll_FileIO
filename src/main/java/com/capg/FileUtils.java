package com.capg;

import java.io.File;

public class FileUtils {
	public static void deleteFiles(File deleteThisFile) {
		File[] allFilesContent = deleteThisFile.listFiles();
		for (File file : allFilesContent) {
			if (file.isDirectory()) {
				System.out.println("Deleting files : " + file.toString());
				deleteFiles(file);
				file.delete();
				System.out.println("File deleted");
			} else {
				//System.out.println("File is open or error");
				file.delete();
			}
		}
		deleteThisFile.delete();
	}
}
