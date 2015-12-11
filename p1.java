////  project 1:  hero, monster, gold
////  RF


///Globals///
float horizon;
float goldX, goldY;
float heroX, heroY;
float monX, monY;
float x,y;
float dx, dy;

///Setup: window size, etc. ///
void setup() {
  size(640, 480);
  horizon= height/3;
   reset();
}
void reset() {
  goldX=  random( width/4, width*3/4);
  goldY=  random( horizon+20, height-20 );
  heroX=  50;
  heroY=  random( horizon+20, height-20 );
  monX= width-50;
  monY=  random( horizon+20, height-20 );
}

///next frame: scene, monster, hero, gold.///
void draw(){
  scene();
  gold();
  mon();
  hero();
  action();
  text( "r key to reset; q to quit", width/4, 40 );
  
}
void mousePressed() {
  goldX=  mouseX;
  goldY=mouseY;
}
void keyPressed() {
  if (key == 'q') exit();
  if (key == 'r') reset();
}  

///scene: sky, sun , grass, house, trees.///
void scene(){
  background(200,200,255);   /// blue sky//
  fill(100,200,100); rect(0,horizon,width,height*2); /// green grass///
  fill(255,255,0); ellipse(width/2, height/14 , 40,40); ///sun//
 
  ///tree///
  fill(95,54,45); rect(500, horizon, 20, horizon-200);
  fill(100,200,100); ellipse(510,horizon-30,40,30);
  
  ///house///
 fill(190,222,201); rect( 200,horizon, 100, horizon-210);
 fill(222,20,20); triangle(200,horizon-50,300,horizon-50,250,horizon-80);//roof//
 fill(40,50,70); rect(220,horizon,25,horizon-190); //door//
}

///characters: gold, monster, hero///
void gold(){
  fill(0); ellipse(goldX, goldY, 40,30);
  fill(250,243,96); ellipse( goldX, goldY, 10,10);
  ellipse( goldX+2, goldY+3, 10,10);
  ellipse( goldX+4, goldY+5, 10,10);
  ellipse( goldX-10, goldY, 10,10);
  ellipse( goldX+9, goldY, 10,10);
}

void mon(){
  fill(0); ellipse(monX,monY, 20,20); //head//
  fill(0); ellipse(monX,monY+15, 20,25); //body//
  fill(0); ellipse(monX,monY+35, 20,30);               // lower body//
  fill(0); line(monX,monY+15, monX-40, monY+15);      //body:left leg//
  fill(0); line(monX-10,monY+15, monX+40,monY+15);    // body: right leg//
  fill(0); line(monX,monY+35, monX-40,monY+35);       //lower body: left leg//
  fill(0); line(monX-10,monY-15, monX+40,monY+35);    //lower body: right leg// 
}

void hero(){
  fill(0); rect(heroX,heroY, 40,40); //body//
  fill(0); ellipse(heroX+20,heroY-20, 40,40); //head//
  fill(0); line(heroX-1,heroY+10, heroX-30,heroY-20); //left arm//
  fill(0); line(heroX+40,heroY+10, heroX+470,heroY+380); //right arm//
  fill(0); line(heroX+10,heroY+40, heroX+410,heroY+465); //leftleg//
  fill(0); line(heroX+30, heroY+40, heroX+430,heroY+465); //right leg//
}

void action(){
 // goldX=goldX+1; goldY = goldY+random(1,4);
  heroX = heroX + (goldX-heroX)/150;
  heroY += (goldY-heroY)/150;
  monX += (heroX-monX)/150;
  monY += (heroY-monY)/150;
 
  
}
