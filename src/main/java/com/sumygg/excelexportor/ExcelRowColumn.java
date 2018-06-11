package com.sumygg.excelexportor;

/**
 * 列定义，包括列表头，列字段，列默认值，列格式化函数
 *
 * @author SumyGG
 * @since 2018-06-11
 */
public class ExcelRowColumn {

    private String headerName;
    private String fieldName;
    private String defaultValue;
    private ColumnFormatter columnFormatter;

    /**
     * @param headerName      列表头名称
     * @param fieldName       列数据在数据对象中的定义字段
     * @param defaultValue    当前列为null时的默认值
     * @param columnFormatter 列格式化函数
     */
    public ExcelRowColumn(String headerName, String fieldName, String defaultValue, ColumnFormatter columnFormatter) {
        this.headerName = headerName;
        this.fieldName = fieldName;
        this.defaultValue = defaultValue;
        this.columnFormatter = columnFormatter;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public ColumnFormatter getColumnFormatter() {
        return columnFormatter;
    }

    public void setColumnFormatter(ColumnFormatter columnFormatter) {
        this.columnFormatter = columnFormatter;
    }
}
