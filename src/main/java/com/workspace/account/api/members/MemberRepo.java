package com.workspace.account.api.members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member,Long>, MemberCustomRepo {
}
