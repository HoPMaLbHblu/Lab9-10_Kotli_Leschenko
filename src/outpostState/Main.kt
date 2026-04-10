package outpostState

fun main() {
    val manager = OutpostManager()
    val minerals = ObservableResource("Minerals", 500)
    val gas = ObservableResource("Gas", 300)
    val food = ObservableResource("Food", 200)
    val observer = ResourceObserver()

    observer.observe(minerals)
    observer.observe(gas)
    observer.observe(food)
    manager.addResource(minerals)
    manager.addResource(gas)
    manager.addResource(food)

    println("\n--- Изменение ресурсов ---")
    minerals.amount = 650
    minerals.amount = 600
    gas.amount = 380
    food.amount = 300
    food.amount = 50

    println("\n--- Сохранение ---")
    StateStorage.save(manager.getAllResources())
    println("\n--- Загрузка ---")
    val loaded = StateStorage.load()
    loaded.forEach { (name, amount) ->
        println("$name: $amount")
    }
}