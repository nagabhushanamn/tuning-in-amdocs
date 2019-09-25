package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.TxrRequestQueue;

@Controller
public class TxrController {

	@Autowired
	private TxrRequestQueue txRequestQueue;

	@GetMapping("/txr")
	public String txrForm() {
		return "txr-form";
	}

	@PostMapping("/txr")
	public String txr(@ModelAttribute TxrRequest request, Model model) {
		
		System.out.println("Txr initiated...by " + Thread.currentThread().getName());
		txRequestQueue.addTxrRequest(request);
		System.out.println("Txr completed...");
		
		TxrResponse response = new TxrResponse();
		response.setStatus("Txr successfull");
		model.addAttribute("response", response);

		return "txr-form";

	}

}
