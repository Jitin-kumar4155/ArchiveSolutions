package com.archive.solution.assesment.dao;

import com.archive.solution.assesment.model.AddUI;
import com.archive.solution.assesment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddUIRepository extends JpaRepository<AddUI, Long> {
}
