package com.generic.admin_scaffolding.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 11:15
 */

@Data
public class UserRoleDTO {

    private Long userId;

    private List<Long> roleIds;

}
