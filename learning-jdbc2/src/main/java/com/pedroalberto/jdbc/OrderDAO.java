package com.pedroalberto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.pedroalberto.jdbc.util.DataAccessObject;

public class OrderDAO extends DataAccessObject<Order>{

	// uma vez que a query é um join de tabelas, tivemos de dar nome às colunas (usar o "as"), para podermos usar um nome no ResultSet
	private static final String LISTA = "SELECT c.first_name as cfname, c.last_name as clname, c.email as cemail, o.order_id, " +
			"o.creation_date, o.total_due, o.status, s.first_name as sfname, " +
	        "s.last_name as slname, s.email as semail, ol.quantity, p.code, p.name, p.size, p.variety, p.price " +
			"FROM orders o JOIN customer c ON o.customer_id = c.customer_id JOIN salesperson s ON o.salesperson_id = s.salesperson_id JOIN order_item ol ON o.order_id = ol.order_id JOIN product p ON ol.product_id = p.product_id " +
	        "WHERE o.order_id = ?";
	
	
	// get_orders_by_customer é uma função SQL, definida por mim, que faz join entre varias tabelas e devolve uma lista das orders de 
	// um costumer
	private static final String GET_FOR_CUST = "SELECT * FROM get_orders_by_customer(?)";
	
	
	// CONSTRUTOR DA CLASSE
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
	
	public List<Order> getOrdersForCostumer(long id){
		// metodo que obtem uma lista das orders de um cliente
		
		List<Order> customerOrders = new ArrayList<>();	
		List<OrderLine> orderLines = null;
		Order order = null;
		OrderLine orderLine = null;
		
		
		long orderIdLidaAntes = 0, orderIdLidaAgora = 0;
		// long orderIdLidaAntes, orderIdLidaAgora;           tambem podia ser assim
		// orderIdLidaAntes = orderIdLidaAgora = 0;
		boolean primeiraOrder = true;
		
		try (PreparedStatement statement = this.connection.prepareStatement(GET_FOR_CUST)) {
			
			statement.setLong(1, id);   
			
			ResultSet rs = statement.executeQuery();
						
			while (rs.next()) {
				
				orderIdLidaAgora = rs.getLong(4);      // obtem o order id
				
				if (orderIdLidaAntes != orderIdLidaAgora) {
					// cria novo objecto Order
					
					if (primeiraOrder) {
						primeiraOrder = false;											
					}
					else {
						// acabámos de ler os varios itens de uma Order, há que adicionar a lista de itens à Order e, por sua vez
						// adicionar a Order à lista de Orders do cliente
						order.setOrderLines(orderLines);
						customerOrders.add(order);						
					}
						
						
					orderIdLidaAntes = orderIdLidaAgora;
					
					order = new Order();              // nova Order
					orderLines = new ArrayList<>();   // nova lista de itens de Order
					
					// cria os dados da cabeceira
					order.setCustomerFirstName(rs.getString(1));
					order.setCustomerLastName(rs.getString(2));
					order.setCustomerEmail(rs.getString(3));
					order.setOrderId(rs.getLong(4));
					order.setCreationDate(rs.getDate(5));
					order.setTotalDue(rs.getBigDecimal(6));
					order.setStatus(rs.getString(7));
					order.setSalespersonFirstName(rs.getString(8));
					order.setSalespersonLastName(rs.getString(9));
					order.setSalespersonEmail(rs.getString(10));										
				}
				
				// cria o detalhe, composto pelas Order Lines que fazem parte da Order
				orderLine = new OrderLine();
				orderLine.setProductQuantity(rs.getLong(11));
				orderLine.setProductCode(rs.getString(12));
				orderLine.setProductName(rs.getString(13));
				orderLine.setProductSize(rs.getLong(14));
				orderLine.setProductVariety(rs.getString(15));
				orderLine.setProductPrice(rs.getBigDecimal(16));
				orderLines.add(orderLine);			
			}
			// acabámos de ler os varios itens de uma Order, há que adicionar a lista de itens à Order e, por sua vez
			// adicionar a Order à lista de Orders do cliente
			order.setOrderLines(orderLines);
			customerOrders.add(order);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);			
		}
		
		return customerOrders;
	}

}
