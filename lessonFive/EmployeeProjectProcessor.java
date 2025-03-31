package org.example.lessonFive;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeProjectProcessor {
    public static Map<String, Double> processEmployees(List<Employee> employees) {
        return employees.stream()
                // Фильтрация сотрудников
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 50 && e.getSalary() > 60000)

                // Получаем все проекты
                .flatMap(e -> e.getProjects().stream())

                // Фильтрация проектов
                .filter(p -> p.getDuration() > 6)

                // Группировка по имени проекта (в верхнем регистре)
                .collect(Collectors.groupingBy(
                        p -> p.getName().toUpperCase(),

                        // Расчет средней длительности
                        Collectors.averagingInt(Project::getDuration)
                ))

                // Сортировка по убыванию средней длительности
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())

                // Сбор в Map (порядок не гарантирован)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        HashMap::new
                ));
    }
}