package contact;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
public class Contact {
    public void display(){
        try{
            FileInputStream fis= new FileInputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            Workbook wb= new XSSFWorkbook(fis);
            XSSFSheet sheet=(XSSFSheet)wb.getSheet("Detail");
           Iterator<Row> ri=sheet.iterator();
           while(ri.hasNext()){
               Row r=ri.next();
               Iterator<Cell> ci=r.cellIterator();
           while(ci.hasNext()){
               Cell cell=ci.next();
               switch(cell.getCellType()){
                   case Cell.CELL_TYPE_STRING:
                       System.out.print(cell.getStringCellValue()+"              ");
                       break;
                   case Cell.CELL_TYPE_NUMERIC:
                       System.out.print((int)(cell.getNumericCellValue())+"             ");
                       break;
               }
           }
             System.out.println();
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Add(){
        try{
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Name");
            System.out.print(" ");
            String name=s.nextLine();
            System.out.print(" ");
            System.out.println("Enter Email");
            String em=s.nextLine();
            System.out.println("Enter Phone Number");
            String ph=s.nextLine();
            FileInputStream fis= new FileInputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            Workbook wb= new XSSFWorkbook(fis);
            XSSFSheet sheet=(XSSFSheet)wb.getSheet("Detail");
            int lr=sheet.getLastRowNum();
            Row r=sheet.createRow(lr+1);
            r.createCell(0).setCellValue(lr+1);
            r.createCell(1).setCellValue(name);
            r.createCell(2).setCellValue(ph);
            r.createCell(3).setCellValue(em);
            FileOutputStream fos= new FileOutputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            wb.write(fos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(){
        try{
            Scanner s=new Scanner(System.in);
            System.out.println("Enter S.NO");
            int n=s.nextInt();
            System.out.println("Enter Name");
            String name=s.next();
            System.out.println("Enter Email");
            String em=s.next();
            System.out.println("Enter Phone Number");
            String ph=s.next();
            FileInputStream fis= new FileInputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            Workbook wb= new XSSFWorkbook(fis);
            XSSFSheet sheet=(XSSFSheet)wb.getSheet("Detail");
            Row r=sheet.getRow(n);
            r.getCell(1).setCellValue(name);
            r.getCell(2).setCellValue(ph);
            r.getCell(3).setCellValue(em);
            FileOutputStream fos= new FileOutputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            wb.write(fos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delete(){
      try{
            Scanner s=new Scanner(System.in);
            System.out.println("Enter S.NO");
            int n=s.nextInt();
            FileInputStream fis= new FileInputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            Workbook wb= new XSSFWorkbook(fis);
            XSSFSheet sheet=(XSSFSheet)wb.getSheet("Detail");
            sheet.removeRow(sheet.getRow(n));
            
            Iterator<Row> ri=sheet.iterator();
            int c=0;
            while(ri.hasNext()){
               Row r=ri.next();
               if(c>=n){
               r.getCell(0).setCellValue(n);
               n++;
               }
               c++;
            }
            FileOutputStream fos= new FileOutputStream("C:\\Users\\HP\\Documents\\ContactDetails.xlsx");
            wb.write(fos);
        }
        catch(Exception e){
            e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        boolean b=true;
        Scanner s= new Scanner(System.in);
        Contact c=new Contact();
        while(b){
            System.out.println("Enter the option");
            System.out.println("1.Add"+"\n"+"2.Display\n3.Update\n4.Delete\n5.Exit\n");
            int opt=s.nextInt();
            switch(opt){
                case 1:
                    c.Add();
                    break;
                case 2:
                    c.display();
                    break;
                case 3:
                    c.update();
                    break;
                case 4:
                    c.delete();
                    break;
                case 5:
                    b=false;
                    break;
        }    
        }
    }
}
