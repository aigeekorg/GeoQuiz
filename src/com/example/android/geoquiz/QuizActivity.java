package com.example.android.geoquiz;

import android.R.bool;
import android.R.integer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private int mCurrentIndex = 0;
	

	/*
	 *�������飬���ڴ�����⼰��
	 */
	private TrueFalse[] mQuestionBank = new TrueFalse[]{
		new TrueFalse(R.string.question_oceans,true),
		new TrueFalse(R.string.question_mideast, false),
		new TrueFalse(R.string.question_africa, false),
		new TrueFalse(R.string.question_americas,true),
		new TrueFalse(R.string.question_asia,true),
	};
	

	/*
	 * ���ڻ�ȡ��˽�з���
	 */
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	/*
	 * ���ڼ��𰸲��ж϶Դ�������toast��ʾ�ķ���
	 */
	private void checkAnswer(boolean userPerssedTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		int messagedResId = 0;
		if(userPerssedTrue == answerIsTrue){
			messagedResId = R.string.correct_toast;
		}else{
			messagedResId = R.string.incorrect_toast;
		}
		
		Toast.makeText(this, messagedResId, Toast.LENGTH_SHORT).show();
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		
		
		updateQuestion();
//		int question = mQuestionBank[mCurrentIndex].getQuestion();
//		mQuestionTextView.setText(question);
		
		

		//true��ť������
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){

				checkAnswer(true);
//				
//				//Does nothing yet, but soon!
//				Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
//				//����ֱ������this����Ϊ�����������ڲ��࣬thisָ���Ǽ�����View.OnClickListener
//				//��ҪToast.makeText(...).show()����show()������ʾ

			}
		});
		

		//false��ť������
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				checkAnswer(true);
				
//				
//				//Does nothing yet,but soon!
//				Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
			}
		});
		

		//next��ť������
		mNextButton = (Button)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//���Ϊ0�������ã���������Ϊ1����ʾ�ڶ������ݣ����Ϊ���һ����������Ϊ��һ����ʾ����
				//����lengthΪ5��mCurrentIndexΪ0-4
				mCurrentIndex = (mCurrentIndex +1)%mQuestionBank.length;
				
				updateQuestion();
//				int question = mQuestionBank[mCurrentIndex].getQuestion();
//				mQuestionTextView.setText(question);
			}
		});
		//�ı���ʾ��ʼ��
		updateQuestion();
	}
}
