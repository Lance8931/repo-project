package com.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月1日下午5:31:24
 * @version 1.0
 */
public class ActivitiTest {

	/**
	 * 使用代码的方式创建Activiti数据库中的表
	 * 
	 *
	 * @date 2016年4月5日上午11:44:49
	 * @author siping-L.J.H
	 */
	@Test
	public void createTable() {
		// 工作流引擎的全部配置
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();

		// 链接数据的配置
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration
				.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("password");

		/*
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false";
		 * 不能自动创建表，需要表存在 public static final String DB_SCHEMA_UPDATE_CREATE_DROP
		 * = "create-drop"; 先删除表再创建表 public static final String
		 * DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
		 */
		// 如果表不存在，自动创建表
		processEngineConfiguration
				.setDatabaseSchemaUpdate(processEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		// 工作流的核心对象，ProcessEnginee对象
		ProcessEngine processEngine = processEngineConfiguration
				.buildProcessEngine();
		System.out.println(processEngine);

	}

	/**
	 * 部署流程定义 1、获取流程引擎对象 2、部署对象
	 * 
	 *
	 * @date 2016年4月5日上午11:46:04
	 * @author siping-L.J.H
	 */
	@Test
	public void deploymentProcessDefinition() {
		// 创建核心引擎对象
		// ProcessEngine processEngine =
		// ProcessEngines.getDefaultProcessEngine();
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"spring-activiti.xml").buildProcessEngine();
		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
				.createDeployment()// 创建一个部署对象
				.name("第一个Activiti程序")// 添加部署的名称
				.addClasspathResource("bpm/MyProcess.bpmn")// classpath的资源中加载，一次只能加载
															// 一个文件
				// .addClasspathResource("bpm/MyProcess.png")//
				// classpath的资源中加载，一次只能加载
				// 一个文件
				.deploy();// 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称：" + deployment.getName());
	}

	/**
	 * 启动流程实例
	 */
	@Test
	public void startProcessInstance() {
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"spring-activiti.xml").buildProcessEngine();
		// 流程定义的key
		String processDefinitionKey = "myProcess";
		ProcessInstance pi = processEngine.getRuntimeService()// 于正在执行的流程实例和执行对象相关的Service
				.startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应hellworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:" + pi.getId());// 流程实例ID 101
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); // 流程定义ID:myProcess:1:4
	}

	/**
	 * 查询当前人的个人任务
	 */
	@Test
	public void findMyPersonTask() {
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"spring-activiti.xml").buildProcessEngine();
		String assignee = "张三";
		List<Task> list = processEngine.getTaskService()// 与正在执行的认为管理相关的Service
				.createTaskQuery()// 创建任务查询对象
				.taskAssignee(assignee)// 指定个人认为查询，指定办理人
				.list();

		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间" + task);
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("#################################");
			}
		}
	}
}
