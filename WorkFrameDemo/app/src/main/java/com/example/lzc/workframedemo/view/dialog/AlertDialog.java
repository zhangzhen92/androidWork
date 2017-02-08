package com.example.lzc.workframedemo.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.lzc.workframedemo.R;

/**
 * 类描述：提示对话框
 * 创建人：zz
 * 创建时间：2016/11/25 14:24
 */
public class AlertDialog {
	private Context context;
	private Dialog dialog;
	private LinearLayout lLayout_bg;
	private TextView txt_title;
	private TextView txt_msg;
	private Button btn_neg;
	private Button btn_pos;
	private ImageView img_line;
	private Display display;
	private boolean showTitle = false;
	private boolean showTitleImg = false;
	private boolean showMsg = false;
	private boolean showPosBtn = false;
	private boolean showNegBtn = false;
	private ImageView img_title;

	public AlertDialog(Context context) {
		this.context = context;
		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		display = windowManager.getDefaultDisplay();
	}

	public AlertDialog builder() {
		View view = LayoutInflater.from(context).inflate(
				R.layout.view_alertdialog, null);

		lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
		txt_title = (TextView) view.findViewById(R.id.txt_title);
		txt_title.setVisibility(View.GONE);
		img_title = (ImageView) view.findViewById(R.id.img_title);
		txt_msg = (TextView) view.findViewById(R.id.txt_msg);
		txt_msg.setVisibility(View.GONE);
		btn_neg = (Button) view.findViewById(R.id.btn_neg);
		btn_neg.setVisibility(View.GONE);
		btn_pos = (Button) view.findViewById(R.id.btn_pos);
		btn_pos.setVisibility(View.GONE);
		img_line = (ImageView) view.findViewById(R.id.img_line);
		img_line.setVisibility(View.GONE);

		dialog = new Dialog(context, R.style.AlertDialogStyle);
		dialog.setContentView(view);

		lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
				.getWidth() * 0.7), LayoutParams.WRAP_CONTENT));

		return this;
	}

	public  boolean isShowing(){
		if(dialog != null){
			return dialog.isShowing();
		}
		return false;
	}

	public AlertDialog setTitle(String title) {
		showTitle = true;
		if ("".equals(title)) {
			txt_title.setText(R.string.title);
		} else {
			txt_title.setText(title);
		}
		return this;
	}

	/** 设置需要显示的图片(图片的大小)
	 *
	 * @param resId
	 * @return
     */
	public AlertDialog setTitleImg(@DrawableRes int resId) {
		showTitleImg = true;
		img_title.setImageResource(resId);
		return this;
	}

	/** 设置dialog显示图片,指定宽高
	 *
	 * @param resId
	 * @param width
	 * @param height
     * @return
     */
	public AlertDialog setTitleImg(@DrawableRes int resId,int width,int height) {
		this.setTitleImg(resId);
		ViewGroup.LayoutParams params = img_title.getLayoutParams();
		params.width = width;
		params.height = height;
		img_title.setLayoutParams(params);
		return this;
	}

	public AlertDialog setMsg(String msg) {
		showMsg = true;
		if ("".equals(msg)) {
			txt_msg.setText(R.string.content);
		} else {
			if(msg.length()>15){
				txt_msg.setTextSize(13);
			}
			txt_msg.setText(msg);
		}
		return this;
	}

	public AlertDialog setMsg(CharSequence msg, TextView.BufferType type) {
		showMsg = true;
		if ("".equals(msg)) {
			txt_msg.setText(R.string.content);
		} else {
			txt_msg.setText(msg,type);
		}
		return this;
	}

	public AlertDialog setCancelable(boolean cancel) {
		dialog.setCancelable(cancel);
		return this;
	}

	public AlertDialog setPositiveButton(String text,
										 final OnClickListener listener) {
		showPosBtn = true;
		if ("".equals(text)) {
			btn_pos.setText(R.string.OK);
		} else {
			btn_pos.setText(text);
		}
		btn_pos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				dialog.dismiss();
			}
		});
		return this;
	}

	public AlertDialog setPositiveButton(String text, int color, final OnClickListener listener) {
		showPosBtn = true;
		if ("".equals(text)) {
			btn_pos.setText(R.string.OK);
//			btn_pos.setTextColor(color);
		} else {
			btn_pos.setText(text);
//			btn_pos.setTextColor(color);
		}
		btn_pos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				dialog.dismiss();
			}
		});
		return this;
	}

	public AlertDialog setNegativeButton(String text,final OnClickListener listener) {
		showNegBtn = true;
		if ("".equals(text)) {
			btn_neg.setText(R.string.cancel);
		} else {
			btn_neg.setText(text);
		}
		btn_neg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				dialog.dismiss();
			}
		});
		return this;
	}

	public AlertDialog setNegativeButton(String text,int color,final OnClickListener listener) {
		showNegBtn = true;
		if ("".equals(text)) {
			btn_neg.setText(R.string.cancel);
//			btn_neg.setTextColor(color);
		} else {
			btn_neg.setText(text);
//			btn_neg.setTextColor(color);
		}
		btn_neg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick(v);
				dialog.dismiss();
			}
		});
		return this;
	}

	private void setLayout() {
		if (!showTitle && !showTitleImg && !showMsg) {
			txt_title.setText(R.string.tip);
			txt_title.setVisibility(View.VISIBLE);
		}

		if (showTitle) {
			txt_title.setVisibility(View.VISIBLE);
		}
		if(showTitleImg){
			img_title.setVisibility(View.VISIBLE);
		}

		if (showMsg) {
			txt_msg.setVisibility(View.VISIBLE);
		}

		if (!showPosBtn && !showNegBtn) {
			btn_pos.setText(R.string.OK);
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
			btn_pos.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
		}

		if (showPosBtn && showNegBtn) {
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
			img_line.setVisibility(View.VISIBLE);
		}

		if (showPosBtn && !showNegBtn) {
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}

		if (!showPosBtn && showNegBtn) {
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}
	}

	public void show() {
		if(!dialog.isShowing()) {
			setLayout();
			dialog.show();
		}
	}

	public void dismissDialog(){
		if(dialog != null && dialog.isShowing()){
			dialog.dismiss();
		}
	}

	public void setMsgSize(float size){
		txt_msg.setTextSize(size);
	}
}
