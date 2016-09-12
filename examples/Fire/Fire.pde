import P5ireBase.library.*;

P5ireBase fire;
void setup() {
  size(400, 400);
  fire = new P5ireBase(this, "https://yourAppName.firebaseio.com/");//put here ur DB link created in firebase console
}

void mousePressed() {
  fire.setValue("Nombre", "Amarito");//Set info to specific key in FireBase
  println(fire.getValue("Nombre"));//Get info from specific key
}
