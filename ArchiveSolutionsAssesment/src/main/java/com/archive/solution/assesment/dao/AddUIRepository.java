package com.archive.solution.assesment.dao;

import com.archive.solution.assesment.model.AddUI;
import com.archive.solution.assesment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddUIRepository extends JpaRepository<AddUI, Long> {
    User findByEmail(String emailId);
}
