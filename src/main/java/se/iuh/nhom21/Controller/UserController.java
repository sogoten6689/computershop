/**
 * 
 */
package se.iuh.nhom21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.nhom21.Dao.UserDao;
import se.iuh.nhom21.Model.User;


/**
 * @author LamNguyen
 *
 */
@Controller
public class UserController {
	@Autowired
	UserDao userDAO;
	
	@RequestMapping("/users")
	public ModelAndView viewuser() {
		List<User> list = userDAO.getUsers();
		return new ModelAndView("user","list",list);
	}
	
	@RequestMapping("/user/{sdt}")
	public ModelAndView showuser(@PathVariable String sdt) {
		User user = userDAO.getTypeBySdt(sdt);
		return new ModelAndView("userdetail","command",user);
	}
	

}
