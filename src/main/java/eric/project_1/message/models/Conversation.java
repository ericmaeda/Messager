package eric.project_1.message.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "conversation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID conversationId;

    @Column(name = "conversation_name")
    private String conversationName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // relationships
    @OneToMany
    private List<User> membersList;

    @OneToMany
    private List<Message> messagesList;

    public Conversation toResponse() {
        return Conversation.builder()
                .conversationId(this.conversationId)
                .conversationName(this.conversationName)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .membersList(this.membersList)
                .messagesList(this.messagesList)
                .build();
    }
}
