package com.libertymutual.goforcode.todolist.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.todolist.models.ToDoItem;

@Service
public class ToDoItemRepository {

	private int nextId = 1;

	/**
	 * Get all the items from the file.
	 * 
	 * @return A list of the items. If no items exist, returns an empty list.
	 */
	public List<ToDoItem> getAll() {

		List<ToDoItem> items = new ArrayList<ToDoItem>();

		try (Reader in = new FileReader("to-do-list.csv")) {

			Iterable<CSVRecord> records = null;
			records = CSVFormat.DEFAULT.parse(in);

			for (CSVRecord record : records) {

				ToDoItem newItem = new ToDoItem();

				newItem.setId(Integer.parseInt(record.get(0)));
				newItem.setText(record.get(1));
				newItem.setComplete(Boolean.parseBoolean(record.get(2)));

				items.add(newItem);

				// String id = record.get("id");
				// String text = record.get("text");
				// String complete = record.get("isComplete");
				//
				// newItem.setId(Integer.parseInt(id));
				// newItem.setText(text);
				// newItem.setComplete(Boolean.parseBoolean(complete));
				//
				// items.add(newItem);

			}

			// in the same for loop
			// create a to do item
			// set the to do item properties
			// need to convert from String to Integer
			// return the to do item

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Replace this with something meaningful
		return items;

		// return Collections.emptyList();
	}

	/**
	 * Assigns a new id to the ToDoItem and saves it to the file.
	 * 
	 * @param item
	 *            The to-do item to save to the file.
	 */
	public void create(ToDoItem item) {
		// Fill this in with something meaningful

		item.setId(nextId);
		nextId++;

		String file = "to-do-list.csv";

		CSVFormat format = CSVFormat.DEFAULT.withHeader();

		try (FileWriter writer = new FileWriter(file, true); CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {

			String[] fullRecord = { Integer.toString(item.getId()), item.getText(),
					Boolean.toString(item.isComplete()) };
			// String[] fullRecord = { "id", "text", "isComplete" }; // is this right?!

			printer.printRecord(fullRecord);

			// printer.printRecord(//insert stuff here);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets a specific ToDoItem by its id.
	 * 
	 * @param id
	 *            The id of the ToDoItem.
	 * @return The ToDoItem with the specified id or null if none is found.
	 */
	public ToDoItem getById(int id) {
		// Replace this with something meaningful
		List<ToDoItem> existingToDoList = getAll();

		for (ToDoItem findItem : existingToDoList) {
			if (findItem.getId() == id) {
				return findItem;
			}
		}

		return null;
	}

	/**
	 * Updates the given to-do item in the file.
	 * 
	 * @param item
	 *            The item to update.
	 */
	public void update(ToDoItem item) {
		// Fill this in with something meaningful

		// Find an item in file by ID
		// Update item with what the new item properties are - text and isComplete
		// Save list

		// Create two lists - one with current items, and another with future items
		// Future list has up to date information
		// Update file with future list

		List<ToDoItem> existingToDoList = getAll();
//		List<ToDoItem> updatedToDoList = new ArrayList<ToDoItem>();

		int idIncrementer = 1;
		String file = "to-do-list.csv";
//		CSVFormat format = CSVFormat.DEFAULT.withHeader();

		try (FileWriter writer = new FileWriter(file, false); CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {

			for (ToDoItem findItem : existingToDoList) {

				if (findItem.getId() == item.getId()) {

					findItem.setComplete(true);

				}


				findItem.setId(idIncrementer);
				idIncrementer+=1;

				String[] newRecord = { Integer.toString(findItem.getId()), findItem.getText(),
						Boolean.toString(findItem.isComplete()) };

				printer.printRecord(newRecord);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

	}

}