package eric.project_1.message.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SendMessageRequest(
        @NotBlank
        @Size(max = 5000)
        String messageContent
) {}
