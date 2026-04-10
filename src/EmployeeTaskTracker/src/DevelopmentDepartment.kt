class DevelopmentDepartment : Department(), ReportGenerator {
    override val departmentName: String = "Отдел разработки"

    override fun printDepartmentGoal() {
        println("Цель отдела разработки: Писать чистый и поддерживаемый код")
    }

    override fun generateReport(): String {
        return """
            |=== ОТЧЕТ ОБ ОТДЕЛЕ ===
            |Название: $departmentName
            |Цель: Писать чистый и поддерживаемый код
            |========================
        """.trimMargin()
    }
}