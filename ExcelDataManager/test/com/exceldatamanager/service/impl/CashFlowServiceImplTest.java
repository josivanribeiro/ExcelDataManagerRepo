package com.exceldatamanager.service.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.exceldatamanager.exception.BusinessException;
import com.exceldatamanager.service.CashFlowService;

@RunWith(JUnit4.class)
public class CashFlowServiceImplTest {

	private CashFlowService cashFlowService;
	
	@Before
	public void setUp() throws Exception {
		cashFlowService = CashFlowServiceImpl.getInstance();
	} 
	
	
	@Test
	public void testPartialConsolidation() {
		try {
			cashFlowService.partialConsolidation();
		} catch (BusinessException e) {
			fail (e.getMessage());
		}
	}
	
}
