package no.hvl.dat108.task2;

import no.hvl.dat108.task2.enums.Gender;
import no.hvl.dat108.task2.enums.Posistion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    //Global for bruk i oppgave 3

    public static void main(String[] args) {
        EmployeeList employees = new EmployeeList();

        employees.printEmployees();

        //Alle ansatte får 10 000 mer
        salarySettlement(employees, employee -> true, employee -> employee.setSalary(employee.getSalary() + 10000));
        //Alle ansatte med lavere lønn enn 300 000 får 15 000 ekstra
        salarySettlement(employees, employee -> employee.getSalary() < 300000, employee -> employee.setSalary(employee.getSalary() + 15000));
        //Alle utviklere får 2% økning
        salarySettlement(employees, (employee) -> employee.getPosition().equals(Posistion.UTVIKLER), employee -> employee.setSalary(employee.getSalary()*1.02));
        //Alle som ikke er utviklere får 10% økning
        salarySettlement(employees, employee -> !employee.getPosition().equals(Posistion.UTVIKLER), employee -> employee.setSalary(employee.getSalary()*1.10));
        //Alle kvinner får 50 000 ekstra
        salarySettlement(employees, employee -> employee.getGender().equals(Gender.FEMALE), employee -> employee.setSalary(employee.getSalary() + 50000));

        employees.printEmployees();
    }
    private static void salarySettlement(EmployeeList employees, Predicate<Employee> predicate, Settlement settlement){

        List<Employee> current_employees = new ArrayList<>();

        for(Employee employee : employees.getEmployees()){
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
}
@FunctionalInterface
interface Settlement{
    void computeNewSalary(Employee employee);
}