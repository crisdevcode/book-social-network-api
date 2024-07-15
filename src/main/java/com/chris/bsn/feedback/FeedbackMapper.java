package com.chris.bsn.feedback;

import com.chris.bsn.book.Book;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .rating(request.rating())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false) // Not required and has no impact :: just to satisfy lombok
                        .shareable(false) // Not required and has no impact :: just to satisfy lombok
                        .build()
                )
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
        return FeedbackResponse.builder()
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
