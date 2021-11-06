package com.activiti.service.impl;

import com.activiti.service.ActivitiService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : jiangBeiPing
 * @description: Activiti工作流测试
 * @date 2021/11/6
 */
@Slf4j
@Service
public class ActivitiServiceImpl implements ActivitiService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public boolean createDeployment() {
        DeploymentBuilder builder = repositoryService.createDeployment();
        // idea高版本与bmp插件不谦容，故直接把bpmn文件放到resource下
        builder.addClasspathResource("test.bpmn");
        // 进行发布
        Deployment deploy = builder.deploy();
        // 以发布后的Deployment为条件获取流程key
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
        log.info("流程key:{}",processDefinition.getKey());
        return true;
    }

    @Override
    public boolean startActivity(String key) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        String id = processInstance.getId();
        log.info("流程id:{}",id);
        return true;
    }

    @Override
    public boolean getTaskList() {
        // 查询所有待办
        List<Task> taskList = taskService.createTaskQuery().list();
        taskList.forEach(task -> log.info("待办任务:{}",task.toString()));
        return true;
    }

    @Override
    public boolean complete(String taskId) {
        taskService.complete(taskId);
        return true;
    }

    @Override
    public boolean deleteProcessInstance(String runId) {
        runtimeService.deleteProcessInstance(runId,"此流程已结束");
        return true;
    }
}
