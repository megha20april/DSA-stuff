# Arrays vs. ArrayLists in Java

## 1. Size & Growth  

| Feature  | **Array (`Integer[]`)** | **ArrayList (`ArrayList<Integer>`)** |
|----------|--------------------|----------------------|
| **Size Fixed?** | ✅ Yes, must be defined at creation | ❌ No, grows dynamically |
| **Expands Automatically?** | ❌ No | ✅ Yes, increases capacity when needed |

---

## 2. Default Values  

| Feature  | **Array (`Integer[]`)** | **ArrayList (`ArrayList<Integer>`)** |
|----------|--------------------|----------------------|
| **Default Values?** | ✅ Yes, `null` for `Integer[]`, `0` for `int[]` | ❌ No default values |
| **Unused Space Accessible?** | ✅ Yes, holds `null` or default values | ❌ No, unused capacity is invisible |

---

## 3. Utility Methods from Arrays Class

| Method               | Description                                 |
|----------------------|---------------------------------------------|
| sort(arr)            | Sorts the array                             |
| binarySearch(arr, key)| Searches for a key in a sorted array       |
| copyOf(arr, newLength)| Copies an array to a new length            |
| fill(arr, val)       | Fills an array with a specific value        |
| equals(arr1, arr2)   | Compares two arrays                         |
| toString(arr)        | Converts an array to a string               |
| asList(arr)          | Converts an array to a list                 |

---

## 4. How ArrayList Expands

- When adding an element **beyond capacity**, `ArrayList` creates a **new array (bigger size, usually 1.5x or 2x)** and copies the existing elements over.
- Example:

  ```java
  ArrayList<Integer> list = new ArrayList<>(2);
  list.add(10); // [10]
  list.add(20); // [10, 20]
  list.add(30); // Now expands, new array created
  ```
  > In the above program, we have used Integer not int. It is because we cannot use primitive types while creating an arraylist. Instead, we have to use the corresponding wrapper classes.
  
- Internal backing array: [10, 20, 30, ?]  Extra slot exists but is NOT part of size
- Unused space is not part of size(), so calling arr.get(index) on an out-of-bounds index throws an error instead of returning null.
- size() only returns the used space not any extended space
- ArrayLists grow dynamically but don’t initialize unused capacity—extra space exists internally but is not accessible.

---

## 5. Utility Methods from ArrayList Class

| Method              | Description                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| size()              | Returns the number of elements in the ArrayList.                            |
| sort()              | Sorts the elements of the ArrayList in ascending order.                     |
| clone()             | Creates a shallow copy of the ArrayList.                                    |
| contains(element)   | Checks if the ArrayList contains the specified element.                     |
| ensureCapacity(n)   | Increases the capacity of the ArrayList to ensure it can hold n elements.   |
| isEmpty()           | Returns `true` if the ArrayList contains no elements.                       |
| indexOf(element)    | Returns the index of the first occurrence of the specified element.         |
| add(element)        | Adds an element to the end of the ArrayList.                                |
| add(index, element) | Inserts an element at the specified index.                                  |
| get(index)          | Returns the element at the specified index.                                 |
| set(index, element) | Replaces the element at the specified index with the given element.         |
| remove(index)       | Removes the element at the specified index.                                 |
| clear()             | Removes all elements from the ArrayList.                                    |
| toArray()           | Converts the ArrayList to a regular array.                                  |
