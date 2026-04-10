fun processCharacterState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attacking -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Dead -> println("Персонаж погиб: ${state.cause}")
    }
}

fun main() {

    val character = GameCharacter("Артур")

    println("=== Игровая система состояний персонажа ===\n")

    println("1. Переход в состояние бега:")
    character.changeState(CharacterState.Running)
    processCharacterState(character.currentState)

    println("\n2. Переход в состояние атаки:")
    character.changeState(CharacterState.Attacking(25))
    processCharacterState(character.currentState)

    println("\n3. Переход в состояние смерти:")
    character.changeState(CharacterState.Dead("Падение с высокой скалы"))
    processCharacterState(character.currentState)

    println("\n=== Дополнительная демонстрация ===")

    val states = listOf(
        CharacterState.Idle,
        CharacterState.Running,
        CharacterState.Attacking(50),
        CharacterState.Dead("Отравление"),
        CharacterState.Attacking(100)
    )

    println("Обработка списка состояний:")
    for (state in states) {
        processCharacterState(state)
    }
}