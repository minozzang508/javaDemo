package playground.ExcelUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


//Apache poi 라이브러리 활용
public class excelUtil {

    //values에 해당하는 엑셀 파일 생성하기
    public static void createExcel(String fileName, String destinationPath, List<Map<String, String>> values) throws IOException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);


        Iterator it = values.get(0).keySet().iterator();
        int i = 0;

        while(it.hasNext()){
            String attribute = (String)it.next();
            Cell cell = headerRow.createCell(i++);
            cell.setCellValue(attribute);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        i = 0;
        for(Map<String, String> value: values) {

            Row row = sheet.createRow(rowNum++);

            Iterator it2 = values.get(0).keySet().iterator();

            while(it2.hasNext()){
                String val = value.get(it2.next());
                if(val != null && val.length() < 32767){
                    row.createCell(i).setCellValue(val);
                }
                i++;
            }
            i = 0;
        }

        // Resize all columns to fit the content size
        Iterator<String> it2 = values.get(0).keySet().iterator();
        i = 0;
        while(it.hasNext()){
            sheet.autoSizeColumn(i++);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(destinationPath + fileName);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    //values 리스트를 return
    public static List<Map<String, String>> readExcel(String fileName, String destinationPath) throws IOException {
        List<Map<String, String>> values = new ArrayList<>();
        String[] keys;
        //파일을 읽기위해 엑셀파일을 가져온다
        FileInputStream fis=new FileInputStream(destinationPath + fileName);
        HSSFWorkbook workbook=new HSSFWorkbook(fis);

        int rowindex=0;
        int columnindex=0;

        try{
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            HSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();

            int keyIdx = 0;
            HSSFRow headerRow = sheet.getRow(0);
            //셀의 수
            int cells = headerRow.getPhysicalNumberOfCells();
            keys = new String[cells];
            for(rowindex=0;rowindex<rows;rowindex++) {
                //행을 읽는다
                HSSFRow row = sheet.getRow(rowindex);
                //List에 담을 Map 변수
                Map<String, String> val = new HashMap<>();
                Boolean flag = false;
                for (columnindex = 0; columnindex < cells; columnindex++) {

                    if (rowindex == 0) {
                        keys[keyIdx++] = row.getCell(columnindex).getStringCellValue();
                    } else {
                        flag = true;
                        //셀값을 읽는다
                        HSSFCell cell = row.getCell(columnindex);
                        String value = "";

                        //타입별로 내용 읽기
                        switch (cell.getCellTypeEnum()) {
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case BOOLEAN:
                                value = Boolean.toString(cell.getBooleanCellValue());
                                break;
                            case NUMERIC:
                                value = Double.toString(cell.getNumericCellValue());
                                break;
                            case BLANK:
                                value = null;
                                break;
                            case ERROR:
                                throw new Exception("cell type이 이상함.");

                        }

                        val.put(keys[columnindex], value);
                    }
                }

                if(flag) {
                    values.add(val);
                }
            }
        }catch(Exception e) {
            e.getMessage();
        }

        return values;
    }


//    public static void main(String[] args) throws IOException {
//        List<Map<String, String>> before = readExcel("D:\\작업일지\\180828\\기능개선요구사항\\","jiri_list.xls");
//        List<Map<String, String>> after = new ArrayList<>();
//
//        for(Map<String, String> map : before) {
//
//            String manip = StringUtil.eraseTag(map.get("NTT_CN"));
//            map.put("NTT_CN", manip);
//
//            after.add(map);
//        }
//
//        //가공하쟈
//        createExcel("jiri.xlsx", "D:\\작업일지\\180828\\기능개선요구사항\\", after);
//    }
}
