/**
 * 
 */
package se.iuh.nhom21.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.nhom21.Dao.TypeDao;
import se.iuh.nhom21.Model.Type;


/**
 * @author LamNguyen
 *
 */
@Controller
public class TypeController {
	@Autowired
	TypeDao typeDao;
	
	// giao dien them loai moi
	@RequestMapping("/addtype")
	public ModelAndView showform() {
		return new ModelAndView("newtype","command",new Type());
	}
	
	//luu loai moi
	@RequestMapping(value="/savetype", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("type") Type type) {
		typeDao.save(type);
		return new ModelAndView("redirect:/types");
	}
	
	// danh sach loai san pham
	@RequestMapping("/types")
	public ModelAndView viewType(HttpSession session) {
		int quyen = (Integer) session.getAttribute("quyen");
		if( quyen != 2) {
			return new ModelAndView("home");
		}
		List<Type> list = typeDao.getTypes();
		return new ModelAndView("type","list",list);
	}
	

	//hien thi chi tiet loai
	@RequestMapping(value="/edittype/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Type type = typeDao.getTypeById(id);
		System.out.println(type.toString());
		return new ModelAndView("edittype","command",type);
	}
	
	
	//luu loai sau khi chinh sua
	@RequestMapping(value="/editsavetype", method = RequestMethod.POST)
	public ModelAndView editsavetype(@ModelAttribute("type") Type type) {
		System.out.println(typeDao.update(type));
		return new ModelAndView("redirect:/types");
	}
	
	
	@RequestMapping("/deletetype/{id}")
	public ModelAndView delete(@PathVariable int id) {
		typeDao.delete(id);
		return new ModelAndView("redirect:/types");
	}

}
