package com.exceldatamanager.dao.impl;

import org.apache.poi.ss.usermodel.Cell;

import com.exceldatamanager.dao.AbstractDAO;
import com.exceldatamanager.dao.CashFlowDAO;
import com.exceldatamanager.exception.DataAccessException;
import com.exceldatamanager.vo.CashFlowVO;

public class CashFlowDAOImpl extends AbstractDAO implements CashFlowDAO {

	private static final CashFlowDAOImpl INSTANCE = new CashFlowDAOImpl ();	
	private static final String FILE_1 = ".\\input\\FC_SITES_PORTALRS.xlsx";
	private static final String FILE_2 = ".\\input\\FC_SITES_PORTALRS_2.xlsx";
	private static final String FILE_3 = ".\\output\\Planilha_Consolidadora.xlsx";
	private static final String FILE_4 = ".\\output\\Planilha_Consolidadora_2.xlsx";
	
	public static CashFlowDAOImpl getInstance () {
		return INSTANCE;
	}
	
	private CashFlowDAOImpl () {
		try {
			init ();
		} catch (DataAccessException e) {			
			e.printStackTrace();
		}
	}	
	
	/**
	 * Initializes the input file read operation.
	 * 
	 * @throws DataAccessException
	 */
	private void init () throws DataAccessException {
		getFileList().add (FILE_1);
		getFileList().add (FILE_2);
		getFileList().add (FILE_3);
		getFileList().add (FILE_4);
		loadFiles (false);
	}	
	
	@Override
	public CashFlowVO getTotalFlow() throws DataAccessException {
		CashFlowVO cashFlowVO = null;
		String clientName = null;
		String projectName = null;
		String serviceName = null;
		
		// gets the client name
		Cell clientCell = getCellByLocation (FILE_1, 6, 1, 3);
		// gets the project name
		Cell projectCell = getCellByLocation (FILE_1, 6, 2, 3);
		
		// gets the servico eAcesso
		Cell serviceCell = getCellByLocation (FILE_1, 6, 2, 12);		
		
		if (clientCell != null) {
			clientName = clientCell.getStringCellValue();
		}
		if (projectCell != null) {
			projectName = projectCell.getStringCellValue();
		}
		if (serviceCell != null) {
			serviceName = serviceCell.getStringCellValue();
		}
		
		cashFlowVO = new CashFlowVO ();
		cashFlowVO.setClientName (clientName);
		cashFlowVO.setProjectName (projectName);
		cashFlowVO.setServiceName (serviceName);
		
		return cashFlowVO;
	}

	@Override
	public void updateTotalFlow (CashFlowVO cashFlowVO) throws DataAccessException {
		// gets the client name
		Cell clientCell = getCellByLocation (FILE_3, 3, 1, 1);
		// gets the project name
		Cell projectCell = getCellByLocation (FILE_3, 3, 1, 2);
		// gets the service name
		Cell serviceCell = getCellByLocation (FILE_3, 3, 1, 3);
		
		if (clientCell != null) {
			clientCell.setCellValue (cashFlowVO.getClientName());
		}
		if (projectCell != null) {
			projectCell.setCellValue (cashFlowVO.getProjectName());
		}
		if (serviceCell != null) {
			serviceCell.setCellValue (cashFlowVO.getServiceName());
		}
		// saves the changes in the file
		saveChanges (FILE_3);		
	}

	@Override
	public void test() throws DataAccessException {
		String clientName = null;
				
		// logic to read a value 
		// gets the client name
		Cell clientCell = getCellByLocation (FILE_1, 6, 1, 3);
				
		if (clientCell != null) {
			clientName = clientCell.getStringCellValue();
		}
		
		// logic to update a value
		Cell clientOuputCell = getCellByLocation (FILE_3, 3, 1, 1);
		if (clientOuputCell != null) {
			clientOuputCell.setCellValue (clientName);
		}
		// saves the changes in the file
		saveChanges (FILE_3);		
	}	
	 

}
