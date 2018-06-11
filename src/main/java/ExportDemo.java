import com.sumygg.excelexportor.ExcelExportorHelper;
import com.sumygg.excelexportor.ExcelRowColumn;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportDemo {
    public static class Student {
        private String name;
        private Integer age;
        private Date birthday;

        public Student(String name, Integer age, Date birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    }

    public static void main(String[] args) {
        List<ExcelRowColumn> columnDefines = new ArrayList<>();
        columnDefines.add(new ExcelRowColumn("姓名", "name", "未知姓名", null));
        columnDefines.add(new ExcelRowColumn("年龄", "age", null, null));
        columnDefines.add(new ExcelRowColumn("生日", "birthday", null, (value -> {
            if (value == null) {
                value = new Date();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            return simpleDateFormat.format(value);
        })));

        List<Student> students = new ArrayList<>();
        students.add(new Student("小明", 18, new Date()));
        students.add(new Student("小红", null, null));
        students.add(new Student(null, null, null));

        Workbook excelWorkBook = new SXSSFWorkbook(100);
        Sheet sheet = excelWorkBook.createSheet();
        try {
            ExcelExportorHelper.exportWithHeader(sheet, columnDefines, students);
            File tempFile = File.createTempFile("excel_", ".xlsx");
            excelWorkBook.write(new FileOutputStream(tempFile));
            System.out.println("File saved to " + tempFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
