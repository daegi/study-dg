package ch14;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {

	public static void main(String[] args) {
		// input쓰레드 output 쓰레드 2개 생성
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");

		// 쓰레드 연결
		inThread.connect(outThread.getOutput());

		// 쓰레드 간 메시지 시작
		inThread.start();
		outThread.start();

	}
}

class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();

	// CharArrayWriter 처럼 메모리를 사용하는 스트림 String Buffer를 가지고 있어서 출력하는 내용저장

	InputThread(String name) {
		super(name);
	}

	public void run() {
		int data = 0;

		try {
			// 데이터가 없을때까지 인스턴스 변수 sw 저장
			while ((data = input.read()) != -1) {
				sw.write(data);
			}
			// getname() => 쓰레드 이름은 Input Thread 즉 Input Thread received msg에서  읽어온값
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
			// 파이프로 연결된 리더를 파이프로 연결된 라이터 src 에 접속
			// 이 객체가 다른 파이프로 연결된 라이터에 접속되고 있는 경우는,IOException 가 throw
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
		//주고 받을 메시지
		String msg = "Hello";
		//OutputThread sent "msg"
		System.out.println(getName() + " sent:" + msg);
		try {
			output.write(msg);
			
			//파이프로 연결된 출력 스트림을 닫아 이 스트림에 관련하는 모든 system resource를 해제
			//이후 메시지 동기 불가
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