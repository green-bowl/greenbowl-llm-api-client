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
import personal.llmapiclient.requestdto.RecipeOptionsRequest;
import personal.llmapiclient.util.ResponseGenerator;
import personal.llmapiclient.util.StreamingProcessor;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class LLMExampleController {
    private final LLMStreamingClient llmStreamingClient;

    @Value("${llm.recipe.template}")
    private String template;

    private static final String GET_RECIPE_LLM_STREAMING = "LLM API를 통해 레시피 정보를 조회하는 예시";
    private static final String GET_RECIPE_LLM_STREAMING_DESCRIPTION
            = "LLM API를 통해 레시피 정보를 조회할 수 있습니다.";

    private static final String GET_RECIPE_LLM_SSE_STREAMING = "LLM API를 통해 SSE 방식으로 레시피 정보를 조회하는 예시";
    private static final String GET_RECIPE_LLM_SSE_STREAMING_DESCRIPTION
            = "LLM API를 통해 SSE 방식으로 레시피 정보를 조회할 수 있습니다.";

    private static final String MEAL_TYPE = "식사 유형";
    private static final String MEAL_TYPE_EXAMPLE = "아침";

    private static final String CUISINETYPE = "요리 유형";
    private static final String CUISINETYPE_EXAMPLE = "한식";

    private static final String INGREDIENTS = "재료 목록";
    private static final String INGREDIENTS_EXAMPLE = "된장, 파, 마늘";

    private static final String COOKING_UTENSILS = "조리 도구";
    private static final String COOKING_UTENSILS_EXAMPLE = "프라이팬, 냄비, 식칼";

    private static final String COOKING_TIME = "조리 시간";
    private static final String COOKING_TIME_EXAMPLE = "30분";

    @ApiOperation(
            value = GET_RECIPE_LLM_STREAMING, notes = GET_RECIPE_LLM_STREAMING_DESCRIPTION
    )
    @GetMapping(value = "/example", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Flux<String>> requestRecipeLLM(
            @ApiParam(value = MEAL_TYPE, example = MEAL_TYPE_EXAMPLE)
            @RequestParam String mealType,
            @ApiParam(value = CUISINETYPE, example = CUISINETYPE_EXAMPLE)
            @RequestParam String cuisineType,
            @ApiParam(value = INGREDIENTS, defaultValue = INGREDIENTS_EXAMPLE)
            @RequestParam List<String> ingredients,
            @ApiParam(value = COOKING_UTENSILS, defaultValue = COOKING_UTENSILS_EXAMPLE)
            @RequestParam List<String> cookingUtensils,
            @ApiParam(value = COOKING_TIME, example = COOKING_TIME_EXAMPLE)
            @RequestParam String cookingTime
    ) {
        Flux<String> responseFlux = llmStreamingClient.receiveLLMStreaming(
                RecipeOptionsRequest.of(mealType, cuisineType, ingredients, cookingUtensils, cookingTime), template
        );

        StreamingProcessor.proceedStreaming(responseFlux);

        return ResponseGenerator.generateResponse(responseFlux, false);
    }

    @ApiOperation(
            value = GET_RECIPE_LLM_SSE_STREAMING, notes = GET_RECIPE_LLM_SSE_STREAMING_DESCRIPTION
    )
    @GetMapping(value = "/example/sse", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Flux<String>> requestRecipeSSELLM(
            @ApiParam(value = MEAL_TYPE, example = MEAL_TYPE_EXAMPLE)
            @RequestParam String mealType,
            @ApiParam(value = CUISINETYPE, example = CUISINETYPE_EXAMPLE)
            @RequestParam String cuisineType,
            @ApiParam(value = INGREDIENTS, defaultValue = INGREDIENTS_EXAMPLE)
            @RequestParam List<String> ingredients,
            @ApiParam(value = COOKING_UTENSILS, defaultValue = COOKING_UTENSILS_EXAMPLE)
            @RequestParam List<String> cookingUtensils,
            @ApiParam(value = COOKING_TIME, example = COOKING_TIME_EXAMPLE)
            @RequestParam String cookingTime
    ) {
        Flux<String> responseFlux = llmStreamingClient.receiveLLMStreamingSSE(
                RecipeOptionsRequest.of(mealType, cuisineType, ingredients, cookingUtensils, cookingTime), template
        );

        StreamingProcessor.proceedStreaming(responseFlux);

        return ResponseGenerator.generateResponse(responseFlux, true);
    }
}
