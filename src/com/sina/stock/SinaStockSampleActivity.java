package com.sina.stock;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;

import com.sina.stock.SinaStockInfo.ParseStockInfoException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SinaStockSampleActivity extends Activity implements OnClickListener{
    
	private Button btn;
	private TextView textView;
	private ImageView imageView;
	
	private SinaStockClient mClient;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        
        textView = (TextView) findViewById(R.id.txt);
        imageView = (ImageView) findViewById(R.id.image);
        
        initClient();
    }

    private void initClient() {
    	mClient = SinaStockClient.getInstance();
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*try {
			List<SinaStockInfo> list = mClient.getStockInfo(new String[]{"sh601006", "sh601001"});
			StringBuilder sb = new StringBuilder();
			
			if(list == null || list.size() == 0) {
				return;
			}
			
			int size = list.size();
			sb.append(list.get(0));
			for(int i = 1; i != size; ++i) {
				sb.append("\n\n" + list.get(i));
			}
			
			textView.setText(sb.toString());
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseStockInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			Bitmap bm = mClient.getStockImage("sh601006", SinaStockClient.IMAGE_TYPE_MONTHLY);
			imageView.setImageBitmap(bm);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}