/**
 * 
 */
package se.iuh.nhom21.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView viewuser(HttpSession session) {
		int quyen = (Integer) session.getAttribute("quyen");
		if( quyen != 2) {
			return new ModelAndView("home");
		}
		List<User> list = userDAO.getUsers();
		return new ModelAndView("user","list",list);
	}
	
	@RequestMapping("/user/{sdt}")
	public ModelAndView showuser(@PathVariable String sdt,HttpSession session) {

		User user = userDAO.getTypeBySdt(sdt);
		if(session.getAttribute("sdt")!=null) {
			String sessionsdt = session.getAttribute("sdt").toString().trim();
			if (sdt.equals(sessionsdt)) {
				return new ModelAndView("edituser","command",user);
			}
		}
		return new ModelAndView("userdetail","command",user);
	}
	
	// xu ly cap nhat tai khoan
	@RequestMapping(value = "/editsaveuser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") User user, HttpSession session,
			HttpServletRequest request) {
		userDAO.update(user);
		
		return new ModelAndView("redirect:/user/"+session.getAttribute("sdt").toString().trim());
	}

}
