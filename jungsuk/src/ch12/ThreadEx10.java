package ch12;

public class ThreadEx10 {

	public static void main(String[] args) {

		// ThreadGroup(String name) : 지정된 이름의 새로운 쓰레드 그룹을 생성한다.
		// currentThread() : 현재 실행중인 쓰레드의 참조를 돌려줌
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		ThreadGroup subGrp1 = new ThreadGroup(grp1, "subGroup1");

		// setMaxPriority(int pri) : 쓰레드 그룹의 최대우선순 위를 설정한다.
		grp1.setMaxPriority(3);

		Thread th1 = new Thread(grp1, "th1");
		Thread th2 = new Thread(subGrp1, "th2");
		Thread th3 = new Thread(grp2, "th3");

		th1.start();
		th2.start();
		th3.start();

		//activeGroupCount() : 쓰레드 그룹에 포함된 활성상태에 있는 쓰레드 그룹의 수를 반환한다.
		//activeCount():쓰레드 그룹에 포함된 활성상태에 있는 쓰레드의 수를 반환 한다.
		System.out.println("List of ThreadGrop :" + main.getName()
				+ ", Active ThreadGroup:" + main.activeGroupCount()
				+ ", Active thread:" + main.activeCount());
		main.list();
		// 쓰레드 그룹내에 정보를 출력
	}
}
