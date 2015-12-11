package com.aigeek.android.criminalintent;


import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author Administrator
 *@describe ���������project CriminalIntent��ģ�Ͳ�
 */
public class Crime {
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public Crime(){
		//����Ψһ��ʶ��������RFC4122�ĵ� �õ�
		mId = UUID.randomUUID();
		//���÷���ʱ��
		//Initializes this Date instance to the current time.
		mDate = new Date();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mTitle;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public UUID getId() {
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