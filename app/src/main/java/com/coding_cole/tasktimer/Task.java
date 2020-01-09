package com.coding_cole.tasktimer;

import java.io.Serializable;

public class Task implements Serializable {
	public static final long serialVersionUID = 20161120l;

	private long m_id;
	private final String mName;
	private final String mDescription;
	private final String mSortorder;

	public Task(long id, String mName, String mDescription, String mSortorder) {
		this.m_id = id;
		this.mName = mName;
		this.mDescription = mDescription;
		this.mSortorder = mSortorder;
	}

	public long getId() {
		return m_id;
	}

	public String getmName() {
		return mName;
	}

	public String getmDescription() {
		return mDescription;
	}

	public String getmSortorder() {
		return mSortorder;
	}

	public void setId(long id) {
		this.m_id = id;
	}

	@Override
	public String toString() {
		return "Task{" +
			"m_id=" + m_id +
			", mName='" + mName + '\'' +
			", mDescription='" + mDescription + '\'' +
			", mSortorder='" + mSortorder + '\'' +
			'}';
	}
}
