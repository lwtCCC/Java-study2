package ExceptionDemo.TestDemo;

public class Girl {
    private String name;
    private int age;


    public Girl() {
    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new NameFormatException(name + "长度小于3");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 18) {
            throw new AgeFormatException(age + "太小了或太老了");
        }
        this.age = age;
    }
}
