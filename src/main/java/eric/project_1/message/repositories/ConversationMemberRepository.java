package eric.project_1.message.repositories;

import eric.project_1.message.models.ConversationMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationMemberRepository extends JpaRepository<ConversationMember, UUID> {

    boolean existsByConversationConversationIdAndUserUserId(UUID conversationId, UUID senderId);

}
