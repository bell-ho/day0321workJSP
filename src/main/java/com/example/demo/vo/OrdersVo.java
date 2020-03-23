package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrdersVo {
	private int orderno;
	private int memberno;
	private int stockno;
	private int orderqty;
	private int price;
}
