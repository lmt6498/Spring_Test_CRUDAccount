package services;

import models.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findByID(Integer id);
}
