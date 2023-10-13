package com.contentapp.contentcalendar.repository;

import com.contentapp.contentcalendar.model.Content;
import com.contentapp.contentcalendar.model.Status;
import com.contentapp.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public  ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return  contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public Boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
                1, "My First blog post",
                "My first blog psot",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(c);
    }

    public void deleteContent(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
