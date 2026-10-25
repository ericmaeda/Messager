package eric.project_1.message.services.Message;

import eric.project_1.message.dto.requests.SendMessageRequest;
import eric.project_1.message.dto.responses.MessageResponse;
import eric.project_1.message.exceptions.GlobalExceptionHandler;
import eric.project_1.message.models.Conversation;
import eric.project_1.message.models.Message;
import eric.project_1.message.models.User;
import eric.project_1.message.repositories.ConversationMemberRepository;
import eric.project_1.message.repositories.ConversationRepository;
import eric.project_1.message.repositories.MessageRepository;
import eric.project_1.message.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    private final ConversationMemberRepository conversationMemberRepository;

    public MessageServiceImpl(
            MessageRepository messageRepository,
            UserRepository userRepository,
            ConversationRepository conversationRepository,
            ConversationMemberRepository conversationMemberRepository
    ) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
        this.conversationMemberRepository = conversationMemberRepository;
    }

    @Override
    @Transactional
    public Message sendMessage(UUID senderId, UUID conversationId, String messageContent) throws AccessDeniedException {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new GlobalExceptionHandler("User tidak ditemukan!"));

        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new GlobalExceptionHandler("Conversation tidak ditemukan"));

        if (!conversationMemberRepository.existsByConversationConversationIdAndUserUserId(conversationId, senderId)) {
            throw new AccessDeniedException("User bukan anggota conversation!");
        }

        Message message = Message.builder()
                .messageId(UUID.randomUUID())
                .messageContent(messageContent)
                .sender(sender)
                .conversation(conversation)
                .sentAt(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }

}
