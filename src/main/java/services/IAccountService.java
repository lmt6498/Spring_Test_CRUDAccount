package services;

import models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    List<Account> findAllByName(String username);
    Page<Account> findAll(Pageable pageable);

    Account findByID(Integer id);

    void save(Account account);

    void remove(Account account);
}
