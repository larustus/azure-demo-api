package com.example.azuredemo.service;

import com.example.azuredemo.dto.CommentResponse;
import com.example.azuredemo.dto.CreateCommentRequest;
import com.example.azuredemo.entity.Comment;
import com.example.azuredemo.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public CommentResponse createComment(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setAuthor(request.author().trim());
        comment.setContent(request.content().trim());

        return toResponse(commentRepository.save(comment));
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> listComments() {
        return commentRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CommentResponse toResponse(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getAuthor(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}
