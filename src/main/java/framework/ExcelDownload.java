package framework;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDownload {
public void excelDownload() {
	String sFileName = "filename1" + ".xlsx";
	//sFileName = new String ( sFileName.getBytes("KSC5601"), "8859_1");
	 
//	response.reset();  //엑셀 한글 깨짐 방지
//	 
//	String strClient = request.getHeader("User-Agent");
	String fileName = sFileName;
	 
//	response.setCharacterEncoding("UTF-8");
//    response.setHeader("Pragma","public");
//    response.setHeader("Expires","0");
    
//	if (strClient.indexOf("MSIE 5.5") > -1) {
//	    response.setHeader("Content-Disposition", "filename=" + fileName + ";");
//	} else {
//	    response.setContentType("application/vnd.ms-excel");
//	    response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
//	}
	 
	OutputStream fileOut = null;
	XSSFWorkbook objWorkBook = new XSSFWorkbook();
	XSSFSheet objSheet = objWorkBook.createSheet("sheet1");
	XSSFRow objRow = null;
	XSSFCell objCell = null;
	DataValidation dataValidation = null;
	DataValidationConstraint constraint = null;
	DataValidationHelper validationHelper = null;

	// Cell style(border & fontColor-BLUE)
	XSSFCellStyle blueStyle = objWorkBook.createCellStyle();
	
	blueStyle.setBorderTop(CellStyle.BORDER_THIN);
	blueStyle.setBorderBottom(CellStyle.BORDER_THIN);
	blueStyle.setBorderLeft(CellStyle.BORDER_THIN);
	blueStyle.setBorderRight(CellStyle.BORDER_THIN);
	XSSFFont blueFont = objWorkBook.createFont();
	blueFont.setColor(IndexedColors.BLUE.getIndex());
	blueStyle.setFont(blueFont);
	 
	// Cell style(border & backgroundColor & align)
	XSSFCellStyle criticalStyle = objWorkBook.createCellStyle();
	criticalStyle.setFillForegroundColor(IndexedColors.RED.index);
	criticalStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	criticalStyle.setBorderTop(CellStyle.BORDER_THIN);
	criticalStyle.setBorderBottom(CellStyle.BORDER_THIN);
	criticalStyle.setBorderLeft(CellStyle.BORDER_THIN);
	criticalStyle.setBorderRight(CellStyle.BORDER_THIN);
	criticalStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	XSSFFont whiteFont = objWorkBook.createFont();
	whiteFont.setColor(IndexedColors.WHITE.getIndex());
	criticalStyle.setFont(whiteFont);
	
	objRow = objSheet.createRow(2);
	objCell = objRow.createCell(0);
	objCell.setCellValue("협력사 명");
	//objCell.setCellStyle(titleStyle);
	objCell = objRow.createCell(1);
	objCell.setCellValue("주문 확정 일시");
	//objCell.setCellStyle(titleStyle);
	objCell = objRow.createCell(2);
	objCell.setCellValue("주문 번호");
	//objCell.setCellStyle(titleStyle);
	objCell = objRow.createCell(3);
	objCell.setCellValue("수취인");
	//objCell.setCellStyle(titleStyle);

	
	int startRowNum = 3;
	int endRowNum = 3+startRowNum; // 시작Row + 데이터 길이
	int total = 0;
	for(int i=startRowNum; i<endRowNum; i++){
	    // ...생략
	     
	    objRow = objSheet.createRow(i);
	    objCell = objRow.createCell(0);
	    objCell.setCellValue("111");
	    objCell.setCellStyle(blueStyle);
	    objCell = objRow.createCell(1);
	    objCell.setCellValue(111);
	    objCell.setCellStyle(blueStyle);
	    objCell = objRow.createCell(2);
	    objCell.setCellValue(111);
	    objCell.setCellStyle(blueStyle);
	    objCell = objRow.createCell(3);
	    objCell.setCellValue(111);
	    objCell.setCellStyle(blueStyle);
	}
	    // ...생략
	     
	  /*  if(_flag == "Y"){ // 상황에 맞게 스타일 적용 해주고..
	        objCell.setCellStyle(blueStyle);
	    } else {
	        objCell.setCellStyle(redStyle);
	    }*/
	   //fileOut = response.getOutputStream();
	    
	    try {
			objWorkBook.write(fileOut);
			objWorkBook.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
