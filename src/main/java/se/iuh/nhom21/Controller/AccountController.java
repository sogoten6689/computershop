/**
 * 
 */
package se.iuh.nhom21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.nhom21.Dao.AccountDao;
import se.iuh.nhom21.Model.Account;


/**
 * @author LamNguyen
 *
 */
@Controller
public class AccountController {
	@Autowired
	AccountDao AccountDAO;
	
	@RequestMapping("/accounts")
	public ModelAndView viewAccount() {
		List<Account> list = AccountDAO.getAccounts();
		return new ModelAndView("account","list",list);
	}
	

}
