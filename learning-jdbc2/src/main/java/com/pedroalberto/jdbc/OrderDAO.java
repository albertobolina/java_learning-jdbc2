package com.pedroalberto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.pedroalberto.jdbc.util.DataAccessObject;

public class OrderDAO extends DataAccessObject<Order>{

	
	private static final String LISTA = "SELECT c.first_name as cfname, c.last_name as clname, c.email as cemail, o.order_id, " +
			"o.creation_date, o.total_due, o.status, s.first_name as sfname, " +
	        "s.last_name as slname, s.email as semail, ol.quantity, p.code, p.name, p.size, p.variety, p.price " +
			"FROM orders o JOIN customer c ON o.customer_id = c.customer_id JOIN salesperson s ON o.salesperson_id = s.salesperson_id JOIN order_item ol ON o.order_id = ol.order_id JOIN product p ON ol.product_id = p.product_id " +
	        "WHERE o.order_id = ?";
	
	public OrderDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Order findById(long id) {
		
		Order order = new Order();
		OrderLine orderLine;
		List<OrderLine> orderLines = new ArrayList<>();
		
		try(PreparedStatement statement = this.connection.prepareStatement(LISTA)){
			
			statement.setLong(1, id);
			
			ResultSet rs = statement.executeQuery();                   // o ResultSet é uma especie de array, onde as linhas são os registros devolvidos
				 
			
			// da tabela e as colunas são os campos 	
			while(rs.next()) {
				
				if (rs.isFirst()) {
					order.setOrderId(rs.getLong("order_id"));
					order.setCustomerFirstName(rs.getString("cfname"));
					order.setCustomerLastName(rs.getString("clname"));
					order.setCustomerEmail(rs.getString("cemail"));
					order.setOrderId(rs.getLong("order_id"));
					order.setCreationDate(rs.getDate("creation_date"));
					order.setTotalDue(rs.getBigDecimal("total_due"));
					order.setStatus(rs.getString("status"));
					order.setSalespersonFirstName(rs.getString("sfname"));
					order.setSalespersonLastName(rs.getString("slname"));
					order.setSalespersonEmail(rs.getString("semail"));
				}
				orderLine = new OrderLine();
				orderLine.setProductQuantity(rs.getLong("quantity"));
				orderLine.setProductCode(rs.getString("code"));
				orderLine.setProductName(rs.getString("name"));
				orderLine.setProductSize(rs.getLong("size"));
				orderLine.setProductVariety(rs.getString("variety"));
				orderLine.setProductPrice(rs.getBigDecimal("price"));
				
				orderLines.add(orderLine);																
			}
			order.setOrderLines(orderLines);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return order;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
