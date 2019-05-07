package se.iuh.nhom21.Controller;

import java.util.ArrayList;
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

import se.iuh.nhom21.Dao.AccountDao;
import se.iuh.nhom21.Dao.HomeDao;
import se.iuh.nhom21.Dao.OrderDao;
import se.iuh.nhom21.Dao.ProductDao;
import se.iuh.nhom21.Dao.TypeDao;
import se.iuh.nhom21.Dao.UserDao;
import se.iuh.nhom21.Model.Account;
import se.iuh.nhom21.Model.Cart;
import se.iuh.nhom21.Model.Order;
import se.iuh.nhom21.Model.OrderDetail;
import se.iuh.nhom21.Model.Product;
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

	@Autowired
	TypeDao typeDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	OrderDao orderDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		List<Type> listtype = typeDao.getTypes();
		session.setAttribute("listtype", listtype);
		return new ModelAndView("home");
	}

	// view thanh toan
	@RequestMapping(value = "/charge", method = RequestMethod.GET)
	public ModelAndView charge(HttpSession session) {
		String sdt = (String) session.getAttribute("sdt");
		if(sdt == null) {
			ModelAndView login = new ModelAndView("login", "command", new Account());
			login.addObject("msg","Đăng nhập để xác nhận đơn hàng");
			return login;
		}
		return new ModelAndView("newcharge", "command", new Order());
	}
	//

	// view thanh toan
	@RequestMapping(value = "/savecharge", method = RequestMethod.POST)
	public ModelAndView savecharge(@ModelAttribute("order") Order order, HttpSession session) {

		String sSDT = (String) session.getAttribute("sdt");
		if(order == null || order.getsSDT()==null) {
			order.setsSDT(sSDT.trim());
		}
		orderDao.save(order);
		int mahd = orderDao.findDonhangById(sSDT);
		@SuppressWarnings("unchecked")
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		// Vòng lặp đọc từng element trong cart và gán giá trị vào object
		for (Cart cart : listcart) {

			int masp = cart.getMasp();
			int soluong = cart.getSoluong();
			float dongia = cart.getdDongia();

			OrderDetail ct = new OrderDetail(masp, mahd, soluong, dongia);
			orderDao.saveDetail(ct);
		}
		session.removeAttribute("listcart");
		session.removeAttribute("totalmoney");
		session.removeAttribute("countcart");
		return new ModelAndView("thanks", "command", new Order());
	}

	// Xoa sp khoi gio hang
	@RequestMapping(value = "/removecart/{masp}")
	public ModelAndView removeCart(@PathVariable int masp, HttpSession session) {
		ModelAndView mav = new ModelAndView("cart");
		@SuppressWarnings("unchecked")
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		// Tao viewname Cart -> tao s-name Cart -> read Listcart
		if (listcart != null) {
			float totalmoney = totalMoney(listcart, masp);
			int countcart = countCart(listcart);
			session.setAttribute("countcart", countcart);
			session.setAttribute("totalmoney", totalmoney);
			session.setAttribute("listcart", listcart);
		}
		if (listcart.size() == 0) {
			return new ModelAndView("products");
		}
		return mav;
	}

	// Xoa 1 sp khoi gio hang
	@RequestMapping(value = "/removeonecart/{masp}")
	public ModelAndView removeoneCart(@PathVariable int masp, HttpSession session) {
		ModelAndView mav = new ModelAndView("cart");
		@SuppressWarnings("unchecked")
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		// Tao viewname Cart -> tao s-name Cart -> read Listcart
		if (listcart != null) {
			float totalmoney = totaloneMoney(listcart, masp);
			int countcart = countCart(listcart);
			session.setAttribute("countcart", countcart);
			session.setAttribute("totalmoney", totalmoney);
			session.setAttribute("listcart", listcart);
		}
		if (listcart.size() == 0) {
			return new ModelAndView("products");
		}
		return mav;
	}
	
	// Xoa 1 sp khoi gio hang
	@RequestMapping(value = "/oldmyorder/{sSDT}")
	public ModelAndView oldmyorder(@PathVariable String sSDT, HttpSession session) {
		List<OrderDetail> listmyorder = orderDao.getAllChitietByMadonhang(sSDT);
		ModelAndView order = new ModelAndView("oldmyorder");
		session.setAttribute("listmyorder", listmyorder);
		return order;
	}
	
	// Xoa 1 sp khoi gio hang
		@RequestMapping(value = "/ordercheck/{imadonhang}")
		public ModelAndView ordercheck(@PathVariable int imadonhang, HttpSession session) {
			List<OrderDetail> ordercheck = orderDao.getAllChitietByMadonhangne(imadonhang);
			
			ModelAndView order = new ModelAndView("ordercheck");
			session.setAttribute("ordercheck", ordercheck);
			return order;
		}


	@RequestMapping(value = "/cancelcart")
	public ModelAndView cancellPurchase(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/products");
		session.removeAttribute("listcart");
		session.removeAttribute("totalmoney");
		session.removeAttribute("countcart");
		return mav;
	}

	// error
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("error");
	}

	// error
	@RequestMapping(value = "/addcart/{masp}", method = RequestMethod.GET)
	public ModelAndView addproducttocart(@PathVariable int masp, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		int countcart = 1;
		float totalmoney = 0;
		if (listcart != null) {
			// neu co san pham
			for (Cart cart : listcart) {
				if (cart.getMasp() == masp) {

					countcart = (Integer) session.getAttribute("countcart");
					totalmoney = (Float) session.getAttribute("totalmoney");
					cart.setSoluong(cart.getSoluong() + 1);
					countcart++;
					totalmoney += cart.getdDongia();
					session.setAttribute("totalmoney", totalmoney);
					session.setAttribute("listcart", listcart);
					session.setAttribute("countcart", countcart);
					return new ModelAndView("redirect:/products");
				}
			}
		} else {
			listcart = new ArrayList<Cart>();
		}
		Product product = productDao.getProductById(masp);
		Cart cart = new Cart(product);
		listcart.add(cart);
		countcart = countCart(listcart);
		totalmoney = totalMoney(listcart);
		session.setAttribute("totalmoney", totalmoney);
		session.setAttribute("countcart", countcart);
		session.setAttribute("listcart", listcart);
		return new ModelAndView("redirect:/products");
	}

	// giao dien login
	@RequestMapping("/login")
	public ModelAndView showformlogin(HttpSession session) {

		if (session.getAttribute("sdt") != null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("login", "command", new Account());
	}

	// giao dien dang ki
	@RequestMapping("/register")
	public ModelAndView showformregister(HttpSession session) {
		if (session.getAttribute("sdt") != null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("register", "command", new Account());
	}

	// xu ly dang ki
	@RequestMapping(value = "/registerpost", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute("account") Account account, HttpSession session,
			HttpServletRequest request) {
		int ketqua = -5;
		ketqua = userDao.saveAddAcc(account.getSdt());
		if (ketqua == -5)
			return new ModelAndView("redirect:/error");
		ketqua = -6;
		ketqua = accountDao.save(account);
		if (ketqua == -6 || ketqua ==-10)
			return new ModelAndView("redirect:/error");
		session.setAttribute("sdt", account.getSdt());
		session.setAttribute("quyen", account.getQuyen());
		User user = userDao.getTypeBySdt(account.getSdt());
		String url = "redirect:/user/" + account.getSdt();
		ModelAndView modelAndView = new ModelAndView(url, "command", user);
		return modelAndView;
	}

	// xu ly dang nhap
	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("account") Account account, HttpSession session,
			HttpServletRequest request) {
		Account accountResult = homeDao.login(account.getSdt(), account.getMatkhau());
		
		if (accountResult != null) {
			User user = userDao.getTypeBySdt(accountResult.getSdt().trim());
			session.setAttribute("sdt", accountResult.getSdt());
			session.setAttribute("quyen", accountResult.getQuyen());
			session.setAttribute("ten", user.getTen());
			session.setAttribute("user", user);
//			return new ModelAndView("logout","msg","Đăng xuất thành công!");
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	// xu ly logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	// xu ly logout
	@RequestMapping(value = "/carts", method = RequestMethod.GET)
	public ModelAndView showcarts(HttpServletRequest request, HttpSession session) {
		ModelAndView viewcarts = new ModelAndView("cart");
		return viewcarts;
	}
	
	// quan ly
		@RequestMapping(value = "/orders", method = RequestMethod.GET)
		public ModelAndView showorder(HttpServletRequest request, HttpSession session) {
			ModelAndView viewcarts = new ModelAndView("cart");
			int quyen = (Integer) session.getAttribute("quyen");
			if( quyen != 2) {
				return new ModelAndView("home");
			}
			List<Order> orders  = orderDao.getAllDonhang();
//			List<OrderDetail> listmyorder = orderDao.getAllChitietByMadonhang();
			ModelAndView order = new ModelAndView("quanlydonhang");
			session.setAttribute("orders", orders);
			return order;
		}

	public static int countCart(List<Cart> listcart) {
		int count = 0;
		for (Cart cart : listcart) {
			count += cart.getSoluong();
		}
		return count;
	}

	public static float totalMoney(List<Cart> listcart) {
		float total = 0;
		for (Cart cart : listcart) {
			total += cart.getSoluong() * cart.getdDongia();
		}
		return total;
	}

	public static float totalMoney(List<Cart> list, int masp) {
		Cart temp = null;
		float total = 0;
		for (Cart c : list) {
			if (c.getMasp() == (masp)) {
				temp = c;
				continue;
			}
			total += c.getSoluong() * c.getdDongia();
		}
		if (temp != null)
			list.remove(temp);
		return total;
	}

	public static float totaloneMoney(List<Cart> list, int masp) {
		Cart temp = null;
		float total = 0;
		for (Cart c : list) {
			if (c.getMasp() == (masp)) {
				if (c.getSoluong() == 1)
					temp = c;
				else {
					c.setSoluong(c.getSoluong() - 1);
					total += c.getSoluong() * c.getdDongia();
				}
				continue;
			}
			total += c.getSoluong() * c.getdDongia();
		}
		if (temp != null)
			list.remove(temp);
		return total;
	}

}
