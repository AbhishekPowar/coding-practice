package javapractice.cloning;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
        Employee employee = new Employee();
        employee.setFirstName("Mohd Ashif");
        employee.setLastName("Ali");

        Department department = new Department();
        department.setCode("voa");
        department.setName("Automotive");

        System.out.println(Arrays.toString("Hello".getBytes(StandardCharsets.UTF_8)));
        employee.setDepartment(department);

        Employee clone = employee.clone();

        System.out.println(employee.equals(clone));

        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.data")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("employee.data")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Employee employee1 = (Employee) objectInputStream.readObject();

            System.out.println(employee1.equals(employee));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
