package com.generic.admin_scaffolding.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 17:17
 */
@Data
public class RoleResourceDTO {

    private Long roleId;

    private List<Long> resourceIds;
}
