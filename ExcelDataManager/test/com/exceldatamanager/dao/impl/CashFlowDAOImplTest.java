package com.exceldatamanager.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.exceldatamanager.dao.CashFlowDAO;
import com.exceldatamanager.exception.DataAccessException;
import com.exceldatamanager.vo.CashFlowVO;

@RunWith(JUnit4.class)
public class CashFlowDAOImplTest {

	private CashFlowDAO cashFlowDAOImpl;
	
	@Before
	public void setUp() throws Exception {
		cashFlowDAOImpl = CashFlowDAOImpl.getInstance();
	} 
	
	
	@Test
	public void testGetTotalFlow() throws DataAccessException {
		CashFlowVO cashFlowVO = cashFlowDAOImpl.getTotalFlow();
		assertNotNull ("totalFlow is null", cashFlowVO);
	}
	
	@Test
	public void testUpdateTotalFlow(){
		CashFlowVO cashFlowVO = new CashFlowVO ();
		cashFlowVO.setClientName ("ClientName");
		cashFlowVO.setProjectName("ProjectName");
		try {
			cashFlowDAOImpl.updateTotalFlow (cashFlowVO);
		} catch (DataAccessException e) {
			fail (e.getMessage());
		}
	}
	
}
