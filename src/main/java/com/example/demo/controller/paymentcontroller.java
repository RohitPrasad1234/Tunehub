package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entitys.users;
import com.example.demo.services.userservices;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Controller
public class paymentcontroller {
	@Autowired
	userservices service;

	@GetMapping("/pay")
	public String pay() {
		return "pay";
	}

	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(HttpSession session) {

		int amount = 5000;
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_QBNONjTtjpouXV", "ypPqUPJ0wlvafzj4Z973YK5x");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount * 100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			order = razorpay.orders.create(orderRequest);

			String email = (String) session.getAttribute("email");

			users u = service.getUser(email);
			u.setPremium(true);
			service.updateuser(u);
            return "viewsongs";
		} catch (RazorpayException e) {
			e.printStackTrace();
		} finally {
			return order.toString();
		}
		
		
		
	}
}

