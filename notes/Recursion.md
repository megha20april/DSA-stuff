# 🔥 Key Recursion Principles (That Actually Help)

## 🟢 1. Always Define a Base Case First
The base case stops the recursion, preventing infinite loops.
💡 Ask yourself: When should this function stop calling itself?

```java
if (node == null) return 0; // Example base case for trees
```

## 🟢 2. Decide How to Handle the Result: Accumulation vs. Modification

When using recursion, ask:

Do I need to return a value and use it later? 
→ Return the result from recursive calls.

Do I need to modify a global/mutable variable?
→ Use an instance variable or a mutable reference (int[] or List<Integer>).

Example: Using Return Values for Accumulation
```java
int leftSum = dfs(node.left);
int rightSum = dfs(node.right);
return leftSum + rightSum + node.val; // Accumulate and return
```

Example: Using Global Variable
```java
class Solution {
    int sum = 0;
    public int treeSum(TreeNode root) {
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode node) {
        if (node == null) return;
        sum += node.val; // Modify instance variable
        dfs(node.left);
        dfs(node.right);
    }
}
```
👉 Use return values when you need to use previous results,
👉 Use global/mutable variables when you need to track values across calls.

## 🟢 3. Backtracking: Undo Changes Before Returning
If you're modifying a global variable or a shared data structure, undo changes before the function returns.

Example: Backtracking a Prefix Sum Map
```java
map.put(prfSum, map.getOrDefault(prfSum, 0) + 1); // Add value

result += dfs(node.left, t, prfSum) + dfs(node.right, t, prfSum);

map.put(prfSum, map.get(prfSum) - 1); // Undo change before returning
```

---

# **How Java Handles Parameters in Recursion**  

## **🔹 Basic Rule: Java is Always Pass-by-Value**  
- **Primitives (`int`, `double`, etc.)** → Passed by value, changes **don’t persist** outside.  
- **Immutable objects (`Integer`, `String`)** → Behave like primitives, changes **don’t persist** outside.  
- **Mutable objects (`List`, `Array`, `HashMap`)** → Passed by reference (indirectly), changes **persist** outside.  

---

## **1️⃣ Primitives (`int`, `double`, `boolean`, etc.)**  
🔴 **Changes inside recursion do not affect the original value.**  

```java
void increment(int num) {
    num++;  // Only modifies the local copy.
}

public static void main(String[] args) {
    int num = 5;
    increment(num);
    System.out.println(num);  // Still prints 5
}
```
**Why?**  
- The function gets a **copy** of `num`, so modifying it **does not affect** the original value.

**Solution:** ✅ Use return values instead of modifying directly.  

✅ Example:
   ```java
   int dfs(int num) {
       return num + 1;  // Return new value
   }
   ```

---

## **2️⃣ Wrapper Classes (`Integer`, `Double`, `Boolean`) and `String`**
🔴 **Behave like primitives (Immutable, changes don’t persist).**  

```java
void modifyInteger(Integer num) {
    num++;  // Creates a new Integer object, original remains unchanged.
}

public static void main(String[] args) {
    Integer num = 5;
    modifyInteger(num);
    System.out.println(num);  // Still prints 5
}
```
**Why?**  
- **`Integer` is immutable**, so `num++` creates a **new object** rather than modifying the existing one.
- Same happens for `String`, it creates a **new object** rather than modifying the existing one.

**Solution:** Avoid modification—use return values. 
   ✅ Example:
   ```java
   Integer dfs(Integer num) {
       return num + 1;  // Returns new Integer object
   }
   ```
---

## **3️⃣ Mutable Objects (`Array`, `List`, `HashMap`)**
🟢 **Changes inside recursion affect the original object.**  

```java
void modifyList(List<Integer> list) {
    list.add(100);  // This modifies the same object in memory.
}

public static void main(String[] args) {
    List<Integer> myList = new ArrayList<>();
    myList.add(1);
    modifyList(myList);
    System.out.println(myList);  // Prints [1, 100]
}
```
**Why?**  
- A **copy of the reference** is passed, but both references point to the **same object** in memory.

---


## **🔹 General Summary Table**
| Data Type | Behavior in Recursion |
|-----------|----------------------|
| `int`, `double`, `boolean` (Primitives) | Changes **do not persist** (pass-by-value) |
| `Integer`, `Double`, `Boolean` (Wrapper Classes) | Changes **do not persist** (Immutable objects) |
| `String` | Changes **do not persist** (Immutable) |
| `Array`, `List`, `HashMap`, `Set` | Changes **persist** (Mutable objects, reference passed by value) |

---
