package com.workspace.account.api.department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long>, DepartmentCustomRepo {
}
