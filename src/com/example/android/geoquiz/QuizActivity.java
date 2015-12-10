package com.example.android.geoquiz;

import android.R.bool;
import android.R.integer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {
	
	private static final String TAG = "QuizActivity";
	private static final String KEY_INDEX = "index";
	
	private Button mTrueButton;
	private Button mFalseButton;
	private ImageButton mPreviousButton;
	private ImageButton mNextButton;
	private TextView mQuestionTextView;
	private int mCurrentIndex = 0;
	

	/*
	 *对象数组，用于存放问题及答案
	 */
	private TrueFalse[] mQuestionBank = new TrueFalse[]{
		new TrueFalse(R.string.question_oceans,true),
		new TrueFalse(R.string.question_mideast, false),
		new TrueFalse(R.string.question_africa, false),
		new TrueFalse(R.string.question_americas,true),
		new TrueFalse(R.string.question_asia,true),
	};
	

	/*
	 * 用于获取答案私有方法
	 */
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	/*
	 * 用于检查答案并判断对错，最后进行toast显示的方法
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
		Log.d(TAG, "onCreat(Bundle) called");//记录日志，d表示级别
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		mQuestionTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex +1)%mQuestionBank.length;
				
				updateQuestion();
			}
		});
		
		
		updateQuestion();
//		int question = mQuestionBank[mCurrentIndex].getQuestion();
//		mQuestionTextView.setText(question);
		
		

		//true按钮及监听
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){

				checkAnswer(true);
//				
//				//Does nothing yet, but soon!
//				Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
//				//不能直接输入this，因为这里是匿名内部类，this指的是监听器View.OnClickListener
//				//需要Toast.makeText(...).show()，有show()才能显示

			}
		});
		

		//false按钮及监听
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				checkAnswer(false);
				
//				
//				//Does nothing yet,but soon!
//				Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
			}
		});
		
		//previous按钮及监听
		mPreviousButton = (ImageButton)findViewById(R.id.previous_button);
		mPreviousButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//如果为0，则设置数组索引为4，显示第5个内容
				//这里length为5，mCurrentIndex为0-4
				if(mCurrentIndex == 0){
					mCurrentIndex = mQuestionBank.length-1;
				}else{
					mCurrentIndex = (mCurrentIndex -1)%mQuestionBank.length;
				}
				
				updateQuestion();
//				int question = mQuestionBank[mCurrentIndex].getQuestion();
//				mQuestionTextView.setText(question);
			}
		});
		
		//next按钮及监听
		mNextButton = (ImageButton)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//如果为0，则设置，数组索引为1，显示第二个内容，如果为最后一个，则设置为第一个显示内容
				//这里length为5，mCurrentIndex为0-4
				mCurrentIndex = (mCurrentIndex +1)%mQuestionBank.length;
				
				updateQuestion();
//				int question = mQuestionBank[mCurrentIndex].getQuestion();
//				mQuestionTextView.setText(question);
			}
		});
		if(savedInstanceState != null){
			mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
			Log.i(TAG, "取出onSaveInstaceState保存的值为="+mCurrentIndex);
		}
		//文本显示初始化
		updateQuestion();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "保存onSaveInstaceState");
		savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
	}
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart() called"); 
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume() called"); 
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause() called");
	}
	

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop() called");
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() called");
	}
}
