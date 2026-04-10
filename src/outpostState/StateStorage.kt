package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "state.txt"

    fun save(resources: List<ObservableResource>) {
        val content = resources.joinToString("\n") { "${it.name}=${it.amount}" }
        File(FILE_NAME).writeText(content)
        println("Состояние сохранено")
    }

    fun load(): Map<String, Int> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyMap()

        return file.readLines()
            .mapNotNull { line ->
                val parts = line.split("=")
                if (parts.size == 2) parts[0] to parts[1].toIntOrNull() else null
            }
            .filter { it.second != null }
            .associate { it.first to it.second!! }
    }
}