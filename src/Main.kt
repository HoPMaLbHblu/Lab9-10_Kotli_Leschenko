import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager
import modules.ModuleResult

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced -> println("Произведено: ${result.resourceName} + ${result.amount}")
        is ModuleResult.NotEnoughResources -> println(
            "Недостаточно ресурса ${result.resourceName}. " + "Нужно: ${result.required}, есть: ${result.available}"
        )
        is ModuleResult.Error -> println("ОШИБКА: ${result.reason}")
    }
}

object  SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }

    fun log(message: String) {
        println("[LOG] $message")
    }
}

val logger by lazy {
    SystemLogger
}

fun main() {
    val manager = ResourceManager()
//    val minerals = resources.OutpostResource(1, "Minerals", 300)
//    val gas = resources.OutpostResource(2, "Gas", 100)

//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
    manager.add(OutpostResource(1, "Minerals", 300))
    manager.add(OutpostResource(2, "Gas", 100))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()

    logger.log("Запуск базы")

    val loadedResource = FileStorage.load()
    loadedResource.forEach {manager.add(it)}
    if (loadedResource.isEmpty()) {
        manager.add(OutpostResource(1, "Minerals", 300))
        manager.add(OutpostResource(2, "Gas", 100))
    }
    FileStorage.save(manager.getAll())
}