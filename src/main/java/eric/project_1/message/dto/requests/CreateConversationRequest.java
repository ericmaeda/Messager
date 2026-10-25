package eric.project_1.message.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record CreateConversationRequest(
        @NotBlank
        @Size(max = 20)
        String conversationName,

        @NotEmpty
        List<UUID> membersId
) {}
