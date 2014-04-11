package com.exceldatamanager.service;

import com.exceldatamanager.exception.BusinessException;

/**
 * CashFlow Service interface.
 * 
 * @author Ribeiro_Josivan
 *
 */
public interface CashFlowService {

	/**
	 * Performs the partial consolidation.
	 * 
	 * @throws BusinessException
	 */
	public void partialConsolidation () throws BusinessException;
	
}
