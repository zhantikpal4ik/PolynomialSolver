public class Test {

	public static void main(String[] args) { 
		// Running a series of tests on OrderedLinkedList and printing whether each one passes or fails
		System.out.println("OLL Test 01 " + (test01() ? "passed" : "failed"));
		System.out.println("OLL Test 02 " + (test02() ? "passed" : "failed"));
		System.out.println("OLL Test 03 " + (test03() ? "passed" : "failed"));
		System.out.println("OLL Test 04 " + (test04() ? "passed" : "failed"));
		System.out.println("OLL Test 05 " + (test05() ? "passed" : "failed"));
	}

	// Test 1: Verifies that a new OrderedLinkedList is empty and throws an exception when trying to access an element.
	public static boolean test01() { 
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
		
		// Check that the list size is 0 initially
		if (oll.getSize() != 0) {
			return false;
		}
		
		try {
			// Try accessing the first element (should throw an IndexOutOfBoundsException)
			oll.get(0);
			return false;  // Fail if no exception is thrown
		} catch (IndexOutOfBoundsException e) {
			return true;   // Pass if exception is caught
		}
	}

	// Test 2: Verifies insertion of a single element and checks size and value.
	public static boolean test02() { 
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
		int x = (int) (Math.random() * 100);  // Random integer value
		oll.insert(x);

		// Check if the size is 1 and the inserted value is correct
		return (oll.getSize() == 1) && (oll.get(0) == x);
	}

	// Test 3: Verifies that accessing an out-of-bounds index throws an exception.
	public static boolean test03() { 
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
		oll.insert(5);

		try {
			// Try accessing the second element in a 1-element list (should throw an exception)
			oll.get(1);
			return false;  // Fail if no exception is thrown
		} catch (IndexOutOfBoundsException e) {
			return true;   // Pass if exception is caught
		}
	}

	// Test 4: Verifies insertion of two elements and checks the order and size.
	public static boolean test04() { 
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

		// Insert two random values
		int x = (int) (Math.random() * 100);
		int y = (int) (Math.random() * 100);
		int[] all = new int[] {x, y};  // Store both values

		oll.insert(x);
		oll.insert(y);

		// Check if the size is 2
		if (oll.getSize() != 2) {
			return false; 
		} else {
			// Check if the values are ordered correctly (assuming the list is sorted in descending order)
			int first = oll.get(0);
			int second = oll.get(1);

			return (first >= second) && (first == all[0] || first == all[1]) && (second == all[0] || second == all[1]);
		}
	}

	// Test 5: Verifies insertion of 100 elements and checks if they are in the correct order.
	public static boolean test05() { 
		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

		// Insert numbers from 99 down to 0
		for (int i = 99; i >= 0; i--) { 
			oll.insert(i);
		}

		// Check if the list contains numbers from 0 to 99 in ascending order
		boolean result = true;
		for (int i = 0; i < 100; i++) { 
			result = result && (i == 100 - oll.get(i) - 1);  // Verify the element at index i is (100 - i - 1)
		}
		return result;
	}
}
