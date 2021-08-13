package com.fhec.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;

/**
 * Kryo序列化、反序列化
 * @author yinjihuan
 *
 */
public class KryoSerializer {

	//初始化工厂
	private static final KryoFactory kryoFactory = new KryoFactory();
	//初始化消息头
	private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

	/**
     * kryo序列化对象
	 * @param object
     * @param out
     * @throws Exception
	 */
	public static void serialize(Object object, ByteBuf out) throws IOException, Exception{
		Kryo kryo = kryoFactory.getKryo();
		ByteBufOutputStream bos = new ByteBufOutputStream(out);
		//4个字节作为包头，存放消息长度
		bos.write(LENGTH_PLACEHOLDER);
        Output output = new Output(bos);
        kryo.writeClassAndObject(output, object);
        output.flush();
        output.close();
		//释放kryo
		kryoFactory.returnKryo(kryo);
	}

	/**
     * kryo反序列化对象
	 * @param in
     * @return
     * @throws Exception
	 */
	public static Object deserialize(ByteBuf in) throws IOException, Exception{
		Input input = new Input(new ByteBufInputStream(in));
		Kryo kryo = kryoFactory.getKryo();
		Object res = kryo.readClassAndObject(input);
		input.close();
		//释放对象
		kryoFactory.returnKryo(kryo);
		return res;
	}
}