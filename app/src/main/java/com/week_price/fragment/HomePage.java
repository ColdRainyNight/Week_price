package com.week_price.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.week_price.R;
import com.week_price.fragmenttwo.ClassifyFragment;
import com.week_price.fragmenttwo.HotFragment;
import com.week_price.fragmenttwo.ListingFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private HomepageAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage, container, false);
        initView(view);
        initData(view);
        setData();
        return view;
    }

    private void setData() {
        mViewPager.setAdapter(mAdapter);
        //设置Viewpager和Tablayout进行联动
        mTabLayout.setupWithViewPager(mViewPager);
//        //将标题设置可以左右摇动而不是移动
//        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置预加载页数
//       mViewPager.setOffscreenPageLimit(3);

    }

    private void initData(View view) {
        //初始化导航标题,如果是title在json数据中,在初始化的时候可以使用异步任务加载的形式添加
        mTitles = new ArrayList<>();
        mTitles.add("热门");
        mTitles.add("分类");
        mTitles.add("榜单");
        mTitles.add("视频");
        mTitles.add("图片");
        mTitles.add("新闻");
        mTitles.add("篮球");
        mTitles.add("财经");
        mTitles.add("科技");
        mTitles.add("资讯");
        mTitles.add("电影");
        //初始化Fragment
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            if (i == 0) {
                mFragments.add(new HotFragment());
            } else if (i == 1) {
                mFragments.add(new ClassifyFragment());
            } else if (i == 2) {
                mFragments.add(new ListingFragment());
            } else if (i == 3) {
                mFragments.add(new ListingFragment());
            } else if (i == 4) {
                mFragments.add(new ListingFragment());
            } else if (i == 5) {
                mFragments.add(new ListingFragment());
            } else if (i == 6) {
                mFragments.add(new ListingFragment());
            }else if (i == 7) {
                mFragments.add(new ListingFragment());
            }else if (i == 8) {
                mFragments.add(new ListingFragment());
            }else if (i == 9) {
                mFragments.add(new ListingFragment());
            }else if (i == 10) {
                mFragments.add(new ListingFragment());
            }

        }
        //getSupportFragmentManager()是Activity嵌套fragment时使用
        //getChildFragmentManager()是Fragment嵌套Fragment时使用
        mAdapter = new HomepageAdapter(getChildFragmentManager(), mFragments, mTitles);
        mAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.vp);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
    }

    class HomepageAdapter extends FragmentPagerAdapter {
        public HomepageAdapter(FragmentManager fm, List<Fragment> framents, List<String> titles) {
            super(fm);
            mFragments = framents;
            mTitles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments == null ? 0 : mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}


