package com.fgrim.msnake;



import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class GenerateChart extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        
      
				openChart();				
		
        
    }
    
    private void openChart(){    	
    	
    	
    	
    	// Pie Chart Section Names
    	String[] code = new String[] {"Up", "Left", "Right","Down"};    	
    	
    	// Pie Chart Section Value
    	double[] distribution = { 20,31,32,27} ;
    	
    	// Color of each Pie Chart Sections
    	int[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.CYAN };
    	
    	
    	// Instantiating CategorySeries to plot Pie Chart    	
    	CategorySeries distributionSeries = new CategorySeries(" Android version distribution as on October 1, 2012");
    	    	
    	
    	for(int i=0 ;i < distribution.length;i++){
    		// Adding a slice with its values and name to the Pie Chart
    		distributionSeries.add(code[i], distribution[i]);
    	}   
    	
    	// Instantiating a renderer for the Pie Chart
    	DefaultRenderer defaultRenderer  = new DefaultRenderer();    	
    	for(int i = 0 ;i<distribution.length;i++){    		
    		SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();    	
    		seriesRenderer.setColor(colors[i]);
    		/*seriesRenderer.setDisplayChartValues(true);*/
    		// Adding a renderer for a slice
    		defaultRenderer.addSeriesRenderer(seriesRenderer);
    	}
    	
    	//defaultRenderer.setChartTitle("Android version distribution as on October 1, 2012 ");
    	//defaultRenderer.setChartTitleTextSize(20);
    	//defaultRenderer.setZoomButtonsVisible(true);    	    		
    		
    	// Creating an intent to plot bar chart using dataset and multipleRenderer    	
    	Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries , defaultRenderer, "Tetris Gustures PieChart");    	
    	
    	// Start Activity
    	startActivity(intent);
    	
    }

    
}