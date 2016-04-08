package com.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

/**
 * 流程排他网关测试
 *
 * @author siping-L.J.H
 * @date 2016年4月8日上午10:21:53
 * @version 1.0
 */
public class ExclusiveGateWayTest {
	private ProcessEngine processEngine;

	@Before
	public void beforeTest() {
		processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"spring-activiti.xml").buildProcessEngine();
	}

	@Test
	public void deploymentProcessDefinition() {
		// 创建核心引擎对象
		// ProcessEngine processEngine =
		// ProcessEngines.getDefaultProcessEngine();

		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
				.createDeployment()// 创建一个部署对象
				.name("流程排他网关测试")// 添加部署的名称
				.addClasspathResource("bpm/ExclusiveGateWayTest.bpmn")// classpath的资源中加载，一次只能加载
				// 一个文件
				.addClasspathResource("bpm/ExclusiveGateWayTest.png")// classpath的资源中加载，一次只能加载一个文件
				.deploy();// 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称：" + deployment.getName());

	}

	@Test
	public void startProcessInstance() {
		// 启动流程实例
		ProcessInstance pi = processEngine.getRuntimeService()//
				.startProcessInstanceByKey("exclusiveGateWayTest");// 使用流程定义的key的最新版本启动流程
		System.out.println("流程实例ID：" + pi.getId());
		System.out.println("流程定义的ID：" + pi.getProcessDefinitionId());
	}

	/** 查询DepartLeader的个人任务 */
	@Test
	public void findPersonalTaskList() {
		// 任务办理人
		// String assignee = "FeeApply";
		// String assignee = "DepartCheck";
		String assignee = "FinanceCheck";
		// String assignee = "ManagerCheck";
		List<Task> list = processEngine.getTaskService()//
				.createTaskQuery()//
				.taskAssignee(assignee)// 个人任务的查询
				.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}
	}

	/** 完成任务 */
	@Test
	public void completeTask() {
		// 任务ID
		String taskId = "22504";
		// 完成任务的同时，设置流程变量，让流程变量判断连线该如何执行
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("money", 499);
		processEngine.getTaskService().complete(taskId, variables);
		System.out.println("完成任务：" + taskId);

		// TaskService taskService = processEngine.getTaskService();
		// taskService.setVariable(taskId, "message", "不重要");
	}

	@Test
	public void completeTask1() {
		String taskId = "35004";
		processEngine.getTaskService().complete(taskId);
	}
}
