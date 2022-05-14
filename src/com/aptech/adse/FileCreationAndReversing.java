package com.aptech.adse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This creation-Reversing the content-extrating-replacement
 * 
 * 
 * @author Elisha Ayomide Lawal
 * @author Opeoluwa Olagoke
 * @author Jim Damilola Olumide
 * @author Adam Abanum Ogbolu
 *
 */

public class FileCreationAndReversing {

	// Declare variables to hold content of first and second files
	private String firstFileContent = "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.\n It is a general-purpose programming language intended to let programmers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need to recompile.\n Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture.\n";

	private String secondFileContent;

	/**
	 * Create first file for this program This is more like the root file
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void createFirstFile() throws IOException, InterruptedException {

		File firstFile = this.createFile("firstFile", firstFileContent);
		System.out.println("First File Created. Filename: " + firstFile.getName());

		Thread.sleep(1500);
		
		this.reverseFirstFileContent(firstFileContent);

	}

	/**
	 * Reverses the content specified and save into a new file
	 * 
	 * @param content
	 */
	private void reverseFirstFileContent(String content) {
		StringBuilder sb = new StringBuilder(content);
		sb.reverse();
		secondFileContent = sb.toString();
		try {
			this.createSecondFile(secondFileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Creates the second file that contain the reversed format from first created
	 * file.
	 * 
	 * @param content the reversed content to be added to the new file
	 * @throws IOException
	 */
	private void createSecondFile(String content) throws IOException {
		// Create second file into assets directory
		File newFile = this.createFile("secondfile", content);

		System.out.println("\nReversed content of the first file saved into " + newFile.getName() + "\n");

		this.compareFirstAndSecondFiles();
	}

	private void compareFirstAndSecondFiles() {
		try {
			Thread.sleep(1500);
			System.out.println("Please wait...Comparing content of first and second file");
			Thread.sleep(2500);

			if (firstFileContent.equals(secondFileContent)) {
				System.out.println("First and second file contents matches\n");
			} else {
				System.out.println("First and second file contents do not match.\n");
			}
		} catch (Exception e) {

		}

		this.extractAndReplace();
	}

	private void extractAndReplace() {
		String extractResult;
		Scanner scanner = new Scanner(System.in);
		String wordToExtract, wordToReplace;
		try {
			Thread.sleep(1500);
			System.out.println("Displaying first file contents...\n");
			Thread.sleep(2000);
			System.out.println(firstFileContent);
			Thread.sleep(1500);
			System.out.println("Please provide word to be extracted and replaced from the content above");
			Thread.sleep(1000);

			System.out.print("Enter word to extract: ");
			wordToExtract = scanner.next();

			System.out.print("Enter word to replace with: ");
			wordToReplace = scanner.next();

			extractResult = firstFileContent.replaceAll(wordToExtract, wordToReplace);

			this.createThirdFile(extractResult);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	private void createThirdFile(String extractResult) {
		// Create second file into assets directory
		File newFile = this.createFile("thirdfile", extractResult);

		System.out.println("\nExtract and replace result saved into " + newFile.getName() + "\n");
	}

	/**
	 * Convert first file content to byte codes
	 */
	public void convertFirstFileDataToByteCodes() {
		byte[] bytecode = firstFileContent.getBytes();

		try {
			Thread.sleep(1500);
			System.out.println("Converting first file data to bytecodes...");
			this.createFile("fourthfile", bytecode);
			Thread.sleep(2000);
			System.out.println("First file data converted to bytecodes sucessfully!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Creates a new file and write data into it
	 * 
	 * @param name    Name of file to be created
	 * @param content Content of the file to be created
	 * @return File
	 */
	private File createFile(String name, Object content) {

		File newFile = new File("assets", name + "_" + System.currentTimeMillis() + ".txt");

		try {
			newFile.createNewFile();
		} catch (IOException e) {

		} catch (Exception e) {

		}

		// Write content provided by user into file created above
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
			writer.write(content.toString());
			writer.newLine();
		} catch (IOException e) {

		} catch (Exception e) {

		}

		return newFile;
	}
}
