package outpostState

class OutpostManager {
    private val resources: MutableList<ObservableResource> by lazy {
        println("Создание менеджера аванпоста")
        mutableListOf()
    }

    fun addResource(resource: ObservableResource) {
        resources.add(resource)
    }

    // Просто используйте свойство resources напрямую
    fun getAllResources(): List<ObservableResource> = resources.toList()
}