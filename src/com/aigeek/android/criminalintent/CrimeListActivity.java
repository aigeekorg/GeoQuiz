package com.aigeek.android.criminalintent;

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {

	//子类继承了一个抽象类，就必须实现该抽象类中的抽象方法，
	//这里的子类是CrimeListActivity，继承的抽象类是SingleFragmentActivity，
	//可以查看该抽象类中的抽象方法是 protected abstract Fragment createFragment();
	//所以建立该方法时，勾选abstract并选好父类，该类在生成时会自动构建出实现该抽象方法的方法。
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeListFragment();
	}

}
