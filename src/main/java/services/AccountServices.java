package services;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import repository.IAccountRepo;

import java.util.List;

@Transactional
public class AccountServices implements IAccountService{
    @Autowired
    private IAccountRepo accountRepo;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepo.findAll();
    }

    @Override
    public List<Account> findAllByName(String username) {
        return accountRepo.findAllByName(username);
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }

    @Override
    public Account findByID(Integer id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void remove(Account account) {
        accountRepo.delete(account);
    }
}
