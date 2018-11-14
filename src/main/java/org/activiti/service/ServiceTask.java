package org.activiti.service;

import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;

public interface ServiceTask {
    boolean execute(ProcessInstance processInstance, TaskService taskService);
}
