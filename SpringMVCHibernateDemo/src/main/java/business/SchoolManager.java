package business;

import java.util.List;

import model.SchoolModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.BatchDAO;
import dao.StudentDAO;
import entities.Batch;
import entities.Student;

@Transactional
public class SchoolManager {

	@Autowired
	private BatchDAO batchDAO;

	@Autowired
	private StudentDAO studentDAO;

	public void getBatchInfo(SchoolModel schoolModel) {

		Batch selectedBatch = schoolModel.getSelectedBatch();
		List<Batch> batches = batchDAO.getBatchList();
		if (selectedBatch != null) {
			Integer batchId = selectedBatch.getBatchId();
			for (Batch batch : batches) {
				if (batch.getBatchId().equals(batchId)) {
					selectedBatch = batch;
					break;
				}
			}
		} else {
			selectedBatch = batches.get(0);
		}
		schoolModel.setBatches(batches);
		schoolModel.setSelectedBatch(selectedBatch);
	}

	public void addBatch(Batch batch, Student student) {
		/*Điểm chen lấn đuợc gọi là joinpoint (điểm nối )*/
		//transaction.begin() this is joinpoint
		batchDAO.addBatch(batch);
		student.setBatch(batch);
		if (batch != null) {
			throw new RuntimeException();
		}
		studentDAO.addStudent(student);
		//transaction.rollback() this is joinpoint
	}

	public BatchDAO getBatchDAO() {
		return batchDAO;
	}

	public void setBatchDAO(BatchDAO batchDAO) {
		this.batchDAO = batchDAO;
	}
}
