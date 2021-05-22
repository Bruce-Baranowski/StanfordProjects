package week6;

import acm.program.ConsoleProgram;

public class ExpandableArray extends ConsoleProgram {
	private Object[] list;
	
	public ExpandableArray() {
		list = new Object[0];
	}
	
	public void run() {
		ExpandableArray myList = new ExpandableArray();
		myList.set(14, "Bob");
		myList.set(21, "Sally");
		
		String value = (String) myList.get(21); // Note the cast
		if (value != null) {
			println("Got value: " + value);
		}

	}
	
	public void set(int index, Object value) {
		if (index >= list.length) {
			Object[] tmp = new Object[index+1];
			for (int i = 0; i < list.length; i++) {
				tmp[i] = list[i];
			}
			list = tmp;
		}
		list[index] = value;
	}

	public Object get(int index) {
		if (index >= list.length) return null;
		return list[index];
	}
}
