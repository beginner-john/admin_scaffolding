package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 反馈意见dao
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/5 10:58 上午
 */

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {



}
