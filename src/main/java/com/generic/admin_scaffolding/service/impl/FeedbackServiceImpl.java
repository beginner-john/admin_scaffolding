package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.constant.FieldConstant;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.Feedback;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.FeedbackRepository;
import com.generic.admin_scaffolding.service.FeedbackService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/5 11:01 上午
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackRepository feedbackRepository;

    @Override
    public Result<List<Feedback>> findFeedbackList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, FieldConstant.CREATED_TIME));
        Page<Feedback> data = feedbackRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<Feedback> saveFeedback(Feedback feedback) {
        feedback.setStatus(DataDictionaryEnum.UNDISPOSED.getCode());
        feedback.setCreateTime(DateUtils.getCurrentTimestamp());
        return Result.of(feedbackRepository.saveAndFlush(feedback));
    }

    @Override
    public Result<Feedback> handleFeedback(Feedback feedback) {
        if (feedback.getId() == null || feedback.getDispose() == null) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedback.getId());
        if (!optionalFeedback.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        Feedback fb = optionalFeedback.get();
        fb.setDispose(feedback.getDispose());
        fb.setStatus(DataDictionaryEnum.DISPOSED.getCode());
        fb.setUpdateTime(DateUtils.getCurrentTimestamp());
        fb.setUpdateBy(feedback.getUpdateBy());
        return Result.of(feedbackRepository.saveAndFlush(fb));
    }
}
