package eric.project_1.message.controllers;

import eric.project_1.message.dto.requests.CreateConversationRequest;
import eric.project_1.message.dto.responses.CreateConversationResponse;
import eric.project_1.message.models.Conversation;
import eric.project_1.message.services.Conversation.ConversationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateConversationResponse> createConversation(
            @Valid @RequestBody CreateConversationRequest request
            )
    {

        Conversation conversation = conversationService.createConversation(
                request.conversationName(), request.membersId()
                );


    }

}
