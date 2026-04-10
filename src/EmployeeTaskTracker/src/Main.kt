fun main() {
//    val employee = Employee()
//
//    employee.setFullName("Иван Петров")
//    employee.setPosition("Разработчик")
//    employee.setSalary(-1000)
//    employee.setSalary(75000)
//    employee.setYearsOfExperience(60)
//    employee.setYearsOfExperience(5)
//
//    println("ФИО: ${employee.getFullName()}")
//    println("Должность: ${employee.getPosition()}")
//    println("Зарплата: ${employee.getSalary()}")
//    println("Опыт: ${employee.getYearsOfExperience()}")
//
//    // Задание 3
//    println("\n=== Демонстрация data-класса Task ===")
//
//    val task1 = Task("Fix bug", "Исправить ошибку в логине", Priority.HIGH)
//    val task2 = Task("Fix bug", "Исправить ошибку в логине", Priority.HIGH)
//    val task3 = Task("Write tests", "Написать юнит-тесты", Priority.MEDIUM)
//
//    println("task1 == task2: ${task1 == task2}")
//    println("task1 == task3: ${task1 == task3}")
//
//    println("\ntask1 hash code: ${task1.hashCode()}")
//    println("task2 hash code: ${task2.hashCode()}")
//
//    println("\ntask1 toString(): $task1")
//
//    val task4 = task1.copy(priority = Priority.LOW, isCompleted = true)
//    println("\nСкопированная задача с изменениями: $task4")
//
//    // Задание 4
//    println("\n=== Отделы ===")
//    val devDept = DevelopmentDepartment()
//    val testDept = TestingDepartment()
//
//    println("Название: ${devDept.departmentName}")
//    devDept.printDepartmentGoal()
//
//    println("\nНазвание: ${testDept.departmentName}")
//    testDept.printDepartmentGoal()
//
//    // Задание 5
//    println("\n=== Полиморфизм: список отчетов ===")
//
//    val reports: List<ReportGenerator> = listOf(employee, devDept)
//
//    for (reporter in reports) {
//        println(reporter.generateReport())
//    }

    //Задание 6
    val employee = Employee()
    employee.setFullName("Иван Петров")
    employee.setPosition("Senior Developer")
    employee.setSalary(120000)
    employee.setYearsOfExperience(8)

    val task1 = Task("Рефакторинг", "Переписать старый модуль", Priority.HIGH)
    val task2 = Task("Документация", "Обновить API документацию", Priority.MEDIUM)
    val task3 = Task("Code Review", "Проверить Pull Request", Priority.LOW)

    println("=== Симуляция работы ===")
    employee.assignTask(task1)
    employee.assignTask(task2)

    println("\n--- Завершаем задачу: ${task1.title} ---")
    val completedTask = task1.copy(isCompleted = true)
    employee.currentTask = completedTask
    employee.assignTask(task2)
    println("\n=== Финальные отчеты ===")
    val devDept = DevelopmentDepartment()
    val reports: List<ReportGenerator> = listOf(employee, devDept)

    for (reporter in reports) {
        println(reporter.generateReport())
    }

}