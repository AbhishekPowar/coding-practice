package javapractice.cloning;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Employee implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private final String _id;
    private String firstName;
    private String lastName;
    private Department department;

    public Employee() {
        System.out.println("Constructor invoked");
        this._id = UUID.randomUUID().toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        System.out.println("Serializing Class: "+this.getClass().getCanonicalName());
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("Deserializing Class: "+this.getClass().getCanonicalName());
        objectInputStream.defaultReadObject();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(_id, employee._id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, firstName, lastName, department);
    }
}
