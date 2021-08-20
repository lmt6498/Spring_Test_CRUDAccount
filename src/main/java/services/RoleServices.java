package services;

import models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repository.IRoleRepo;

import java.util.List;

@Transactional
public class RoleServices implements IRoleService{
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepo.findAll();
    }

    @Override
    public Role findByID(Integer id) {
        return roleRepo.findById(id).get();
    }
}
