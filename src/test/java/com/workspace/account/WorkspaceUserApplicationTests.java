package com.workspace.account;

import com.workspace.account.api.members.MemberRepo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkspaceUserApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(WorkspaceUserApplicationTests.class);

    @Autowired
    private MemberRepo memberRepo;

    @Test
    void contextLoads() {
    }

}
