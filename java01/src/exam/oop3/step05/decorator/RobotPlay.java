package exam.oop3.step05.decorator;

public class RobotPlay {
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		//InvisibleDecorator robot3 = new InvisibleDecorator(robot);
		GunDecorator gun = new GunDecorator(robot);
		FlyDecorator robot2 = new FlyDecorator(gun);
		//robot.move();
		//flyRobot.move();
		robot2.move();
	}
}
