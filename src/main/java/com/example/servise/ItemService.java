package com.example.servise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * @author akimoto
 *
 */
@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;

	/*
	 * 商品一覧取得サービス
	 * 
	 * @return List<item>
	 */
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

}
