package com.itxxz.module.flow.web;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itxxz.module.flow.entity.WfLeave;
import com.itxxz.module.flow.service.WfLeaveService;
import com.itxxz.utils.InstanceUtil;
import com.itxxz.utils.WFUtil;

/**
 * 请假流程演示
 * @author www.itxxz.com
 * 
 */
@RequestMapping("flow")
@Controller
public class LeaveController{
	
	@Autowired
	private WfLeaveService wfLeaveService;
	
	private static Logger logger = Logger.getLogger(LeaveController.class);
	
	@RequestMapping("myleave")
	public String myleave(){
		return "myleave";
	}

	/**
	 * 部署流程
	 * @author www.itxxz.com
	 */
	@RequestMapping("deploy")
	public String deploy(){
		logger.debug("即将部署流程");
		WFUtil.deploy();
		return "myleave";
	}
	
	/**
	 * 获取流程实例，启动流程
	 * @author www.itxxz.com
	 */
	@RequestMapping("startFlow")
	public void startFlow(WfLeave entity) {

		logger.debug("获取流程实例...");
		logger.debug("entity:"+entity);
		logger.debug("entity_name:"+entity.getName());
		ProcessInstance pi = WFUtil.startInstanceByKey(InstanceUtil.WFLEAVE_INSTANCEKEY);
		entity.setLeaveid(UUID.randomUUID().toString());
		entity.setInstanceid(pi.getId());
		logger.debug("开始入库...");
		wfLeaveService.insertWfLeave(entity);
		logger.debug("该申请已成功保存！");
	}
	
	/**
	 * 查看任务
	 *@author www.itxxz.com
	 * @return
	 */
	@RequestMapping("showTask")
	public String showTaskByAssignee(Model model,String assignee){
		logger.debug("assignee:"+assignee);
		logger.debug("任务所属:"+assignee);
		List<Task> taskList = WFUtil.findTaskByAssignee(assignee);
		model.addAttribute("assignee", assignee);
		model.addAttribute("taskList", taskList);
		return "taskList";
	}
	
	/**
	 * 执行任务
	 *@author www.itxxz.com
	 * @return
	 */
	@RequestMapping("complete/{taskid}")
	public String completeCurrentTask(@PathVariable String taskid){
		WFUtil.takeCompleteTask(taskid);
		return null;
	}
	
	/**
	 * 审批页面
	 *@author www.itxxz.com
	 * @return
	 */
	@RequestMapping("toCheck/{taskid}")
	public String toCheck(Model model,@PathVariable String taskid){
		model.addAttribute("taskid", taskid);
		return "toCheck";
	}
	
	/**
	 * 查看流程信息
	 *@author www.itxxz.com
	 * @return
	 */
	@RequestMapping("showImage/{procDefId}/{procIstid}")
	public String showImage(Model model,@PathVariable String procDefId,@PathVariable String procIstid){
		ActivityImpl wfLeaveImag = null;
		try {
			wfLeaveImag = WFUtil.getProcessMap(procDefId, procIstid);
			model.addAttribute("wfLeaveImag", wfLeaveImag);
		} catch (Exception e) {
			logger.error("查看流程信息常。。。。");
			e.printStackTrace();
		}
		logger.debug("已经获取流程信息!");
		return "showImg";
	}
	
	/**
	 * 获取流程图像
	 *@author www.itxxz.com
	 * @return
	 */
	@RequestMapping("findPic/{procDefId}")
	public void findPic(@PathVariable String procDefId,HttpServletResponse response){
		//HttpServletResponse response = ServletActionContext.getResponse();
		try {
			InputStream pic = WFUtil.findProcessPic(procDefId);
			
			byte[] b = new byte[1024];
			int len = -1;
			while((len = pic.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}

		} catch (Exception e) {
			logger.error("获取图片失败。。。");
			e.printStackTrace();
		}
	}
	

	/**
	 * 测试配置文件以及数据库链接是否成功
	 * @author www.itxxz.com
	 * 
	 */
	public void test() {
//		logger.debug("struts文件配置成功。。。。");
//		List<WfLeave> testList = wfLeaveService.findByEntity(null);
//		logger.debug("测试个数:" + testList.size());
//		for (WfLeave wf : testList) {
//			logger.debug(wf.getLeaveid() + "-" + wf.getName() + "-"
//					+ wf.getInstanceid());
//		}
		//Test.testImage();
	}

}
