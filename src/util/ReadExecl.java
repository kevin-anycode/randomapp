package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExecl {
	/**
	 * 
	 * @date 2012-4-19
	 * @author 刘凯
	 * 功能：读取execl
	 */
	public  List<String[]> readExcel(String sheetName, int beginCol,int endCol) {
		Workbook book = null;
		Sheet sheet = null;
		List<String[]> list = new ArrayList<String[]>();
		try {
			FileInputStream in = new FileInputStream(getExeclPath());
			book = Workbook.getWorkbook(in);
			//String sName = book.getSheet(0).getName();
			//System.out.println(sName);
			sheet = book.getSheet(sheetName);
			for (int i = beginCol; i <=endCol; i++) {
				Cell cell = null;
				String[] content = new String[sheet.getRows()];
				int begin = 0;
				for (int j = begin; j < sheet.getRows(); j++) {
					cell = sheet.getCell(i, j);
					content[j] = cell.getContents();
					//System.out.print(cell.getContents() + "\t");
				}
				list.add(content);
			}
		} catch (IOException e) {
			list.add(null);
			e.printStackTrace();
		} catch (BiffException e) {
			list.add(null);
			e.printStackTrace();
		} finally {
			if (sheet != null) {
				sheet = null;
			}
			if (book != null) {
				book = null;
			}
		}
		return list;
	}
	
	public  Vector<String> getAllExcelSheetName(){
		Workbook book = null;
		Vector<String> sNameList = new Vector<String>();
		try {
			FileInputStream in = new FileInputStream(getExeclPath());
			book = Workbook.getWorkbook(in);
			String sName = book.getSheet(0).getName();
			Sheet[] sheets = book.getSheets();
			for (int i = 0; i <sheets.length; i++) {
				String sheetName = sheets[i].getName();
				sNameList.add(sheetName);
			}
		} catch (Exception e) {
			sNameList.add(null);
			e.printStackTrace();
		} 
		return sNameList;
	}
	//获取experts.xls的相对路径，即：与randomapp.jar在同一路径下
	private String getExeclPath(){
		//String path = this.getClass().getResource("/experts.xls").getPath();//开发环境测试路径
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();//发布后的路径
		try {
			//String execlPath = path.replace("randomapp.jar", "experts.xls");
			//汉字转码 需要java.net.URLDecoder.decode(execlPath, "UTF-8");
			path = java.net.URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String execlPath = path.replace("randomapp.jar", "experts.xls");
		return execlPath;
	}
	
	public static void main(String[] args){
		//List<String[]> list = new ReadExecl().readExcel(0,5);
		String path = "D:/randomapp/randomapp.jar";
		String p = path.replace("randomapp.jar", "1234");
		System.out.println("===" + p);
	}
}
