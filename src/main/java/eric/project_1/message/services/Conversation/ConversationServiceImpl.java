package eric.project_1.message.services.Conversation;

import eric.project_1.message.models.Conversation;
import eric.project_1.message.models.User;
import eric.project_1.message.repositories.ConversationRepository;
import eric.project_1.message.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    public ConversationServiceImpl(ConversationRepository conversationRepository, UserRepository userRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Conversation createConversation(String conversationName, List<UUID> membersId) {
        List<User> members = userRepository.findAllById(membersId);

        LocalDateTime now = LocalDateTime.now();

        Conversation conversation = Conversation.builder()
                .conversationId(UUID.randomUUID())
                .conversationName(conversationName)
                .membersList(members)
                .messagesList(new ArrayList<>())
                .createdAt(now)
                .updatedAt(now)
                .build();

        return conversationRepository.save(conversation);
    }

}
