package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

public class OverdueService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("逾期计算完成");
    }
}
