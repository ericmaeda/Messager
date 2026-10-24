package eric.project_1.message.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "conversation_members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID messageId;

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    // relationships
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation;

}
