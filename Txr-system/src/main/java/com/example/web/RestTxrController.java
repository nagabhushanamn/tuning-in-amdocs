package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TxrRequestQueue;

@RestController
public class RestTxrController {

	@Autowired
	private TxrRequestQueue txRequestQueue;

	@RequestMapping(value = "/api/txr", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody TxrResponse txrForm(@RequestBody TxrRequest request, Model model) {
		txRequestQueue.addTxrRequest(request);
		TxrResponse response = new TxrResponse();
		response.setStatus("Txr initiated successfully");
		return response;
	}

}
