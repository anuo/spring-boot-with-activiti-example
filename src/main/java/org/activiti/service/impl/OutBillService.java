package org.activiti.service.impl;

import org.activiti.service.ServiceTask;
import org.springframework.stereotype.Service;

@Service
public class OutBillService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("执行步骤: OutBill ");

    }
}
