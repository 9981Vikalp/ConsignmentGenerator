package com.example.ConsignmentNoteNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ConsignmentNoteNumberGenerator.controller.ConsignmentController;
import com.example.ConsignmentNoteNumberGenerator.pojo.ConsignmentGenerator;
import com.example.ConsignmentNoteNumberGenerator.service.ConsignmentService;

@SpringBootTest
class ConsignmentNoteNumberGeneratorApplicationTests {

	@Autowired
	ConsignmentService consignmentService;
	@Autowired
	ConsignmentController consignmentController;

	@Test
	void contextLoads() {

	}

	@Test
	public void TestForCorrectConsignmentService() {
		ConsignmentGenerator cGobj = new ConsignmentGenerator();
		cGobj.setCarrierName("FreightMateCourierCo");
		cGobj.setAccountNumber("123ABC");
		cGobj.setDigits(10);
		cGobj.setLastUsedIndex(19604);
		cGobj.setRangeStart(19000);
		cGobj.setRangeEnd(20000);

		String canNoteNumber = consignmentService.canNotGeneratorService(cGobj);
		System.out.println(canNoteNumber);
		assertEquals("FMCC123ABC00000196051", consignmentService.canNotGeneratorService(cGobj));
	}

	@Test
	public void TestLastIndexSameAsStartRange() {
		ConsignmentGenerator cGobj = new ConsignmentGenerator();
		cGobj.setCarrierName("FreightMateCourierCo");
		cGobj.setAccountNumber("123ABC");
		cGobj.setDigits(10);
		cGobj.setLastUsedIndex(19000);
		cGobj.setRangeStart(19000);
		cGobj.setRangeEnd(20000);

		String canNoteNumber = consignmentService.canNotGeneratorService(cGobj);
		System.out.println(canNoteNumber);
		assertEquals("FMCC123ABC000001900131", consignmentService.canNotGeneratorService(cGobj));
	}

	@Test
	public void TestLastIndexLessThanStartRange() {
		ConsignmentGenerator cGobj = new ConsignmentGenerator();
		cGobj.setCarrierName("FreightMateCourierCo");
		cGobj.setAccountNumber("123ABC");
		cGobj.setDigits(10);
		cGobj.setLastUsedIndex(19604);
		cGobj.setRangeStart(21000);
		cGobj.setRangeEnd(30000);

		String canNoteNumber = consignmentService.canNotGeneratorService(cGobj);
		System.out.println(canNoteNumber);
		assertEquals("Connote Number not in Range21000-30000", consignmentService.canNotGeneratorService(cGobj));
	}

	@Test
	public void TestLastIndexGreaterThanEndRange() {
		ConsignmentGenerator cGobj = new ConsignmentGenerator();
		cGobj.setCarrierName("FreightMateCourierCo");
		cGobj.setAccountNumber("123ABC");
		cGobj.setDigits(10);
		cGobj.setLastUsedIndex(31000);
		cGobj.setRangeStart(21000);
		cGobj.setRangeEnd(30000);

		String canNoteNumber = consignmentService.canNotGeneratorService(cGobj);
		System.out.println(canNoteNumber);
		assertEquals("Connote Number not in Range21000-30000", consignmentService.canNotGeneratorService(cGobj));
	}

	@Test
	public void TestForCorrectController() {
		ConsignmentGenerator cGobj = new ConsignmentGenerator();
		cGobj.setCarrierName("FreightMateCourierCo");
		cGobj.setAccountNumber("123ABC");
		cGobj.setDigits(10);
		cGobj.setLastUsedIndex(19604);
		cGobj.setRangeStart(19000);
		cGobj.setRangeEnd(20000);

		String canNoteNumber = consignmentController.canNoteGenerator(cGobj);
		System.out.println(canNoteNumber);
		assertEquals("FMCC123ABC00000196051", consignmentController.canNoteGenerator(cGobj));
	}

}
