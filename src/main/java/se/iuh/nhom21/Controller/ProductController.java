/**
 * 
 */
package se.iuh.nhom21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.nhom21.Dao.ProductDao;
import se.iuh.nhom21.Dao.TypeDao;
import se.iuh.nhom21.Model.Product;
import se.iuh.nhom21.Model.Type;


/**
 * @author LamNguyen
 *
 */
@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	TypeDao typeDao;
	
	// giao dien them loai moi
	@RequestMapping("/addproduct")
	public ModelAndView showform() {
		List<Type> listtype = typeDao.getTypes();
		ModelAndView modelAndView = new ModelAndView("newproduct");
		modelAndView.addObject("listtype", listtype);
		modelAndView.addObject("command", new Product());
		return modelAndView;
	}
	
	//luu loai moi
	@RequestMapping(value="/saveproduct", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") Product product) {
		productDao.save(product);
		return new ModelAndView("redirect:/products");
	}
	
	// danh sach loai san pham
	@RequestMapping("/products")
	public ModelAndView viewProduct() {
		List<Product> list = productDao.getProducts();
		List<Type> listtype = typeDao.getTypes();
		ModelAndView modelAndView = new ModelAndView("product");
		modelAndView.addObject("listtype", listtype);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	

	//hien thi chi tiet loai
	@RequestMapping(value="/editproduct/{id}")
	public ModelAndView edit(@PathVariable int id) {
		List<Type> listtype = typeDao.getTypes();
		Product product = productDao.getProductById(id);
		ModelAndView modelAndView = new ModelAndView("editproduct");
		modelAndView.addObject("listtype", listtype);
		modelAndView.addObject("command", product);
		System.out.println(product.toString());
		return modelAndView;
	}
	
	
	//luu loai sau khi chinh sua
	@RequestMapping(value="/editsaveproduct", method = RequestMethod.POST)
	public ModelAndView editsaveproduct(@ModelAttribute("product") Product product) {
		System.out.println(productDao.update(product));
		return new ModelAndView("redirect:/products");
	}
	
	// xoa san pham
	@RequestMapping("/deleteproduct/{id}")
	public ModelAndView delete(@PathVariable int id) {
		productDao.delete(id);
		return new ModelAndView("redirect:/products");
	}

}
