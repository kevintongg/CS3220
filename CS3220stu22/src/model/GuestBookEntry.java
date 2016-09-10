package model;

import java.util.Date;

public class GuestBookEntry {

	static int count;
	
	int id;
	String name;
	String message;
	Date created;

	public GuestBookEntry() {
		
	}
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.created = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		GuestBookEntry.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
