package personal.llmapiclient.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class StreamingProcessor {
    private static final Logger log = LoggerFactory.getLogger(StreamingProcessor.class);

    public static void proceedStreaming(Flux<String> responseFlux) {
        AtomicInteger counter = new AtomicInteger(0);
        responseFlux.subscribe(
                chunk -> {
                    if (counter.incrementAndGet() % 10 == 0) {
                        log.info("Received chunk: {}", chunk);
                    }
                },
                error -> log.error(LogConstant.LOG_ERROR_MESSAGE, error.getMessage(), error),
                () -> log.info("Streaming finished.")
        );
    }
}
