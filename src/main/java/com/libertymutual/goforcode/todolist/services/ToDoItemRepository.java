package com.libertymutual.goforcode.todolist.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.todolist.models.ToDoItem;

@Service
public class ToDoItemRepository {

    private int nextId = 1;
    private ToDoItem todo = new ToDoItem();
    private List<ToDoItem> items;
    

    /**
     * Get all the items from the file. 
     * @return A list of the items. If no items exist, returns an empty list.
     */
    public List<ToDoItem> getAll() {
    	
    	
    	try (Reader in = new FileReader("to-do-list.csv") ) {
    		
    		 CSVParser parser = CSVFormat.EXCEL.parse(in);
    		 
    		 List<CSVRecord> list = parser.getRecords();   		
    		 
    		 for ( CSVRecord record : parser) {
    			 
    			 String id = record.get("id");
    			 String text = record.get("text");
    			 String complete = record.get("isComplete");
    			 
    		 }
    		 
//    		 CSVPrinter printer = new CSVPrinter('/', parser);
    		 
    		 
    		 
    		 

    		
    		
    		//Scanner scanner = new Scanner(); 
    		

//    		
//    		CSVParser parser = new CSVParser(in, formatter );
//    		null
//    		CSVPrinter printer = new CSVPrinter(, formatter);

    		
//    		BufferedReader buffy = new BufferedReader(in);
//    		
//    		String line = buffy.readLine();
//    		ToDoItem item = new ToDoItem();
//    		
//    		while(line != null ) {
//    			
//    		}
    		

    		
    	}
    	catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        // Replace this with something meaningful
        return Collections.emptyList();
    }

    /**
     * Assigns a new id to the ToDoItem and saves it to the file.
     * @param item The to-do item to save to the file.
     */
    public void create(ToDoItem item) {
        // Fill this in with something meaningful
    	
    	item.setId(nextId);
    	nextId ++;
    	
    	FileWriter writer;
		try {
			writer = new FileWriter("to-do-list.csv");
	    	CSVPrinter printer = CSVFormat.DEFAULT.print(writer);
	    	String[] fullRecord = {"id", "text", "isComplete"}; //is this right?!
	    	
	    	printer.printRecord(fullRecord);
	    	
	    	//printer.printRecord(//insert stuff here);
	    	
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Gets a specific ToDoItem by its id.
     * @param id The id of the ToDoItem.
     * @return The ToDoItem with the specified id or null if none is found.
     */
    public ToDoItem getById(int id) {
        // Replace this with something meaningful
        return null;
    }

    /**
     * Updates the given to-do item in the file.
     * @param item The item to update.
     */
    public void update(ToDoItem item) {
        // Fill this in with something meaningful
    }

}