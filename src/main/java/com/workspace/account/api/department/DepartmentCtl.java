package com.workspace.account.api.department;

import com.workspace.account.api.department.dto.DepartmentDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Department", description = "부서 API")
@RequestMapping("/api/department")
@RestController
public class DepartmentCtl {

    private final DepartmentService departmentService;

    public DepartmentCtl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public ResponseEntity<List<DepartmentDto>> allDepartments(){
        return ResponseEntity.ok(departmentService.findAll());
    }

}
