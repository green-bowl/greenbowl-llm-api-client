package personal.llmapiclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import personal.llmapiclient.requestdto.AbstractOptionsRequest;
import personal.llmapiclient.requestdto.LLMRequest;
import reactor.core.publisher.Flux;

@Component
public class LLMStreamingClient {
    private final WebClient webClient;
    private static final String LLM_SERVER_URL = "https://hyobin-llm.duckdns.org";

    public LLMStreamingClient() {
        webClient = WebClient.create(LLM_SERVER_URL);
    }

    @Value("${llm.type}")
    private String llmType;

    @Value("${llm.server.secret-key}")
    private String secretKey;

    @Value("${llm.server.endpoint.streaming}")
    private String streamingRequestEndpoint;

    @Value("${llm.server.endpoint.sse}")
    private String sseRequestEndpoint;

    public Flux<String> receiveLLMStreaming(AbstractOptionsRequest optionsRequest, String template) {
        LLMRequest llmRequest = LLMRequest.from(llmType, template, optionsRequest, secretKey);

        return webClientRequest(streamingRequestEndpoint, llmRequest);
    }

    public Flux<String> receiveLLMStreamingSSE(AbstractOptionsRequest optionsRequest, String template) {
        LLMRequest llmRequest = LLMRequest.from(llmType, template, optionsRequest, secretKey);

        return webClientRequest(sseRequestEndpoint, llmRequest);
    }

    private Flux<String> webClientRequest(String requestEndpoint, LLMRequest llmRequest) {
        return webClient.post()
                .uri(requestEndpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .bodyValue(llmRequest)
                .retrieve()
                .bodyToFlux(String.class);
    }
}
