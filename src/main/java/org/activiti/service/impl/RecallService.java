package org.activiti.service.impl;

import org.activiti.service.ServiceTask;
import org.springframework.stereotype.Service;

@Service
public class RecallService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("催收完成");

    }
}
