package com.activiti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月1日下午5:31:24
 * @version 1.0
 */
public class ActivitiTest {

	private ProcessEngine processEngine;

	@Before
	public void beforeTest() {
		processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"spring-activiti.xml").buildProcessEngine();
	}

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
				.setJdbcUrl("jdbc:mysql://localhost:3306/activiti_test?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
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

		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
				.createDeployment()// 创建一个部署对象
				.name("第一个Activiti程序")// 添加部署的名称
				.addClasspathResource("bpm/MyProcess.bpmn")// classpath的资源中加载，一次只能加载
															// 一个文件
				.addClasspathResource("bpm/MyProcess.png")// classpath的资源中加载，一次只能加载一个文件
				.deploy();// 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称：" + deployment.getName());
	}

	/**
	 * 启动流程实例
	 */
	@Test
	public void startProcessInstance() {
		// 流程定义的key
		String processDefinitionKey = "myProcess";
		ProcessInstance pi = processEngine.getRuntimeService()// 与正在执行的流程实例和执行对象相关的Service
				.startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应myProcess.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:" + pi.getId());// 流程实例ID 101
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); // 流程定义ID:myProcess:1:4
	}

	/**
	 * 查询当前人的个人任务
	 */
	@Test
	public void findMyPersonTask() {
		String assignee = "李四";
		List<Task> list = processEngine.getTaskService()// 与正在执行的认为管理相关的Service
				.createTaskQuery()// 创建任务查询对象
				.taskAssignee(assignee)// 指定个人认为查询，指定办理人
				.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + task.getCreateTime());
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("#################################");
			}
		}
	}

	/** 完成任务 */
	@Test
	public void completeTask() {
		String taskID = "2504";
		processEngine.getTaskService().complete(taskID);
		System.out.println("完成任务：" + taskID);
	}

	/**
	 * 查询流程定义
	 * 
	 *
	 * @date 2016年4月6日下午3:07:56
	 * @author siping-L.J.H
	 */
	@Test
	public void findProcessDifinitionList() {
		List<ProcessDefinition> list = processEngine.getRepositoryService()
				.createProcessDefinitionQuery()
				// 查询条件
				.processDefinitionKey("myProcess")// 按照流程定义的key
				// .processDefinitionId("helloworld")//按照流程定义的ID
				.orderByProcessDefinitionVersion().desc()// 排序
				// 返回结果
				// .singleResult()//返回惟一结果集
				// .count()//返回结果集数量
				// .listPage(firstResult, maxResults)
				.list();// 多个结果集

		if (list != null && list.size() > 0) {
			for (ProcessDefinition pd : list) {
				System.out.println("流程定义的ID：" + pd.getId());
				System.out.println("流程定义的名称：" + pd.getName());
				System.out.println("流程定义的Key：" + pd.getKey());
				System.out.println("流程定义的部署ID：" + pd.getDeploymentId());
				System.out.println("流程定义的资源名称：" + pd.getResourceName());
				System.out.println("流程定义的版本：" + pd.getVersion());
				System.out
						.println("########################################################");
			}
		}
	}

	/**
	 * 删除流程定义 因为删除的是流程定义，而流程定义的部署是属于仓库服务的，所以应该先得到RepositoryService
	 * 如果该流程定义下没有正在运行的流程，则可以用普通删除。如果是有关联的信息，用级联删除。项目开发中使
	 * 用级联删除的情况比较多，删除操作一般只开放给超级管理员使用。
	 *
	 * @date 2016年4月6日下午4:38:06
	 * @author siping-L.J.H
	 */
	@Test
	public void deleteProcessDifinition() {
		// 部署对象ID
		String deploymentId = "7501";
		processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.deleteDeployment(deploymentId, true);

		System.out.println("删除成功~~~");// 使用部署ID删除流程定义,true表示级联删除
	}

	// 查看流程定义的资源文件
	@Test
	public void viewPng() throws IOException {
		// 部署ID
		String deploymentId = "1";
		// 获取的资源名称
		List<String> list = processEngine.getRepositoryService()
				.getDeploymentResourceNames(deploymentId);
		// 获得资源名称后缀.png
		String resourceName = "";
		if (list != null && list.size() > 0) {
			for (String name : list) {
				if (name.indexOf(".png") >= 0) {// 返回包含该字符串的第一个字母的索引位置
					resourceName = name;
				}
			}
		}
		// 获取输入流，输入流中存放.PNG的文件
		InputStream in = processEngine.getRepositoryService()
				.getResourceAsStream(deploymentId, resourceName);
		// 将获取到的文件保存到本地
		FileUtils.copyInputStreamToFile(in, new File("D:/" + resourceName));
		System.out.println("文件保存成功！");
	}

	/**
	 * 设置流程变量
	 * 
	 * @description 基础类型
	 *
	 * @date 2016年4月6日下午5:11:58
	 * @author siping-L.J.H
	 */
	@Test
	public void setProcessVariables() {
		String processInstanceId = "2501";// 流程实例ID
		String assignee = "李四";// 任务办理人
		TaskService taskService = processEngine.getTaskService();// 获取任务的Service，设置和获取流程变量

		// 查询当前办理人的任务ID
		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstanceId)// 使用流程实例ID
				.taskAssignee(assignee)// 任务办理人
				.singleResult();

		// 设置流程变量【基本类型】，有则修改，无则添加，直接调用sql语句
		taskService.setVariable(task.getId(), "请假人", assignee);
		taskService.setVariableLocal(task.getId(), "请假天数", 3);
		taskService.setVariable(task.getId(), "请假日期", new Date());
	}

	/**
	 * 设置流程变量？去哪个表里查
	 * Javabean类型设置获取流程变量，除了需要这个javabean实现了Serializable接口外，还要求流程变量对象的属性不能发生变化
	 * ，否则抛出异常。
	 *
	 * @date 2016年4月6日下午5:12:45
	 * @author siping-L.J.H
	 */
	@Test
	public void setProcessVariables1() {
		String processInstanceId = "2501";// 流程实例ID
		String assignee = "李四";// 任务办理人
		TaskService taskService = processEngine.getTaskService();// 获取任务的Service，设置和获取流程变量
		// 查询当前办理人的任务ID
		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstanceId)// 使用流程实例ID
				.taskAssignee(assignee)// 任务办理人
				.singleResult();

		// 设置流程变量【javabean类型】
		Person p = new Person();
		p.setId(1);
		p.setName("李锦欢");
		taskService.setVariable(task.getId(), "人员信息", p);
		System.out.println("流程变量设置成功~~");
	}

	/** 获取流程变量 */
	@Test
	public void getProcessVariables() {
		String processInstanceId = "2501";// 流程实例ID
		String assignee = "李四";// 任务办理人
		TaskService taskService = processEngine.getTaskService();
		// 获取当前办理人的任务ID
		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstanceId).taskAssignee(assignee)
				.singleResult();

		// 获取流程变量【基本类型】
		String person = (String) taskService.getVariable(task.getId(), "请假人");
		Integer day = (Integer) taskService.getVariableLocal(task.getId(),
				"请假天数");
		Date date = (Date) taskService.getVariable(task.getId(), "请假日期");
		System.out.println(person + "  " + day + "   " + date);

	}

	/** 获取流程变量 */
	@Test
	public void getProcessVariables1() {
		String processInstanceId = "2501";// 流程实例ID
		String assignee = "李四";// 任务办理人
		TaskService taskService = processEngine.getTaskService();
		// 获取当前办理人的任务ID
		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstanceId).taskAssignee(assignee)
				.singleResult();

		// 获取流程变量【javaBean类型】
		Person p = (Person) taskService.getVariable(task.getId(), "人员信息");
		System.out.println(p.getId() + "  " + p.getName());
		System.out.println("获取成功~~");
	}

	/** 查询历史的流程变量 */
	@Test
	public void getHistoryProcessVariables() {
		List<HistoricVariableInstance> list = processEngine.getHistoryService()
				.createHistoricVariableInstanceQuery()// 创建一个历史的流程变量查询
				.variableName("请假天数").list();

		if (list != null && list.size() > 0) {
			for (HistoricVariableInstance hiv : list) {
				System.out.println(hiv.getTaskId() + "  "
						+ hiv.getVariableName() + "     " + hiv.getValue()
						+ "      " + hiv.getVariableTypeName());
			}
		}
	}

	/**
	 * 查询历史流程实例,查找按照某个流程定义的规则一共执行了多少次流程，对应的数据库表：act_hi_procinst
	 */
	@Test
	public void findHisProcessInstance() {
		List<HistoricProcessInstance> list = processEngine.getHistoryService()
				.createHistoricProcessInstanceQuery()
				.processDefinitionId("myProcess:2:17504")// 流程定义ID
				.list();

		if (list != null && list.size() > 0) {
			for (HistoricProcessInstance hi : list) {
				System.out.println(hi.getId() + "   " + hi.getStartTime()
						+ "   " + hi.getEndTime());
			}
		}
	}

	/**
	 * 查询历史活动 问题：HistoricActivityInstance对应哪个表
	 * 问题：HistoricActivityInstance和HistoricTaskInstance有什么区别
	 * 查询历史活动，就是查询某一次流程的执行一共经历了多少个活动，这里我们使用流程定义ID来查询，对应的数据库表为:act_hi_actinst
	 */
	@Test
	public void findHisActivitiList() {
		String processInstanceId = "2501";
		List<HistoricActivityInstance> list = processEngine.getHistoryService()
				.createHistoricActivityInstanceQuery()
				.processInstanceId(processInstanceId).list();
		if (list != null && list.size() > 0) {
			for (HistoricActivityInstance hai : list) {
				System.out.println(hai.getId() + "  " + hai.getActivityName());
			}
		}
	}

	/**
	 * 查询历史流程变量，就是查询某一次流程的执行一共设置的流程变量，对应表：act_hi_varinst
	 */
	@Test
	public void findHisVariablesList() {
		String processInstanceId = "2501";
		List<HistoricVariableInstance> list = processEngine.getHistoryService()
				.createHistoricVariableInstanceQuery()
				.processInstanceId(processInstanceId).list();
		if (list != null && list.size() > 0) {
			for (HistoricVariableInstance hvi : list) {
				System.out.println(hvi.getId() + "    " + hvi.getVariableName()
						+ "   " + hvi.getValue());
			}
		}
	}
}
