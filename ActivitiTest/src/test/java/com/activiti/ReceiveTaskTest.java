package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月8日上午11:45:12
 * @version 1.0
 * @question 
 *           ReceiveTask与UserTask在运行时，act_ru_variable中的值的区别，ReceiveTask不会变，UserTask未知
 * 
 */
public class ReceiveTaskTest {
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
				.name("流程接收任务测试")// 添加部署的名称
				.addClasspathResource("bpm/ReceiveTaskTest.bpmn")// classpath的资源中加载，一次只能加载
				// 一个文件
				.addClasspathResource("bpm/ReceiveTaskTest.png")// classpath的资源中加载，一次只能加载一个文件
				.deploy();// 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称：" + deployment.getName());

	}

	@Test
	public void startProcessInstance() {
		// 启动流程实例
		ProcessInstance pi = processEngine.getRuntimeService()//
				.startProcessInstanceByKey("receiveTaskTest");// 使用流程定义的key的最新版本启动流程
		System.out.println("流程实例ID：" + pi.getId());
		System.out.println("流程定义的ID：" + pi.getProcessDefinitionId());
	}

	@Test
	public void executeReceiveTask1() {
		// 3.查询执行对象表,使用流程实例ID和当前活动的名称（receivetask1）
		String processInstanceId = "82501";// 得到流程实例ID
		Execution execution1 = processEngine.getRuntimeService()
				.createExecutionQuery().processInstanceId(processInstanceId)// 流程实例ID
				.activityId("receivetask1")// 当前活动的名称
				.singleResult();

		// 4.使用流程变量设置当日的销售额
		processEngine.getRuntimeService().setVariable(execution1.getId(),
				"当日销售额", 20000);
		System.out.println("executionId:" + execution1.getId());
	}

	@Test
	public void executeReceiveTask2() {
		// 3.查询执行对象表,使用流程实例ID和当前活动的名称（receivetask1）
		String processInstanceId = "82501";// 得到流程实例ID
		Execution execution2 = processEngine.getRuntimeService()
				.createExecutionQuery().processInstanceId(processInstanceId)// 流程实例ID
				.activityId("receivetask2")// 当前活动的名称
				.singleResult();

		// 7.获取流程变量,给老板发送短信
		Integer value = (Integer) processEngine.getRuntimeService()
				.getVariable(execution2.getId(), "当日销售额");
		System.out.println("给老板发送短信：内容，当日销售额：" + value);

		// 8.向后执行一步
		System.out.println("executionId:" + execution2.getId());
	}

	@Test
	public void next() {
		// 5.向后执行一步
		String executionId = "82501";
		processEngine.getRuntimeService().signal(executionId);
	}
}
