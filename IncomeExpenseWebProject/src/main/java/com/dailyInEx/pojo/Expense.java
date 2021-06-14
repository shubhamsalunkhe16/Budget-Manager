package com.dailyInEx.pojo;

public class Expense {
	private int id;
	private Double expense;
	private String expenseType;
	private String expenseDate;
	private int userId;

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expense=" + expense + ", expenseType=" + expenseType + ", expenseDate="
				+ expenseDate + ", userId=" + userId + ", description=" + description + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

}
