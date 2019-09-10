package oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee  {
    private int empid;
    private String empName;

    public Employee(int empid, String empName) {
        this.empid  = empid;
        this.empName = empName;
    }

    public int getEmpid() {
        return empid;
    }
    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return this.empid+", "+this.empName;
    }
}
public class ComparatorExample {

    public class EmpIDComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getEmpid() - o2.getEmpid();
        }
    }
    public class EmpNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getEmpName().compareTo(o2.getEmpName());
        }
    }
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        Employee e1 = new Employee(160002, "ashif");
        Employee e2 = new Employee(160001, "nikita");

        list.add(e1);
        list.add(e2);

        ComparatorExample comparatorExample = new ComparatorExample();
        Collections.sort(list, comparatorExample.new EmpIDComparator());

        System.out.println(list);
    }
}
