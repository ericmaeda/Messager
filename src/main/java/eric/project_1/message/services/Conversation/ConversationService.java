package eric.project_1.message.services.Conversation;

import eric.project_1.message.dto.requests.CreateConversationRequest;
import eric.project_1.message.dto.responses.CreateConversationResponse;
import eric.project_1.message.models.Conversation;
import eric.project_1.message.models.Message;
import eric.project_1.message.models.User;

import java.util.List;
import java.util.UUID;

public interface ConversationService {

    Conversation createConversation(String conversationName, List<UUID> members);

}
