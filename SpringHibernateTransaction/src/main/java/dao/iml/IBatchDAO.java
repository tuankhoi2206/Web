package dao.iml;

import java.util.List;

import entity.Batch;

public interface IBatchDAO {
	void save(Batch batch);
	
	List<Batch> getBatchs();
	
}
