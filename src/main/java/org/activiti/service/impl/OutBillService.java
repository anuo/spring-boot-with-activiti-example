package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

public class OutBillService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("出账完成");
    }
}
