class GameCharacter(val name: String) {
    var currentState: CharacterState = CharacterState.Idle
        private set

    fun changeState(newState: CharacterState) {
        currentState = newState
        println("${name} изменил состояние на: ${getStateDescription(newState)}")
    }

    private fun getStateDescription(state: CharacterState): String {
        return when (state) {
            is CharacterState.Idle -> "Бездействие"
            is CharacterState.Running -> "Бег"
            is CharacterState.Attacking -> "Атака (урон: ${state.damage})"
            is CharacterState.Dead -> "Смерть (${state.cause})"
        }
    }
}