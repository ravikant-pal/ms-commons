package com.triton.mscommons.filter;


import com.triton.mscommons.annotaion.HasAnyPermission;
import com.triton.mscommons.annotaion.HasAnyRole;
import com.triton.mscommons.exceptions.UnauthorizedAccessException;
import com.triton.mscommons.model.BaseUser;
import com.triton.mscommons.model.Permission;
import com.triton.mscommons.model.Role;
import com.triton.mscommons.utils.CommonUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
public class AuthorizationAspect {

    @Before("@annotation(hasAnyRole)")
    public void checkRole(JoinPoint joinPoint, HasAnyRole hasAnyRole) {
        String[] roles;
        roles = hasAnyRole.value();
        if (ArrayUtils.isEmpty(roles)) roles = hasAnyRole.roles();
        if (!userHasAnyRole(getCurrentUserRoles(), roles)) {
            throw UnauthorizedAccessException.build();
        }
    }
    @Before("@annotation(hasAnyPermission)")
    public void checkPermission(JoinPoint joinPoint, HasAnyPermission hasAnyPermission) {
        String[] roles;
        roles = hasAnyPermission.value();
        if (ArrayUtils.isEmpty(roles)) roles = hasAnyPermission.permissions();
        if (!userHasAnyPermission(getCurrentUserRoles(), roles)) {
            throw UnauthorizedAccessException.build();
        }
    }

    /**
     * <p> Info : Implement similar logic for other custom annotations </p>
     *
     *
     *<p> Note : Put all the private methods bottom of the file </p>
     **/
    private boolean userHasAnyRole(Set<Role> userRoles, String[] requiredRoles) {
        Set<String> userRoleNames = userRoles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        return Arrays.stream(requiredRoles)
                .anyMatch(userRoleNames::contains);
    }
    private boolean userHasAnyPermission(Set<Role> userRoles, String[] requiredPermissions) {
        Set<String> userPermissionNames = userRoles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getName)
                .collect(Collectors.toSet());
        return Arrays.stream(requiredPermissions)
                .anyMatch(userPermissionNames::contains);
    }

    private Set<Role> getCurrentUserRoles() {
        BaseUser loggedInUser = CommonUtils.getLoggedInUser();
        if (Objects.isNull(loggedInUser)) {
            return Collections.emptySet();
        } else {
            return loggedInUser.getRoles();
        }
    }
}

