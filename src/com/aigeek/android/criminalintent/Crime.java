package com.aigeek.android.criminalintent;


import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author Administrator
 *@describe 这个类属于project CriminalIntent的模型层
 */
public class Crime {
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public Crime(){
		//生成唯一标识符，根据RFC4122文档 得到
		mId = UUID.randomUUID();
		//设置发生时间
		//Initializes this Date instance to the current time.
		mDate = new Date();
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public UUID getmId() {
		return mId;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}
	

}
