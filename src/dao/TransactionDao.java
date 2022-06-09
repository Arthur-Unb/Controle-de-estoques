package dao;

import java.util.List;

import entities.Transaction;

public interface TransactionDao {

	void insert(Transaction obj);

	void update(Transaction obj);

	Transaction findById(Integer id);
	List<Transaction> findAll();
	

}
