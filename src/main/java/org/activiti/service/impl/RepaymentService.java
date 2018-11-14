package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

public class RepaymentService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("还款完成");

    }
}
