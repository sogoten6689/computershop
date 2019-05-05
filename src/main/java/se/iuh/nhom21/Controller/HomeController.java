package se.iuh.nhom21.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.nhom21.Dao.AccountDao;
import se.iuh.nhom21.Dao.HomeDao;
import se.iuh.nhom21.Dao.TypeDao;
import se.iuh.nhom21.Dao.UserDao;
import se.iuh.nhom21.Model.Account;
import se.iuh.nhom21.Model.Type;
import se.iuh.nhom21.Model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	HomeDao homeDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AccountDao accountDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	// error
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("error");
	}

	// giao dien login
	@RequestMapping("/login")
	public ModelAndView showformlogin( HttpSession session) {
		if(session.getAttribute("sdt")!=null)
		{
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("login", "command", new Account());
	}

	// giao dien dang ki
	@RequestMapping("/register")
	public ModelAndView showformregister(HttpSession session) {
		if(session.getAttribute("sdt")!=null)
		{
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("register", "command", new Account());
	}

	// xu ly dang ki
	@RequestMapping(value = "/registerpost", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute("account") Account account, HttpSession session,
			HttpServletRequest request) {
		int ketqua=-5;
		ketqua = userDao.saveAddAcc(account.getSdt());
		if (ketqua==-5) 
			return new ModelAndView("redirect:/error");
		ketqua =-6;
		ketqua = accountDao.save(account);
		if(ketqua==-6)
			return new ModelAndView("redirect:/error");
		session.setAttribute("sdt", account.getSdt());
		session.setAttribute("quyen", account.getQuyen());
		session.setAttribute("msg", "Đăng nhập thành công!");
		User user = userDao.getTypeBySdt(account.getSdt());
		String url = "redirect:/user/"+account.getSdt();
		ModelAndView modelAndView =  new ModelAndView(url,"command",user);
		return modelAndView;
	}

	// xu ly dang nhap
	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("account") Account account, HttpSession session,
			HttpServletRequest request) {
		Account accountResult = homeDao.login(account.getSdt(), account.getMatkhau());

		if (accountResult != null) {
			session.setAttribute("sdt", accountResult.getSdt());
			session.setAttribute("quyen", accountResult.getQuyen());
			session.setAttribute("msg", "Đăng nhập thành công!");
			return new ModelAndView("redirect:/accounts");
		} else {
			session.setAttribute("msg", "Tài khoản của bạn không đúng, Vui lòng kiểm tra lại!");
			return new ModelAndView("redirect:/login");
		}
	}
	// xu ly logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/login";
	}
}
