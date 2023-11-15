package com.pedroalberto.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCExecutor {

	public static void main(String[] args) {
		
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");
		
		try {
			Connection connection = dcm.getConnection();
			
			// executar uma querie simples - ini 
			/* 
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select count(*) from customer");
			
			while(resultset.next()) {
				System.out.println(resultset.getInt(1));
			}
			*/
			// executar uma querie simples - fim
			
			
			// executar um INSERT usando um PreparedStatement - ini
			/*
			Customer customer = new Customer();
			customer.setFirstName("Pedro Miguel");
			customer.setLastName("Oliveira dos Santos Alberto");
			customer.setAddress("Rua João Paulo II");
			customer.setCity("Azambuja");
			customer.setState("Lisboa");
			customer.setZipCode("2050-275");
			customer.setEmail("albertobolina@gmail.com");
			customer.setPhone("933184301");
			
			CustomerDAO customerDAO = new CustomerDAO(connection);
			customerDAO.create(customer);
			*/
			
			// executar um INSERT usando um PreparedStatement - fim
			
			
			
			// SELECT à tabela Customer, usando a chave unica id - ini
			/*
			Customer customer = new Customer();
			CustomerDAO dao = new CustomerDAO(connection);
			customer = dao.findById(1000);
			
			System.out.println("cliente obtido = " + customer.getFirstName() + " " + customer.getLastName());
			*/
			// SELECT à tabela Customer, usando a chave unica id - fin
			
			
			
			// UPDATE na tabela customer - ini
			/*
			CustomerDAO dao = new CustomerDAO(connection);
			
			Customer customer = dao.findById(220);
			
			System.out.println(customer.toString());
			
			customer.setEmail("PEDRO.joaquim@treta.com");
			
			Customer customer2 = dao.update(customer);
			System.out.println(customer2.toString());
			*/			
			// UPDATE na tabela customer - fin
			
			
			// DELETE na tabela customer - ini
			/*
			CustomerDAO dao = new CustomerDAO(connection);
			
			Customer oldCustomer = dao.findById(220);
			System.out.println(oldCustomer.toString());
			
			oldCustomer.setAddress("Rua João Paulo II");
			oldCustomer.setEmail("manuel.das.couves@gmail.com");
			
			Customer newCustomer = dao.create(oldCustomer);
			
			System.out.println(newCustomer.toString());
			
			dao.delete(newCustomer.getId());
			*/
			// DELETE na tabela customer - fin			
			
			// SELECT de uma order, usando um join - ini
			OrderDAO dao = new OrderDAO(connection);
			
			Order newOrder = dao.findById(1066);                  // obtem uma order usando o seu order id
			
			//System.out.println(newOrder.toString());
			System.out.println("Order id            : " + newOrder.getOrderId());
			System.out.println("Customer first name : " + newOrder.getCustomerFirstName());
			System.out.println("Customer last name : " + newOrder.getCustomerLastName());
			System.out.println("Customer email     : " + newOrder.getCustomerEmail());
			System.out.println("Total due : " + newOrder.getTotalDue());
			System.out.println("Status : " + newOrder.getStatus());
			System.out.println("------------------------------------------ ");
			List<OrderLine> orderLines = newOrder.getOrderLines();
			
			for (OrderLine ol : orderLines) {
				System.out.println("Quantidade : " + ol.getProductQuantity() + " | Nome : " + ol.getProductName());				
			}
			// SELECT de uma order, usando um join - fim
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

}
