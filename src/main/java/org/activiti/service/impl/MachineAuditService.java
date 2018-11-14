package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

import org.springframework.stereotype.Service;

@Service
public class MachineAuditService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("机审完成");
    }
}
