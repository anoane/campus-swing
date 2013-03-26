package com.sun.pdfview;

import gui.Home;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Viewer {
	
	private static JFrame frame;
	

    public static void main(String args[]) {
        String fileName = null;
        boolean useThumbs = true;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-noThumb")) {
                useThumbs = false;
            } else if (args[i].equalsIgnoreCase("-help") ||
                    args[i].equalsIgnoreCase("-h") ||
                    args[i].equalsIgnoreCase("-?")) {
                System.out.println("java com.sun.awc.PDFViewer [flags] [file]");
                System.out.println("flags: [-noThumb] [-help or -h or -?]");
                System.exit(0);
            } else {
                fileName = args[i];
            }
        }
        // start the viewer
        CopyOfPDFViewer viewer;
        viewer = new CopyOfPDFViewer(useThumbs);
        if (fileName != null) {
            viewer.doOpen(fileName);
        }
        
        setFrame(new JFrame());

		// resizable
		getFrame().add(viewer);
		getFrame().setBounds(0,0,521,521);
		//Window thread
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
	public static void setFrame(JFrame frame) {
		Viewer.frame = frame;
	}
	public static JFrame getFrame() {
		return frame;
	}
}
