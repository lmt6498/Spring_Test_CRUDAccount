package controllers;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.IAccountService;

import java.sql.Timestamp;

@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("account")
    public ModelAndView home(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "3") int sizePage) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("accountList", accountService.findAll(PageRequest.of(pageNumber,sizePage)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("account",new Account());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute Account account){
        Timestamp dateTime = new Timestamp(System.currentTimeMillis());
        account.setCreateDate(dateTime);
        accountService.save(account);
        return new ModelAndView("redirect:/account");
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("accountList", accountService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        Account account = accountService.findByID(id);
        if(account != null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("account",account);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }
    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Account account){
        accountService.save(account);
        return new ModelAndView("redirect:/account");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        accountService.remove(accountService.findByID(id));
        return new ModelAndView("redirect:/account");
    }
}
