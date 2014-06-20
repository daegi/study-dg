package ch14;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {

	public static void main(String[] args) {
		// input������ output ������ 2�� ����
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");

		// ������ ����
		inThread.connect(outThread.getOutput());

		// ������ �� �޽��� ����
		inThread.start();
		outThread.start();

	}
}

class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();

	// CharArrayWriter ó�� �޸𸮸� ����ϴ� ��Ʈ�� String Buffer�� ������ �־ ����ϴ� ��������

	InputThread(String name) {
		super(name);
	}

	public void run() {
		int data = 0;

		try {
			// �����Ͱ� ���������� �ν��Ͻ� ���� sw ����
			while ((data = input.read()) != -1) {
				sw.write(data);
			}
			// getname() => ������ �̸��� Input Thread �� Input Thread received msg����  �о�°�
			System.out.println(getName() + "received" + sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedReader getInput() {
		return input;
	}

	public void connect(PipedWriter output) {
		try {
			// �������� ����� ������ �������� ����� ������ src �� ����
			// �� ��ü�� �ٸ� �������� ����� �����Ϳ� ���ӵǰ� �ִ� ����,IOException �� throw
			input.connect(output);
		} catch (IOException e) {

		}

	}
}

class OutputThread extends Thread {
	PipedWriter output = new PipedWriter();

	OutputThread(String name) {
		super(name);
	}

	public void run() {
		//�ְ� ���� �޽���
		String msg = "Hello";
		//OutputThread sent "msg"
		System.out.println(getName() + " sent:" + msg);
		try {
			output.write(msg);
			
			//�������� ����� ��� ��Ʈ���� �ݾ� �� ��Ʈ���� �����ϴ� ��� system resource�� ����
			//���� �޽��� ���� �Ұ�
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedWriter getOutput() {
		return output;
	}

	public void connect(PipedReader input) {

		try {
			output.connect(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}