fun main() {
    val employee = Employee()

    employee.setFullName("Иван Петров")
    employee.setPosition("Разработчик")
    employee.setSalary(-1000)
    employee.setSalary(75000)
    employee.setYearsOfExperience(60)
    employee.setYearsOfExperience(5)

    println("ФИО: ${employee.getFullName()}")
    println("Должность: ${employee.getPosition()}")
    println("Зарплата: ${employee.getSalary()}")
    println("Опыт: ${employee.getYearsOfExperience()}")
}