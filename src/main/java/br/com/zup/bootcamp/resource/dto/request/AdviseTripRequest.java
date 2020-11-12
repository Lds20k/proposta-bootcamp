package br.com.zup.bootcamp.resource.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

// Carga intrínseca = 0/7
public class AdviseTripRequest {

    @NotBlank
    private final String destiny;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate ending;

    public AdviseTripRequest(String destiny, LocalDate ending) {
        this.destiny = destiny;
        this.ending = ending;
    }

    public String getDestiny() {
        return destiny;
    }

    public LocalDate getEnding() {
        return ending;
    }
}
