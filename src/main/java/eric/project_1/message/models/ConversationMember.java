package eric.project_1.message.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "conversation_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversationMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID conversationMembersId;

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    // relationships
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Conversation conversation;

}
