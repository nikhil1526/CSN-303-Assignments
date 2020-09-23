import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;


import java.util.*;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class JsoupCrawl {
	public class QueueNode{
		String a;
		int depth;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Queue<QueueNode> q=new LinkedList<>(); 
		 String u = "https://www.pec.ac.in/";

		 JsoupCrawl outer = new JsoupCrawl();
		 JsoupCrawl.QueueNode inner = outer.new QueueNode();
		 inner.a=u;
		 inner.depth=1;
		 int count_1=0;
		 int count_2=0;
		 q.add(inner);
		 HashSet<String> hs = new HashSet<String>();
		 hs.add(u);

		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet spreadsheet1 = workbook.createSheet( " Text ");
		 XSSFSheet spreadsheet2 = workbook.createSheet( " Links ");
		 XSSFRow row1;
		 XSSFRow row2;
		 while(!q.isEmpty())
		 {
			 
			 QueueNode popped=q.poll();
			 String url=popped.a;
			 
			
			 
			 
			 
	      Document document = Jsoup.connect(url).get();
	
	      
	      Elements links=document.select("a[href]");
	      for(Element link: links)
	      {
	           String relHref = link.attr("href"); 
	           String absHref = link.attr("abs:href");
	           int len=absHref.length();
	           if(!hs.contains(absHref))
	           {
	           count_2=count_2+1;
	           row2=spreadsheet2.createRow(count_2);
	    		  int cellid = 0;
		            Cell cell_1 = row2.createCell(cellid++);
		            cell_1.setCellValue(link.text());
		            Cell cell_2 = row2.createCell(cellid++);
		            cell_2.setCellValue(absHref);
	           }
		        if(popped.depth<3)    //upto depth 3
		        {	
		        	if(relHref.length()>1)
		        	if((!hs.contains(absHref))&&(relHref.charAt(0)!='#')&&(absHref.startsWith(u))&&(absHref.charAt(len-4)!='.')&&(!absHref.endsWith(".docx"))&&(!absHref.endsWith(".jpeg")))
		        	{
		       		 JsoupCrawl out_temp = new JsoupCrawl();
		    		 JsoupCrawl.QueueNode inner_temp = out_temp.new QueueNode();
		    		 inner_temp.a=absHref;
		    		 inner_temp.depth=popped.depth+1;
		    		 q.add(inner_temp);
		    		 hs.add(absHref);
		        	}
		        }
	           
	           
	      }
	      
	      Elements paragraphs = document.getAllElements();
	      for(Element paragraph:paragraphs)
	      {	
	    	  
	    	  String value=paragraph.ownText();
	    	  if(value.length()!=0)
	    	  {	  
	    		  count_1=count_1+1;
	    		  row1 = spreadsheet1.createRow(count_1);
	    		  int cellid = 0;
		            Cell cell_1 = row1.createCell(cellid++);
		            cell_1.setCellValue(value);
		            Cell cell_2 = row1.createCell(cellid++);
		            cell_2.setCellValue(paragraph.tagName());
		            
	    		  
	    		  
	    
	    	  }


	      }
		 }


	      String home = System.getProperty("user.home");
	
	      FileOutputStream out = new FileOutputStream(
	         new File(home+"\\Desktop\\Writesheet.xlsx"));
	      
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");

	}

}
