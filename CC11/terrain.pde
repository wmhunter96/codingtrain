int cols, rows;
int scale = 20;
int w = 600;
int h = 600;
float fly = 0;

float[][] tera;

void setup() {
  size(600, 500, P3D);
  
  cols = w/scale;
  rows = h/scale;
  tera = new float[cols][rows];
  
  
}

void draw() {
  fly += 0.1;
  float yoff = fly;
  for (int y = 0; y < rows; y++) { 
    float xoff = 0;
    for (int x = 0; x < cols; x++) {
      tera[x][y] = map(noise(xoff,yoff),0,1,-80,80);
      xoff += 0.2;
    }
    yoff += 0.2;
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
