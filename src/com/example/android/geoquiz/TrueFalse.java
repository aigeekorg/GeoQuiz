package com.example.android.geoquiz;




/**
 * 
 * @author yaokun
 * 模型类，用于存放问题及相应的答案
 *
 */
public class TrueFalse {
	private int mQuestion;//资源ID 都是INT类型的
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
