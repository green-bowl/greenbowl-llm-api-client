package personal.llmapiclient.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.llmapiclient.client.LLMStreamingClient;
import personal.llmapiclient.requestdto.DefaultOptionsRequest;
import personal.llmapiclient.util.ResponseGenerator;
import personal.llmapiclient.util.StreamingProcessor;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class LLMController {
    private final LLMStreamingClient llmStreamingClient;

    @Value("${llm.template}")
    private String template;

    private static final String GET_LLM_STREAMING = "LLM API를 통해 특정 도메인 LLM 서비스 이용";
    private static final String GET_LLM_STREAMING_DESCRIPTION
            = "LLM API를 통해 특정 도메인 LLM 서비스를 이용할 수 있습니다.";

    private static final String GET_LLM_STREAMING_SSE = "LLM API를 통해 특정 도메인 LLM SSE 서비스 이용";
    private static final String GET_LLM_STREAMING_SSE_DESCRIPTION
            = "LLM API를 통해 특정 도메인 LLM SSE 서비스를 이용할 수 있습니다.";

    private static final String OPTION_ONE = "첫 번째 옵션";
    private static final String OPTION_ONE_EXAMPLE = "옵션1, 옵션2, 옵션3";

    private static final String OPTION_TWO = "두 번째 옵션";
    private static final String OPTION_TWO_EXAMPLE = "옵션1, 옵션2";

    private static final String OPTION_THREE = "세 번째 옵션";
    private static final String OPTION_THREE_EXAMPLE = "옵션1, 옵션2, 옵션3, 옵션4";

    @ApiOperation(value = GET_LLM_STREAMING, notes = GET_LLM_STREAMING_DESCRIPTION)
    @GetMapping(value = "/template", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Flux<String>> requestLLM(
            @ApiParam(value = OPTION_ONE, defaultValue = OPTION_ONE_EXAMPLE)
            @RequestParam List<String> option1,
            @ApiParam(value = OPTION_TWO, defaultValue = OPTION_TWO_EXAMPLE)
            @RequestParam List<String> option2,
            @ApiParam(value = OPTION_THREE, defaultValue = OPTION_THREE_EXAMPLE)
            @RequestParam List<String> option3
    ) {
        Flux<String> responseFlux = llmStreamingClient.receiveLLMStreaming(
                DefaultOptionsRequest.of(option1, option2, option3), template
        );

        StreamingProcessor.proceedStreaming(responseFlux);

        return ResponseGenerator.generateResponse(responseFlux, false);
    }

    @ApiOperation(value = GET_LLM_STREAMING_SSE, notes = GET_LLM_STREAMING_SSE_DESCRIPTION)
    @GetMapping(value = "/template/sse", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Flux<String>> requestSSELLM(
            @ApiParam(value = OPTION_ONE, defaultValue = OPTION_ONE_EXAMPLE)
            @RequestParam List<String> option1,
            @ApiParam(value = OPTION_TWO, defaultValue = OPTION_TWO_EXAMPLE)
            @RequestParam List<String> option2,
            @ApiParam(value = OPTION_THREE, defaultValue = OPTION_THREE_EXAMPLE)
            @RequestParam List<String> option3
    ) {
        Flux<String> responseFlux = llmStreamingClient.receiveLLMStreamingSSE(
                DefaultOptionsRequest.of(option1, option2, option3), template
        );

        StreamingProcessor.proceedStreaming(responseFlux);

        return ResponseGenerator.generateResponse(responseFlux, true);
    }
}
