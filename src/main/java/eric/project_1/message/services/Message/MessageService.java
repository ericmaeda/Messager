package eric.project_1.message.services.Message;

import eric.project_1.message.models.Message;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

public interface MessageService {

    Message sendMessage(UUID senderId, UUID conversationId, String messageContent) throws AccessDeniedException;

}
