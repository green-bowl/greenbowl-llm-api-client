package personal.llmapiclient.requestdto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@Getter
public class DefaultOptionsRequest extends AbstractOptionsRequest {
    private List<String> option1;
    private List<String> option2;
    private List<String> option3;

    @Builder
    private DefaultOptionsRequest(List<String> option1, List<String> option2, List<String> option3) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public static DefaultOptionsRequest of(List<String> option1, List<String> option2, List<String> option3) {
        return new DefaultOptionsRequest(option1, option2, option3);
    }
}
