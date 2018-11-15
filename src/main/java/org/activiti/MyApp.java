package org.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                runtimeService.startProcessInstanceByKey("core_flow");
            }
        };

    }


//    @Bean
//    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//        return new InitializingBean() {
//            public void afterPropertiesSet() throws Exception {
//
//                Group group = identityService.newGroup("user");
//                group.setName("users");
//                group.setType("security-role");
//                identityService.saveGroup(group);
//
//                User admin = identityService.newUser("admin");
//                admin.setPassword("admin");
//                identityService.saveUser(admin);
//
//            }
//        };
//    }

}
