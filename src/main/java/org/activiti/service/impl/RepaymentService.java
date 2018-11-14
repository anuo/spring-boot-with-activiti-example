package org.activiti.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RepaymentService implements ServiceTask {

    @Override
    public boolean execute(ProcessInstance processInstance, TaskService taskService) {
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        System.out.println("执行步骤: " + task.getName());
        if (task.getName().equals("Repayment")) {

            Map<String, Object> taskVariables = new HashMap<String, Object>();
            taskVariables.put("RepaymentOutcome", false);
            taskService.complete(task.getId(), taskVariables);
            return true;
        }

        return false;
    }
}
