package dev.zitech.compose.authentication.model

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String? = null,
    val error: String? = null,
    val isLoading: Boolean = false,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList()
) {

    fun isFormValid(): Boolean =
        email?.isNotEmpty() == true &&
            password?.isNotEmpty() == true &&
            (authenticationMode == AuthenticationMode.SIGN_UP || passwordRequirements.containsAll(
                PasswordRequirements.values().toList()
            ))
}