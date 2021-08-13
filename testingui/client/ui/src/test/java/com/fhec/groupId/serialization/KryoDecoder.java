package com.fhec.groupId.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class KryoDecoder extends LengthFieldBasedFrameDecoder {

    /**
     * 10485760 解码时，处理每个帧数据的最大长度
     *        0 该帧数据中，存放该帧数据的长度的数据的起始位置
     *        4 记录该帧数据长度的字段本身的长度
     *        0 修改帧数据长度字段中定义的值，可以为负数
     *        4 解析的时候需要跳过的字节数
     */
    public KryoDecoder(){
        super(10485760, 0, 4, 0, 4);
    }

	@Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        //调用父类获取缓冲区码流
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }
        try {
            //通过构造器规则反序列化
            return KryoSerializer.deserialize(frame);
        } finally {
            if (null != frame) {
                //释放缓冲区资源
                frame.release();
            }
        }

    }
	
}
