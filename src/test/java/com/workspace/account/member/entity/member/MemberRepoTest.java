package com.workspace.account.member.entity.member;

import com.workspace.account.api.department.Department;
import com.workspace.account.api.department.DepartmentRepo;
import com.workspace.account.api.members.Member;
import com.workspace.account.api.members.MemberRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class MemberRepoTest {
    private static final Logger log = LoggerFactory.getLogger(MemberRepoTest.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    void memberCreateTest() throws JsonProcessingException {

        Member member = Member.builder()
                .name("오승현")
                .build();

        Member save = memberRepo.save(member);

        Assert.hasText(member.getName(), save.getName());
        Assert.isTrue(save.getId() != 0, "...");

        log.debug("member.id={}", save.getId());

        Member byId = memberRepo.findById(save.getId()).orElse(null);

        Assert.notNull(byId, "");
        log.debug(objectMapper.writeValueAsString(byId));
    }

    @Test
    void memberDeptCreateTest(){
        Member member = Member.builder()
                .name("오승현")
                .build();

        member = memberRepo.save(member);

        Department department = Department.builder()
                .name("부서1")
                .build();

        department.addMember(member);

        departmentRepo.save(department);

    }
}