package ma.visualiserr.requests;

import jakarta.annotation.Nonnull;

public record PasswordResetRequest(@Nonnull String currentPassword,@Nonnull String newPassword ,@Nonnull String passwordConfirm) {
}
