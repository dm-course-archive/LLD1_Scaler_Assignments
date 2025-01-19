# Quiz Question

## Question
What is the output of the final call to the display function i.e., s1.display()?

### Code
```java
public class Student {
    int age;
    String name;

    void display() {
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

    void sayHello(String name) {
        System.out.println(this.name + " says hello to " + name);
    }
}

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";
        s1.display();

        Student s2 = s1;
        s2.age = 20;
        s2.name = "B";

        s2.display();

        s1.display();
    }
}
```


## Options
1. My name is A. I am 10 years old.
2. My name is B. I am 10 years old.
3. My name is A. I am 20 years old.
4. My name is B. I am 20 years old.

<details>
<summary>See Answer</summary>

### Correct Answer
4. My name is B. I am 20 years old.

### Explanation
Explanation:
- `s2 = s1;` means both `s1` and `s2` refer to the same object in memory.
- When you update `s2.age` and `s2.name`, it also updates the properties of `s1`, since both are pointing to the same object.
- Therefore, the final call to `s1.display()` outputs the updated values of `name` and `age`.

</details>
