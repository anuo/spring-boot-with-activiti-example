package org.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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


        Task task1 = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        System.out.println("执行步骤: " + task1.getName());
        taskService.complete(task1.getId());


        Task task2 = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        System.out.println("执行步骤: " + task2.getName());
        taskService.complete(task2.getId());


        Task task3 = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        System.out.println("执行步骤: " + task3.getName());
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("RepaymentOutcome", false);
        taskService.complete(task3.getId(), taskVariables);


        Task task4 = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        System.out.println("执行步骤: " + task4.getName());
        taskService.complete(task4.getId());


    }

}
