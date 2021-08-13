package com.fhec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
public class KryoEncoder extends MessageToByteEncoder<Object> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Object object, ByteBuf out) throws Exception {
		//序列化
		KryoSerializer.serialize(object, out);
		//写数据包长度,
		out.setInt(0, out.writerIndex() - 4);
	}
	
}
