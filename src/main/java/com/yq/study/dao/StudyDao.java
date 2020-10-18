package com.yq.study.dao;

import com.yq.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudyDao extends JpaRepository<Study, Integer> {

    @Query(value = "select * from t_study where number = ?",nativeQuery=true)
    public List<Study> studyByNum(String num);
}
