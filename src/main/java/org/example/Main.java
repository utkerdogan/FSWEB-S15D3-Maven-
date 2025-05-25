package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.example.entity.Employee;

public class Main {
    
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        LinkedList<Employee> duplicates = new LinkedList<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            if (!seen.add(emp)) {
                if (!duplicates.contains(emp)) {
                    duplicates.add(emp);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> result = new LinkedHashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue;
            if (!result.containsKey(emp.getId())) {
                result.put(emp.getId(), emp);
            }
        }

        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        LinkedList<Employee> result = new LinkedList<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        

        System.out.println("TEKRAR EDENLER:");
        List<Employee> duplicates = findDuplicates(employees);
        duplicates.forEach(System.out::println);

        System.out.println("\nTEKRARSIZ + TEKİL OLANLAR (MAP):");
        Map<Integer, Employee> uniqueMap = findUniques(employees);
        uniqueMap.values().forEach(System.out::println);

        System.out.println("\nSADECE TEK GEÇENLER:");
        List<Employee> removedDupes = removeDuplicates(employees);
        removedDupes.forEach(System.out::println);
    }
}