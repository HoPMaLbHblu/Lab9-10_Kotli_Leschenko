package outpostState

import kotlin.properties.Delegates

class ObservableResource(
    val name: String,
    initialAmount: Int
) {
    var amount: Int by Delegates.observable(initialAmount) { _, oldValue, newValue ->
        println("Ресурс $name изменён: $oldValue -> $newValue")
    }
}