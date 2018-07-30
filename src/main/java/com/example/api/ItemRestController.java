package com.example.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Item;
import com.example.servise.ItemService;

@RestController
//@RequestMapping("api/items")
public class ItemRestController {
    @Autowired
    ItemService itemService;
    
	@RequestMapping(value ="api/items", method = RequestMethod.GET)
	@ResponseBody
    List<Item> getItems(){
    List<Item> customers = itemService.findAll();
    return customers;
    	
    }
 
	  // リクエスト /hello に対して実行されるメソッド。
	  @RequestMapping("/hello")
	  public Map<String, String> hello() {
	    return Collections.singletonMap("message", "Hello, World!");
	  }
}
