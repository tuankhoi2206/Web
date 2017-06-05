package model;

import java.util.List;

import entities.Batch;

public class SchoolModel {

	private Batch selectedBatch;
	private List<Batch> batches;

	public Batch getSelectedBatch() {
		return selectedBatch;
	}

	public void setSelectedBatch(Batch selectedBatch) {
		this.selectedBatch = selectedBatch;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

}
