package com.exceldatamanager.dao;

import org.apache.poi.ss.usermodel.Cell;

import com.exceldatamanager.exception.DataAccessException;

/**
 * DAO Operations interface.
 * 
 * @author Ribeiro_Josivan
 *
 */
public interface DAOOperations {

	/**
	 * Loads excel files.
	 * 
	 * @param force
	 * @throws DataAccessException
	 */
	public void loadFiles (boolean force) throws DataAccessException;
	
	/**
	 * Gets the cell by row number and cell number.
	 * 
	 * @param filename
	 * @param sheetNumber
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws DataAccessException
	 */
	public Cell getCellByLocation (String filename, int sheetNumber, int rowNumber, int cellNumber) throws DataAccessException;
	
	/**
	 * Saves the changes on the excel file.
	 * 
	 * @param filename
	 * @throws DataAccessException
	 */
	public void saveChanges (String filename) throws DataAccessException;
	
}
