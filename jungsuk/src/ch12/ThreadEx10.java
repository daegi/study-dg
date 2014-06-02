package ch12;

public class ThreadEx10 {

	public static void main(String[] args) {

		// ThreadGroup(String name) : ������ �̸��� ���ο� ������ �׷��� �����Ѵ�.
		// currentThread() : ���� �������� �������� ������ ������
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		ThreadGroup subGrp1 = new ThreadGroup(grp1, "subGroup1");

		// setMaxPriority(int pri) : ������ �׷��� �ִ�켱�� ���� �����Ѵ�.
		grp1.setMaxPriority(3);

		Thread th1 = new Thread(grp1, "th1");
		Thread th2 = new Thread(subGrp1, "th2");
		Thread th3 = new Thread(grp2, "th3");

		th1.start();
		th2.start();
		th3.start();

		//activeGroupCount() : ������ �׷쿡 ���Ե� Ȱ�����¿� �ִ� ������ �׷��� ���� ��ȯ�Ѵ�.
		//activeCount():������ �׷쿡 ���Ե� Ȱ�����¿� �ִ� �������� ���� ��ȯ �Ѵ�.
		System.out.println("List of ThreadGrop :" + main.getName()
				+ ", Active ThreadGroup:" + main.activeGroupCount()
				+ ", Active thread:" + main.activeCount());
		main.list();
		// ������ �׷쳻�� ������ ���
	}
}
