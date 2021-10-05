package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.entity.model.Feedback;
import com.generic.admin_scaffolding.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/5 11:01 上午
 */
@Api(tags = "反馈意见模块")
@RequestMapping("/feedback")
@RestController
public class FeedbackController extends AbstractController {

    @Resource
    private FeedbackService feedbackService;

    @ApiOperation("反馈意见列表")
    @GetMapping
    public Result<List<Feedback>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return feedbackService.findFeedbackList(page, pageSize);
    }

    /**
     * 一般反馈意见可以是在web端和app端，
     * 因此创建人用户id交由前端传过来
     */
    @ApiOperation("新增意见反馈")
    @PostMapping
    @OperationAspect(accessPath = "/feedback/save", accessDesc = "新增意见反馈")
    public Result<Feedback> save(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @ApiOperation("处理意见反馈")
    @PostMapping("/handle")
    @OperationAspect(accessPath = "/feedback/handle", accessDesc = "处理意见反馈")
    public Result<Feedback> handle(@RequestBody Feedback feedback) {
        return feedbackService.handleFeedback(feedback);
    }

}
