package ch14;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {

	public static void main(String[] args) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);

		byte[] result = null;

		try {
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);

			result = bos.toByteArray();

			String[] hex = new String[result.length];

			for (int i = 0; i < result.length; i++) {
				if (result[i] < 0) {
					hex[i] = Integer.toHexString(result[i] + 256);
				} else {
					hex[i] = Integer.toHexString(result[i]);
				}
			}

			System.out.println("10���� : " + Arrays.toString(result));
			System.out.println("16���� : " + Arrays.toString(hex));

			dos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
