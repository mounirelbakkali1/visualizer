package ma.visualiserr.requests;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StatistiqueRequest(@NotNull String tranche_age ,@NotNull String sexe, @NotNull LocalDate date) {
}
