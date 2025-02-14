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

## 3. How ArrayList Expands

- When adding an element **beyond capacity**, `ArrayList` creates a **new array (bigger size, usually 1.5x or 2x)** and copies the existing elements over.
- Example:

  ```java
  ArrayList<Integer> list = new ArrayList<>(2);
  list.add(10); // [10]
  list.add(20); // [10, 20]
  list.add(30); // Now expands, new array created
  ```
- Internal backing array: [10, 20, 30, ?]  Extra slot exists but is NOT part of size
- Unused space is not part of size(), so calling arr.get(index) on an out-of-bounds index throws an error instead of returning null.
- size() only returns the used space not any extended space
- ArrayLists grow dynamically but don’t initialize unused capacity—extra space exists internally but is not accessible.
