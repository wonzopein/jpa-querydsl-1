package com.workspace.account.api.members.dto;

import com.workspace.account.api.department.Department;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepartmentDto {
    private Long id;
    private String name;

    private DepartmentDto parentDepartment;

    @Builder
    public DepartmentDto(Long id, String name, DepartmentDto parentDepartment) {
        this.id = id;
        this.name = name;
        this.parentDepartment = parentDepartment;
    }

    public static DepartmentDto with(Department department) {
        if(department== null)
            return null;

        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .parentDepartment(department.getParentDepartment() == null? null : DepartmentDto.with(department.getParentDepartment()))
                .build();
    }
}
