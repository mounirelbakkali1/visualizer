package ma.visualiserr.requests;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String username , @NotNull String password) {
}
