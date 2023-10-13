package com.contentapp.contentcalendar.repository;

import com.contentapp.contentcalendar.model.Content;
import com.contentapp.contentcalendar.model.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content WHERE status=:status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
