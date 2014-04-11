package com.exceldatamanager.service.impl;

import com.exceldatamanager.dao.CashFlowDAO;
import com.exceldatamanager.dao.impl.CashFlowDAOImpl;
import com.exceldatamanager.exception.BusinessException;
import com.exceldatamanager.exception.DataAccessException;
import com.exceldatamanager.service.CashFlowService;
import com.exceldatamanager.vo.CashFlowVO;

public class CashFlowServiceImpl implements CashFlowService {

	private static final CashFlowServiceImpl INSTANCE = new CashFlowServiceImpl ();
	
	private CashFlowDAO cashFlowDAO = CashFlowDAOImpl.getInstance();
	
	private CashFlowServiceImpl () {}
	
	public static CashFlowServiceImpl getInstance () {
		return INSTANCE;
	}
	
	@Override
	public void partialConsolidation () throws BusinessException {
		try {
			CashFlowVO cashFlowVO = cashFlowDAO.getTotalFlow();			
			cashFlowDAO.updateTotalFlow (cashFlowVO);			
		} catch (DataAccessException e) {
			throw new BusinessException (e.getMessage());
		}
	}

}
