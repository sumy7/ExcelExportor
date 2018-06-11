package com.sumygg.excelexportor;

/**
 * 格式化方法接口
 *
 * @author SumyGG
 * @since 2018-06-11
 */
@FunctionalInterface
public interface ColumnFormatter {
    String format(Object value);
}
