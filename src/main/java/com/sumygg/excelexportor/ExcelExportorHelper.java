package com.sumygg.excelexportor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.beans.PropertyDescriptor;
import java.util.List;

/**
 * excel 导出辅助类
 *
 * @author SumyGG
 * @since 2018-06-11
 */
public class ExcelExportorHelper {

    /**
     * 导出文件到Excel
     *
     * @param sheet   excel工作表
     * @param columns 工作表列定义
     * @param data    需要导出的数据
     */
    public static void exportWithHeader(Sheet sheet, List<ExcelRowColumn> columns, List<?> data) {
        if (sheet == null) {
            throw new IllegalArgumentException("sheet can't be null");
        }
        if (columns == null || columns.size() == 0) {
            throw new IllegalArgumentException("columns can't be null");
        }
        // 导出Header
        Row headerRow = sheet.createRow(0);
        int cnt = 0;
        for (ExcelRowColumn column : columns) {
            Cell cell = headerRow.createCell(cnt);
            cnt++;
            cell.setCellValue(column.getHeaderName());
        }
        // 导出数据
        cnt = 1;
        for (Object item : data) {
            Class<?> clazz = item.getClass();
            int i = 0;
            Row row = sheet.createRow(cnt);
            cnt++;
            for (ExcelRowColumn column : columns) {
                try {
                    Cell cell = row.createCell(i);
                    i++;
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(column.getFieldName(), clazz);
                    Object value = propertyDescriptor.getReadMethod().invoke(item);
                    String formattedValue = null;
                    if (value == null) { // 数据为null，填充默认值
                        formattedValue = column.getDefaultValue();
                    } else { // 将当前值转换为String
                        formattedValue = value.toString();
                    }
                    if (column.getColumnFormatter() != null) { // 存在Formatter则用其格式化值
                        formattedValue = column.getColumnFormatter().format(value);
                    }
                    cell.setCellValue(formattedValue);
                } catch (Exception e) {
                    throw new RuntimeException("error occur while process column [" + column.getFieldName() + "]", e);
                }
            }
        }
    }

}
