# ExcelExportor

一个简单的用于导出数据到Excel的辅助类。

## 安装

**第一步：** 打开仓库

**第二步：** 将仓库以zip压缩的形式打包下载

**第三步：** 拷贝 _com.sumygg.excelexportor_ 目录下的文件到你的项目中，记得起个帅气点的目录，记得修正一下包位置。

工具类使用了 `poi-ooxml` ，请确定原项目引用了该依赖。

```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.14</version>
</dependency>
```

## 使用

分为两步： **定义数据列** 和 **导出Excel**。具体使用方法可以参照 `ExportDemo` 类中所写的代码。

### 定义数据列

每个 `ExcelRowColumn` 类的对象为一列数据。

```
new ExcelRowColumn("headerName", "fieldName", "defaultValue", formatter)
```

`headerName` 代表列标题

`fieldName` 代表数据在数据类的字段名称

`defaultValue` 代表当数据为空时使用的默认值

`formatter`  代表格式化函数

请将列的定义聚合到一个List中，为了保证顺序性，请使用有序List，放入List的顺序即为最后数据显示的顺序。

### 导出Excel

使用 `ExcelExportorHelper.exportWithHeader(sheet, List columnDefines, List datas)` 可以将数据按行整理到指定的 **sheet** 中。

数据类需实现对应字段的 **getter** 方法。

## 贡献代码

任何贡献都是欢迎的。

## 协议

The code in this project is licensed under MIT license.