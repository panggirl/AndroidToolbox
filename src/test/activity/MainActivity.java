package test.activity;

import java.util.ArrayList;
import java.util.List;

import me.xiaopan.androidlibrary.R;
import me.xiaopan.androidlibrary.widget.ReboundListView;
import test.MyBaseActivity;
import test.adapter.ActivityAdapter;
import test.adapter.ActivityAdapter.ActivityItem;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 主页
 * @author xiaopan
 *
 */
public class MainActivity extends MyBaseActivity{
	private List<ActivityItem> activityItemList;
	private ReboundListView reboundListView;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.comm_simple_rebound_list);
		reboundListView = (ReboundListView) findViewById(android.R.id.list);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		reboundListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				startActivity(activityItemList.get(arg2 - reboundListView.getHeaderViewsCount()).getAction());
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		activityItemList = new ArrayList<ActivityItem>();
		activityItemList.add(new ActivityItem(getString(R.string.accessNetwork_title), AccessNetworkActivity.class));
		activityItemList.add(new ActivityItem(getString(R.string.systemWidget_title), SystemWidgetActivity.class));
		activityItemList.add(new ActivityItem(getString(R.string.customWidget_title), CustomWidgetActivity.class));
		activityItemList.add(new ActivityItem(getString(R.string.tools_title), ToolsActivity.class));
		activityItemList.add(new ActivityItem(getString(R.string.other_title), OtherActivity.class));
		
		reboundListView.setAdapter(new ActivityAdapter(getBaseContext(), activityItemList));
		
//		startActivity(DrawableActivity.class);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.comm, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected boolean isEnableBackHome() {
		return false;
	}

	@Override
	public boolean isEnableDoubleClickBackButtonExitApplication() {
		return true;
	}
}