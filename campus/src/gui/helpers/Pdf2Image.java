package gui.helpers;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;


public class Pdf2Image {

	public static String pdf2img(File file) {

		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(file, "r");

			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			PDFFile pdffile = new PDFFile(buf);
			// draw the first page to an image
			
			//int num=pdffile.getNumPages();
			//for(int i=0;i<num;i++)
			if (pdffile.getNumPages()>0)
			{
				PDFPage page = pdffile.getPage(0);
				
				//get the width and height for the doc at the default zoom				
				int width=(int)page.getBBox().getWidth();
				int height=(int)page.getBBox().getHeight();	
				
				
				Dimension dim = ImageScaleAndFit.getScaledDimension(new Dimension(width,height), new Dimension(100,141));
				
				Double d_width = dim.getWidth();
				Double d_height = dim.getHeight();
				
				int new_width=d_width.intValue();
				int new_height=d_height.intValue();			
				
				
				Rectangle rect = new Rectangle(0,0,width,height);
				int rotation=page.getRotation();
				Rectangle rect1=rect;
				if(rotation==90 || rotation==270)
					rect1=new Rectangle(0,0,rect.height,rect.width);
				

				//generate the image
				BufferedImage img = (BufferedImage)page.getImage(
							rect.width, rect.height, //width & height
							rect1, // clip rect
							null, // null for the ImageObserver
							true, // fill background with white
							true  // block until drawing is done
					);
				img = ImageScaleAndFit.getScaledImage(img,new_width,new_height, 100, 141);
				String file_name = file.getName()+".png";
				ImageIO.write(img, "png", new File("thumb/"+file_name));
				return file_name;
			}
		} 
		catch (FileNotFoundException e1) {
			System.err.println(e1.getLocalizedMessage());
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
		return "";
	
	}
	
}
