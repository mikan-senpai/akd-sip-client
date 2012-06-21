package org.linphone.ui;
/*
BubbleChat.java
Copyright (C) 2012  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
import org.linphone.R;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

/**
 * @author Sylvain Berfini
 */
public class BubbleChat {
	private RelativeLayout view;
	
	public BubbleChat(Context context, int id, String message, boolean isIncoming, int previousID) {
		view = new RelativeLayout(context);
    	
    	LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	
    	if (isIncoming) {
    		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    		view.setBackgroundResource(R.drawable.chat_bubble_incoming);
    	}
    	else {
    		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    		view.setBackgroundResource(R.drawable.chat_bubble_outgoing);
    	}
    	
    	if (previousID != -1) {
    		layoutParams.addRule(RelativeLayout.BELOW, previousID);
    	}

		TextView messageView = new TextView(context);    	
    	messageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    	messageView.setText(message);
    	messageView.setTextColor(Color.BLACK);

    	view.setId(id);
    	view.setLayoutParams(layoutParams);	
    	view.addView(messageView);
	}
	
	public View getView() {
		return view;
	}
}
