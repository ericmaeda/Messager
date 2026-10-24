package eric.project_1.message.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "conversation_members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "hashed_password", nullable = false)
    private String passwordHash;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // relationships
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messageList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ConversationMember> conversationMembersList;

}
