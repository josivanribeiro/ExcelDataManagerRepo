package com.exceldatamanager.dao;

import com.exceldatamanager.exception.DataAccessException;
import com.exceldatamanager.vo.CashFlowVO;

/**
 * Cash Flow DAO interface.
 * 
 * @author Ribeiro_Josivan
 *
 */
public interface CashFlowDAO {

	/**
	 * Gets the total flow.
	 * 
	 * @return
	 */
	public CashFlowVO getTotalFlow () throws DataAccessException;
	
	/**
	 * Sets the total flow.
	 * @param cashFlowVO
	 * @throws DataAccessException
	 */
	public void updateTotalFlow (CashFlowVO cashFlowVO) throws DataAccessException;
	
}
