
package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Role;
import com.spring.employeemgmt.repository.RoleRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRoles() {
        Role role1 = new Role(1L, "Admin");
        Role role2 = new Role(2L, "Manager");
        List<Role> roleList = Arrays.asList(role1, role2);

        when(roleRepository.findAll()).thenReturn(roleList);

        List<Role> result = roleService.getAllRoles();

        assertEquals(2, result.size());
        assertEquals("Admin", result.get(0).getName());
    }

    @Test
    void testGetRoleById() {
        Role role = new Role(1L, "Employee");

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        Optional<Role> result = roleService.getRoleById(1L);

        assertTrue(result.isPresent());
        assertEquals("Employee", result.get().getName());
    }

    @Test
    void testCreateRole() {
        Role role = new Role(null, "HR");
        Role savedRole = new Role(3L, "HR");

        when(roleRepository.save(role)).thenReturn(savedRole);

        Role result = roleService.createRole(role);

        assertNotNull(result.getId());
        assertEquals("HR", result.getName());
    }
}
