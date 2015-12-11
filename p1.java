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

///next frame: scene, monster, hero, gold.///
void draw(){
  scene();
  gold();
  mon();
  hero();
  reset();
  
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
  fill(0); ellipse(goldX+200,goldY+300,40,30);
  fill(250,243,96); ellipse( goldX+200,goldY+300,10,10);
  ellipse( goldX+202,goldY+303,10,10);
  ellipse( goldX+204,goldY+305,10,10);
  ellipse( goldX+190,goldY+300,10,10);
  ellipse( goldX+209,goldY+300,10,10);
}

void mon(){
  fill(0); ellipse(monX+300,monY+350,20,20); //head//
  fill(0); ellipse(monX+300,monY+365,20,25); //body//
  fill(0); ellipse(monX+300,monY+385,20,30); // lower body//
  fill(0); line(monX+300,monY+365,monX+260,monY+365); //body:left leg//
  fill(0); line(monX+290,monY+365,monX+340,monY+365);// body: right leg//
  fill(0); line(monX+300,monY+385,monX+260,monY+385); //lower body: left leg//
  fill(0); line(monX+290,monY+385,monX+340,monY+385); //lower body: right leg// 
}

void hero(){
  fill(0); rect(heroX+400,heroY+400,40,40); //body//
  fill(0); ellipse(heroX+420,heroY+380,40,40); //head//
  fill(0); line(heroX+399,heroY+410,heroX+370,heroY+380); //left arm//
  fill(0); line(heroX+440,heroY+410,heroX+470,heroY+380); //right arm//
  fill(0); line(heroX+410,heroY+440,heroX+410,heroY+465); //leftleg//
  fill(0); line(heroX+430,heroY+440,heroX+430,heroY+465); //right leg//
}

void reset(){
 // goldX=goldX+1; goldY = goldY+random(1,4);
  heroX=heroX+1; heroY= heroY-1;
  heroX = heroX +(goldX-heroX)/150;
  heroY += (goldY-heroY)/150;
 
  
}
