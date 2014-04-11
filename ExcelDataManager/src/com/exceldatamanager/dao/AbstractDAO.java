package com.exceldatamanager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.exceldatamanager.exception.DataAccessException;

/**
 * Abstract DAO class.
 * 
 * @author Ribeiro_Josivan
 *
 */
public abstract class AbstractDAO implements DAOOperations {

	private HashMap<String, XSSFWorkbook> fileMap;
	
	private ArrayList<String> fileList;
	
	public HashMap<String, XSSFWorkbook> getFileMap() {
		return fileMap;
	}

	public void setFileMap(HashMap<String, XSSFWorkbook> fileMap) {
		this.fileMap = fileMap;
	}

	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}
	
	public ArrayList<String> getFileList() {
		if (fileList == null) {
			fileList = new ArrayList<String>();
		}
		return fileList;
	}

	public Cell getCellByLocation (String filename, int sheetNumber, int rowNumber, int cellNumber) throws DataAccessException {
		Cell cell = null;
		try {			
			XSSFWorkbook workbook = fileMap.get (filename);
			XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
	        Row row = sheet.getRow (rowNumber);
			cell = row.getCell (cellNumber);	    	
		} catch (Exception e) {
			throw new DataAccessException (e.getMessage());
		}
		return cell;		
	}
	
	public void saveChanges (String filename) throws DataAccessException {
		try {
			XSSFWorkbook workbook = fileMap.get (filename);
			FileOutputStream fos = new FileOutputStream (new File (filename));
			workbook.write (fos);
			fos.close();
		} catch (IOException e) {
			throw new DataAccessException (e.getMessage());
		}
	}
	
	/**
	 * Loads excel files.
	 * 
	 * @param force
	 * @param fileMap
	 * @param fileList
	 * @throws DataAccessException
	 */
	public void loadFiles (boolean force) throws DataAccessException {
		if (fileMap == null || force) {
			fileMap = new HashMap<String, XSSFWorkbook>();
			try {
				for (String filename: fileList) {
					FileInputStream file = new FileInputStream (new File (filename));
					XSSFWorkbook workbook = new XSSFWorkbook (file);
					fileMap.put (filename, workbook);
					file.close();
				}			
			} catch (Exception e) {
				throw new DataAccessException (e.getMessage());
			}
		}
	}	
	
}
