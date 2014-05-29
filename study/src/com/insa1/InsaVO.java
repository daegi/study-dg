package com.insa1;

public class InsaVO {
	private String sabun, name;
	private int pay, tax, silpay;

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getTax() {
		// 200�̻�->3%, 150�̻�->1%, ������ 0
		tax = 0;
		if (pay >= 2000000)
			tax = (int) (pay * 0.03);
		else if (pay >= 1500000)
			tax = (int) (pay * 0.01);

		// tax=(tax+5)/10*10;

		return tax;
	}

	public int getSilpay() {
		silpay = pay - tax;
		return silpay;
	}
}
