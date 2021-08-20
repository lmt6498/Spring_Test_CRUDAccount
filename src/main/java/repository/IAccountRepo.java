package repository;

import models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends PagingAndSortingRepository<Account,Integer> {
    @Query(value = "select c from Account c where c.username like concat('%',:username,'%')")
    List<Account> findAllByName(@Param("username") String username);
}
