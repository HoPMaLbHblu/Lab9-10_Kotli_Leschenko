class Employee : ReportGenerator {
    private var fullName: String = ""
    private var position: String = ""
    private var salary: Int = 0
    private var yearsOfExperience: Int = 0


    fun getFullName(): String = fullName
    fun getPosition(): String = position
    fun getSalary(): Int = salary
    fun getYearsOfExperience(): Int = yearsOfExperience

    fun setFullName(value: String) {
        fullName = value
    }

    fun setPosition(value: String) {
        position = value
    }

    fun setSalary(value: Int) {
        if (value < 0) {
            println("Предупреждение: Зарплата не может быть отрицательной. Значение не изменено.")
        } else {
            salary = value
        }
    }

    fun setYearsOfExperience(value: Int) {
        yearsOfExperience = if (value > 50) {
            println("Предупреждение: Опыт работы не может превышать 50 лет. Установлено максимальное значение (50).")
            50
        } else {
            value
        }
    }

    override fun generateReport(): String {
        return """
            |=== ОТЧЕТ О СОТРУДНИКЕ ===
            |ФИО: $fullName
            |Должность: $position
            |Зарплата: $salary руб.
            |Опыт работы: $yearsOfExperience лет
            |==========================
        """.trimMargin()
    }
}