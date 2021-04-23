//making coordinates variables
int facex=150, facey=10, faceH=100;
int eye1x=175, eye1y=40, eye1W=10, eye1H=30;
int eye2x=225, eye2y=40, eye2W=10, eye2H=30;
int mouthx1=165, mouthy1=-100, mouthx2=175, mouthy2=75, mouthx3=225, mouthy3=75, mouthx4=215, mouthy4=-100;

int neck1x=185, neck1y=110, neck1P1=185, neck1P2=150;
int neck2x=215, neck2y=110, neck2P1=215, neck2P2=150;

int bodyX=150, bodyY=150, bodyW=100, bodyH=160;

int armL1x=150, armL1y=170, armL1P1=85, armL1P2=170;
int armL2x=150, armL2y=185, armL2P1=85, armL2P2=185;

int armR1x=315, armR1y=170, armR1P1=250, armR1P2=170;
int armR2x=315, armR2y=185, armR2P1=250, armR2P2=185;

int legL1x=160, legL1y=310, legL1P1=160, legL1P2=390;
int legL2x=175, legL2y=310, legL2P1=175, legL2P2=390;

int legR1x=241, legR1y=310, legR1P1=241, legR1P2=390;
int legR2x=226, legR2y=310, legR2P1=226, legR2P2=390;


void setup() {
  size(400, 400);
}

void draw() {
  background(#CECCCC);  //resets background
  frameRate(80);        //speed up animation

  //decrement to move robot to top-left corner
  square (--facex, --facey, faceH);
  ellipse (--eye1x, --eye1y, eye1W, eye1H);
  ellipse (--eye2x, --eye2y, eye2W, eye2H);
  curve (--mouthx1, --mouthy1, --mouthx2, --mouthy2, --mouthx3, --mouthy3, --mouthx4, --mouthy4);

  line (--neck1x, --neck1y, --neck1P1, --neck1P2);
  line (--neck2x, --neck2y, --neck2P1, --neck2P2);

  rect (--bodyX, --bodyY, bodyW, bodyH);

  line (--armL1x, --armL1y, --armL1P1, --armL1P2);
  line (--armL2x, --armL2y, --armL2P1, --armL2P2);

  line (--armR1x, --armR1y, --armR1P1, --armR1P2);
  line (--armR2x, --armR2y, --armR2P1, --armR2P2);

  line (--legL1x, --legL1y, --legL1P1, --legL1P2);
  line (--legL2x, --legL2y, --legL2P1, --legL2P2);

  line (--legR1x, --legR1y, --legR1P1, --legR1P2);
  line (--legR2x, --legR2y, --legR2P1, --legR2P2);
}
