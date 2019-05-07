/**
 * 
 */
package se.iuh.nhom21.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import se.iuh.nhom21.Model.Product;

/**
 * @author LamNguyen
 *
 */
@Repository
public class ProductDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Product product) {
		String sql = "insert into SanPham(sTensp,dDongia,sAnhsp,sMota,spMaLoai,trangthai) " 
				+ " values( N'" + product.getTensp() + "'," + product.getDongia()+ ",N'" 
				+ product.getAnhsp() + "', N'"+ product.getMota()+ "',"
				+ product.getMaloai()+", N'" + product.getTrangthai() + "')";
		System.out.println(product.toString());
		return template.update(sql);
	}

	public int update(Product product) {
		String sql ="update SanPham set sTensp= N'"
				+ product.getTensp()+"',dDongia="+product.getDongia()+",sAnhsp=N'"
				+product.getAnhsp()+"',sMota=N'"+product.getMota()+"',spMaLoai="
				+product.getMaloai()+",trangthai=N'"+product.getTrangthai()
				+"' where masp = "+ product.getMasp();
		System.out.println(product.toString());
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from SanPham where masp = " + id + " ";
		return template.update(sql);
	}

	public Product getProductById(int id) {
		String sql = "select * from SanPham where masp = "+id+" ";
		List<Product> listproduct = template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row ) throws SQLException{
				Product product = new Product();
				product.setMasp(rs.getInt(1));
				product.setTensp(rs.getString(2));
				product.setDongia(rs.getFloat(3));
				product.setAnhsp(rs.getString(4));
				product.setMota(rs.getString(5));
				product.setMaloai(rs.getInt(6));
				product.setTrangthai(rs.getString(7));
				return product;
			}

		});
		Product productResult = listproduct.get(0);
		return productResult;
	}

	public List<Product> getProducts() {
		return template.query("select * from SanPham", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product product = new Product();
				product.setMasp(rs.getInt(1));
				product.setTensp(rs.getString(2));
				product.setDongia(rs.getFloat(3));
				product.setAnhsp(rs.getString(4));
				product.setMota(rs.getString(5));
				product.setMaloai(rs.getInt(6));
				product.setTrangthai(rs.getString(7));
				return product;
			}

		});
	}

	public List<Product> getProductsbyMaloai(int maloai) {
		return template.query("select * from SanPham where spMaLoai = " + maloai, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product product = new Product();
				product.setMasp(rs.getInt(1));
				product.setTensp(rs.getString(2));
				product.setDongia(rs.getFloat(3));
				product.setAnhsp(rs.getString(4));
				product.setMota(rs.getString(5));
				product.setMaloai(rs.getInt(6));
				product.setTrangthai(rs.getString(7));

				return product;
			}

		});
	}

	
}
