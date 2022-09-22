package no.hvl.dat108.task2;

import no.hvl.dat108.task2.enums.Gender;
import no.hvl.dat108.task2.enums.Posistion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Karl", "Hansen", Posistion.Avdelingsleder, Gender.MALE, 800000),
                new Employee("Anna", "Mikkelsen", Posistion.Utvikler, Gender.FEMALE, 650000),
                new Employee("Henrik", "Fritz", Posistion.Utvikler, Gender.MALE, 700000),
                new Employee("Hans Jacob", "Toppe", Posistion.Teamleder, Gender.MALE, 850000),
                new Employee("Hanne", "Listhaug", Posistion.Dagligleder, Gender.FEMALE, 1200000));

        printEmployees(employees);

        //Alle ansatte får 10 000 mer
        salarySettlement(employees, employee -> true, employee -> employee.setSalary(employee.getSalary() + 10000));
        //Alle ansatte med lavere lønn enn 300 000 får 15 000 ekstra
        salarySettlement(employees, employee -> employee.getSalary() < 300000, employee -> employee.setSalary(employee.getSalary() + 15000));
        //Alle utviklere får 2% økning
        salarySettlement(employees, (employee) -> employee.getPosition().equals(Posistion.Utvikler), employee -> employee.setSalary(employee.getSalary()*1.02));
        //Alle som ikke er utviklere får 10% økning
        salarySettlement(employees, employee -> !employee.getPosition().equals(Posistion.Utvikler), employee -> employee.setSalary(employee.getSalary()*1.10));
        //Alle kvinner får 50 000 ekstra
        salarySettlement(employees, employee -> employee.getGender().equals(Gender.FEMALE), employee -> employee.setSalary(employee.getSalary() + 50000));

        printEmployees(employees);
    }
    private static void salarySettlement(List<Employee> employees, Predicate<Employee> predicate, Settlement settlement){ //TODO

        List<Employee> current_employees = new ArrayList<>();

        for(Employee employee : employees){
            //Finner de ansatte i listen som oppfyller predikatet
            if(predicate.test(employee)){
                //legges til i en ny liste med de aktuelle ansatte
                current_employees.add(employee);
            }
        }
        for (Employee employee : current_employees){
            //utfører beregningen av de anktuelle ansatte i den nye listen
            settlement.computeNewSalary(employee);
        }
    }
    private static void printEmployees(List<Employee> employees){
        StringBuilder result = new StringBuilder();

        for(Employee employee : employees){
            result.append("Name: ").append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("; Salary: ").append(employee.getSalary()).append("\n");
        }
        System.out.println(result);
    }
}
@FunctionalInterface
interface Settlement{
    void computeNewSalary(Employee employee);
}