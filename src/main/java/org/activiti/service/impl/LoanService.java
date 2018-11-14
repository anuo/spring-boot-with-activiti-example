package org.activiti.service.impl;

import org.activiti.service.ServiceTask;
import org.springframework.stereotype.Service;

@Service
public class LoanService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("放款完成");
    }
}
