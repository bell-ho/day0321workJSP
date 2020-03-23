package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StockVo {
	 private int stockno;
	 private String stockname;
	 private int now;
	 private int max;
	 private int min;
	 private int qty;
}
