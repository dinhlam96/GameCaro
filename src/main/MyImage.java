package main;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class MyImage {

	private String urlImg = ".."+ File.separator+"images"+ File.separator;
	private Image imgCross;
	private Image imgNought;
	
	public MyImage(){
		int size = Graphics.sizeCell - 2;
		setImgCross(resizeImg(getImageIcon("cross.gif"), size, size));
		setImgNought(resizeImg(getImageIcon("nought.gif"), size, size));
	}
	
	public Image resizeImg(Image img, int width, int height){
		img = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH)).getImage();
		return img;
	}
	
	public Image getImageIcon(String nameImgIcon){
		Image img = new ImageIcon(getClass().getResource(urlImg + nameImgIcon)).getImage();
		return img;
	}

	public Image getImgCross() {
		return imgCross;
	}

	public void setImgCross(Image imgCross) {
		this.imgCross = imgCross;
	}

	public Image getImgNought() {
		return imgNought;
	}

	public void setImgNought(Image imgNought) {
		this.imgNought = imgNought;
	}
}
