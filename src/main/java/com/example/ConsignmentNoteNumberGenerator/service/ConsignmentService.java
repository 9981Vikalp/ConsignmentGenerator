package com.example.ConsignmentNoteNumberGenerator.service;

import org.springframework.stereotype.Service;

import com.example.ConsignmentNoteNumberGenerator.pojo.ConsignmentGenerator;

@Service
public class ConsignmentService {

	public String canNotGeneratorService(ConsignmentGenerator consignmentGenerator) {

		String connotePresentNumber = "";
		if (consignmentGenerator.getLastUsedIndex() >= consignmentGenerator.getRangeStart() && consignmentGenerator.getLastUsedIndex() < consignmentGenerator.getRangeEnd()) {
			String frountCannote = consignmentGenerator.getCarrierName();
			char[] charArray = frountCannote.toCharArray();
			String frountCanoteName = "";
			for (int i = 0; i < charArray.length; i++) {
				if (Character.isUpperCase(charArray[i])) {
					frountCanoteName += charArray[i];
				}
			}
			int presentIndex = consignmentGenerator.getLastUsedIndex() + 1;// incrementing index by 1
			String consignmentIndex = String.format("%0" + consignmentGenerator.getDigits() + "d", presentIndex);
			int checkSum = checkSum(consignmentIndex, consignmentGenerator.getDigits());
			connotePresentNumber = frountCanoteName + consignmentGenerator.getAccountNumber() + consignmentIndex
					+ String.valueOf(checkSum);
		} else {
			connotePresentNumber = "Connote Number not in Range" + consignmentGenerator.getRangeStart() + "-"
					+ consignmentGenerator.getRangeEnd();
		}
		return connotePresentNumber;
	}

	private int checkSum(String consignmentIndex, int digit) {
		//returning sum on the basis of consimentindex and digit.
		int sum = 0;
		int firstSum = 0;
		int secondSum = 0;
		char[] consignmentChar = consignmentIndex.toCharArray();

		for (int i = consignmentChar.length - 1; i >= 0; i = i - 2) {
			firstSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
		}

		for (int i = consignmentChar.length - 2; i >= 0; i = i - 2) {
			secondSum += Integer.parseInt(String.valueOf(consignmentChar[i]));
		}
		//getting diffrence to add it in last index in string format//
		sum = Math.abs((digit * 10) - (firstSum * 3 + secondSum * 7));
		return sum;
	}

}
