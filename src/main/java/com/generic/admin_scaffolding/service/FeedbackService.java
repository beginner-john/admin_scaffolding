package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.Feedback;

import java.util.List;

/**
 * 反馈意见
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/5 11:00 上午
 */
public interface FeedbackService {

    Result<List<Feedback>> findFeedbackList(int page, int pageSize);

    Result<Feedback> saveFeedback(Feedback feedback);

    Result<Feedback> handleFeedback(Feedback feedback);
}
