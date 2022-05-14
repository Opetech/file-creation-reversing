package com.aptech.adse;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FileCreationAndReversing frc = new FileCreationAndReversing();
		try {
			frc.createFirstFile();
			frc.convertFirstFileDataToByteCodes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
