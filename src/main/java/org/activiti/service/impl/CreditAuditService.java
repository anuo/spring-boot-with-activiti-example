package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

public class CreditAuditService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("信审完成");
    }
}
