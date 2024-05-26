package org.example.blog_page_task.repositories;

import org.example.blog_page_task.dtos.userdtos.UserDashboardListDto;
import org.example.blog_page_task.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
/*
* findByFieldName
* List<UserEntity>findByFirstName
* unique olmasin ama ilk tapdigini cixarsin findFirstByFieldName
* UserEntity findFirstByFirstName
*/