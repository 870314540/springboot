package com.example.demo.common;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ExcelUtil {
    private final static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 检查文件是否存在
     *
     * @param filePath
     * @return
     */
    private static boolean validateExcel(String filePath) {
        if (filePath == null
                || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            log.error("文件名不是excel格式");
            return false;
        }
        //检查文件是否存在
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            log.error("文件不存在");
            return false;
        }
        return true;
    }

    public static List<List<String>> read(String filePath) {
        List<List<String>> dataLst = new ArrayList<List<String>>();
        InputStream is = null;
        try {
            // 验证文件是否合法
            if (!validateExcel(filePath)) {
                return null;
            }
            //判断文件的类型，是2003还是2007
            boolean isExcel2003 = true;
            if (isExcel2007(filePath)) {
                isExcel2003 = false;
            }
            File file = new File(filePath);
            is = new FileInputStream(file);
            dataLst = read(is, isExcel2003);
            is.close();
        } catch (Exception ex) {
            log.error("excel 读取失败：【{}】", filePath);
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return dataLst;
    }


    public static List<List<String>> read(InputStream inputStream, boolean isExcel2003) {
        List<List<String>> dataLst = null;
        try {
            //根据版本创建WB
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            dataLst = read(wb);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return dataLst;
    }

    private static List<List<String>> read(Workbook wb) {
        List<List<String>> dataLst = new ArrayList<List<String>>();

        Sheet sheet = wb.getSheetAt(0);
        //得到总行数
        int totalRows = sheet.getPhysicalNumberOfRows();

        int totalCells = 0;
        //得到列数
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        //循环读取行
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            List<String> rowLst = new ArrayList<String>();
            //循环读取列
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowLst.add(cellValue);
            }
            /** 保存第r行的第c列 */
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    /**
     * 后缀判断是不是03版
     *
     * @param filePath
     * @return
     */
    static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 后缀判断是不是07版
     *
     * @param filePath
     * @return
     */
    static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * excel 写入
     *
     * @param title
     * @param content
     * @throws IOException
     */

    public void write(List<String> title, List<List<String>> content) {

        //创建excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
//        //插入第一行数据的表头
//        for (int i = 0; i < title.size(); i++) {
//            cell = row.createCell(i);
//            cell.setCellValue(title.get(i));
//        }
        //写入数据
        for (int i = 0; i < content.size(); i++) {
            HSSFRow nrow = sheet.createRow(i);
            HSSFCell ncell = nrow.createCell(0);
            ncell.setCellValue(content.get(i).get(0));
            ncell = nrow.createCell(1);
            ncell.setCellValue(content.get(i).get(1));
            ncell = nrow.createCell(2);
            ncell.setCellValue(content.get(i).get(2));
        }
        //创建excel文件
        File file = new File("poi.xlsx");
        try {
            file.createNewFile();
            //将excel写入
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        String str = "测试内容";
        //密码，长度要是8的倍数
//        String password = "rrx123456";
//        byte[] result = DesUtil.desCrypto(str.getBytes(), password);
//        System.out.println("加密后内容为：" + new String(result));


        ExcelUtil poi = new ExcelUtil();
        List<List<String>> list = poi.read("111.xlsx");
        List<List<String>> resultList = new LinkedList<>();
        if (list != null) {
            for (int i = 1; i < list.size(); i++) {
                List<String> cellList = list.get(i);
                List<String> cell1 = new LinkedList<>();
                for (int j = 0; j < cellList.size(); j++) {
                    System.out.print( " " + cellList.get(j));
                    String result = DesUtil.encrypt(cellList.get(j));
                    cell1.add(result);
                }
                System.out.println();
                resultList.add(cell1);
            }

        }
        List<String> title = new ArrayList<>();
//        title.add("name");
//        title.add("phone");
//        title.add("card");
        poi.write(title, resultList);

    }

}
