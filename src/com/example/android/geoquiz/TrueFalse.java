package com.example.android.geoquiz;




/**
 * 
 * @author yaokun
 * ģ���࣬���ڴ�����⼰��Ӧ�Ĵ�
 *
 */
public class TrueFalse {
	private int mQuestion;//��ԴID ����INT���͵�
	private boolean mTrueQuestion;
	
	public TrueFalse(int question, boolean trueQuestion){
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
	
}	
