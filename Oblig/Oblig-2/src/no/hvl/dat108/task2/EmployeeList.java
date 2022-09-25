package no.hvl.dat108.task2;

import no.hvl.dat108.task2.enums.Gender;
import no.hvl.dat108.task2.enums.Posistion;

import java.util.List;

public class EmployeeList {
    List<Employee> employees;

    public EmployeeList() {
        this.employees = List.of(
                new Employee("Karl", "Hansen", Posistion.AVDELINGSLEDER, Gender.MALE, 800000),
                new Employee("Anna", "Mikkelsen", Posistion.UTVIKLER, Gender.FEMALE, 650000),
                new Employee("Henrik", "Fritz", Posistion.UTVIKLER, Gender.MALE, 700000),
                new Employee("Hans Jacob", "Toppe", Posistion.TEAMLEDER, Gender.MALE, 850000),
                new Employee("Hanne", "Listhaug", Posistion.DAGLIGLEDER, Gender.FEMALE, 1200000));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void printEmployees(){
        StringBuilder result = new StringBuilder();

        for(Employee employee : employees){
            result.append("Name: ").append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("; Salary: ").append(employee.getSalary()).append("\n");
        }
        System.out.println(result);
    }
}
