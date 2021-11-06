package com.activiti.controller;

import com.activiti.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiangBeiPing
 * @description: Activiti工作流测试
 * @date 2021/11/6
 */
@RestController
@RequestMapping(value = "/jbp/activiti")
public class ActivitiController {

    @Autowired
    private ActivitiService activitiService;

    /**
     * 注册流程
     * @return
     */
    @RequestMapping("/createDeployment")
    public Boolean createDeployment(){
        return activitiService.createDeployment();
    }

    /**
     * 启动流程
     * @return
     */
    @RequestMapping("/startActivityDemo")
    public Boolean startActivityDemo(){
        return activitiService.startActivity("process_sql_9998");
    }

    /**
     * 获取待办
     * @return
     */
    @RequestMapping("/getTaskList")
    public boolean getTaskList(){
        return activitiService.getTaskList();
    }

    /**
     * 提交
     * @param taskId
     * @return
     */
    @RequestMapping("/complete")
    public boolean complete(String taskId){
        return activitiService.complete(taskId);
    }

    /**
     * 根据流程id直接结束流程
     * @paramru
     * @return
     */
    @RequestMapping("/deleteProcessInstance")
    public boolean deleteProcessInstance(String runId){
        return activitiService.deleteProcessInstance(runId);
    }

}
