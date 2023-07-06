package db_service;

import java.util.ArrayList;

import db_dto.NewStDTO;

public interface DBService {
	public void display();
	public ArrayList<NewStDTO> getList();
	public NewStDTO search(String id);
	public int insert(String id, String name, int age);
}
