package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionToChatGPT {
    public String prompt;
    public Integer max_tokens;
    public Double temperature;
}
