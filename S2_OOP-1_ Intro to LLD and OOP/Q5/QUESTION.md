# Quiz Question

## Question
What is the output of the final call to display function??

### Code
```java
public class Student {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

    void sayHello(String name){
        System.out.println(this.name + " says hello to " + name);
    }
}

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";

        Student s2 = new Student();

        int tempAge = s1.age;
        s1.age = s2.age;
        s2.age = tempAge;

        s2.display();

    }
}
```


## Options
1. My name is A. I am 10 years old.
2. My name is null. I am 0 years old.
3. My name is null. I am 10 years old.
4. My name is A. I am 0 years old.

<details>
<summary>See Answer</summary>

### Correct Answer
3. My name is null. I am 10 years old.

### Explanation
Explanation:.

</details>
