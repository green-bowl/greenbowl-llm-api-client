package personal.llmapiclient.util;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

public class ResponseGenerator {
    public static ResponseEntity<Flux<String>> generateResponse(Flux<String> responseFlux, boolean isSSE) {
        StringBuilder stringBuilder = new StringBuilder();

        if (isSSE) {
            stringBuilder.append("data: ");
        }
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        responseFlux.flatMap(chunk ->
                                Flux.just(stringBuilder + chunk + "\n\n")
                        )
                );
    }
}
