import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class codingtrain_Terrain_CC11 extends PApplet {

int cols, rows;
int scale = 20;
int w = 600;
int h = 600;
float fly = 0;

float[][] tera;

public void setup() {
  
  cols = w/scale;
  rows = h/scale;
  tera = new float[cols][rows];
}

public void draw() {
  fly += 0.1f;
  float yoff = fly;
  for (int y = 0; y < rows; y++) { 
    float xoff = 0;
    for (int x = 0; x < cols; x++) {
      tera[x][y] = map(noise(xoff,yoff),0,1,-80,80);
      xoff += 0.2f;
    }
    yoff += 0.2f;
  }
  
  background(0);
  stroke(255);
  noFill();
  translate(width/2, height/2);
  rotateX(-(PI/2+PI/10));
  translate(-w/2, -h/2);

  for (int y = 0; y < rows-1 ; y++) { 
    beginShape(TRIANGLE_STRIP);
    for (int x = 0; x < cols; x++) {
      vertex(x*scale, y*scale, tera[x][y]);
      vertex(x*scale, (y+1)*scale, tera[x][y+1]);
    }
    endShape();
  }
}
  public void settings() {  size(600, 500, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "codingtrain_Terrain_CC11" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
