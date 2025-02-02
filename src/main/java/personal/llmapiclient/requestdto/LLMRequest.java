package personal.llmapiclient.requestdto;

import lombok.Getter;

@Getter
public class LLMRequest {
    private String llm_type;
    private String template;
    private AbstractOptionsRequest options;
    private String secret_key;

    private LLMRequest(String llm_type, String template, AbstractOptionsRequest optionsRequest, String secret_key) {
        this.llm_type = llm_type;
        this.template = template;
        options = optionsRequest;
        this.secret_key = secret_key;
    }

    public static LLMRequest from(
            String llm_type, String template, AbstractOptionsRequest optionsRequest, String secret_key
    ) {
        return new LLMRequest(llm_type, template, optionsRequest, secret_key);
    }
}
