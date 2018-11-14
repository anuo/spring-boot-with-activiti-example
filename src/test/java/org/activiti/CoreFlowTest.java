package org.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.service.ServiceTask;
import org.activiti.service.impl.CreditAuditService;
import org.activiti.service.impl.EnterItemService;
import org.activiti.service.impl.LoanService;
import org.activiti.service.impl.MachineAuditService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.subethamail.wiser.Wiser;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApp.class)
public class CoreFlowTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    private Wiser wiser;

    @Before
    public void setup() {
        wiser = new Wiser();
        wiser.setPort(1025);
        wiser.start();
    }

    @After
    public void cleanup() {
        wiser.stop();
    }

    @Test
    public void testHappyPath() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("core_flow");
        boolean result = false;
        ServiceTask serviceTask = new EnterItemService();
        result = serviceTask.execute(processInstance, taskService);
        Assert.assertEquals(true, result);

        serviceTask = new MachineAuditService();
        result = serviceTask.execute(processInstance, taskService);

        Assert.assertEquals(true, result);


        serviceTask = new LoanService();
        result = serviceTask.execute(processInstance, taskService);
        Assert.assertEquals(true, result);

        serviceTask = new CreditAuditService();
        result = serviceTask.execute(processInstance, taskService);
        Assert.assertEquals(true, result);


    }

}
