package com.activiti.service;

/**
 * @author : jiangBeiPing
 * @description: Activiti工作流测试
 * @date 2021/11/6
 */
public interface ActivitiService {

    /**
     * 创建一个工作流
     * @return 是否创建成功
     */
    boolean createDeployment();

    /**
     * 根据流程id进行一个任务流转
     * @param key 流程id
     * @return 是否成功
     */
    boolean startActivity(String key);

    /**
     * 获取所有待办任务
     * @return 是否获取成功
     */
    boolean getTaskList();

    /**
     * 根据任务id提交任务
     * @param taskId 流程id
     * @return 是否提交成功
     */
    boolean  complete(String taskId);

    /**
     * 根据流程id直接结束工单流程
     * @param runId 流程id
     * @return 是否结束成功
     */
    boolean  deleteProcessInstance(String runId);

}
