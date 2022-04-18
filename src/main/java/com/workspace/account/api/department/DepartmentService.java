package com.workspace.account.api.department;

import com.workspace.account.api.department.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<DepartmentDto> findAll() {
        return departmentRepo.findAll()
                .stream()
                .map(DepartmentDto::with)
                .collect(Collectors.toList());
    }

}
