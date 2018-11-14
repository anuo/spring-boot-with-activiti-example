package org.activiti.service.impl;

import org.activiti.service.ServiceTask;

public class EnterItemService implements ServiceTask {
    @Override
    public void execute() {
        System.out.println("进件完成");

    }
}
